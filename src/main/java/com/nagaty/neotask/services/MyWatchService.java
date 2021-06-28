package com.nagaty.neotask.services;

import com.nagaty.neotask.exceptions.InvalidWatchIDException;
import com.nagaty.neotask.models.Discount;
import com.nagaty.neotask.models.Watch;
import com.nagaty.neotask.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MyWatchService implements WatchService{
    @Autowired
    WatchRepository watchRepository;
    @Autowired
    DiscountService discountService;

    @Override
    public float calculateCartPrice(ArrayList<String> listOfWatchIDs) throws InvalidWatchIDException{
        float cartTotal = 0;
        // this map will hold the watchID mapped to occurrences in cart
        // this will make discount calculations easier
        HashMap<String, Integer> mapOfWatchIDtoOccurrences = convertListToMap(listOfWatchIDs);
        Iterator<Map.Entry<String, Integer>> iterator = mapOfWatchIDtoOccurrences.entrySet().iterator();

        // now lets iterate over the map and get the total for each watch (with discounts if applicable)
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String watchID = entry.getKey();
            int numberOfUnits = entry.getValue();

            // find all watches with the ID watchID(0 or 1)
            List<Watch> watches = watchRepository.findByWatchID(watchID);
            // if no watch with that ID is found, throw an exception
            if(watches == null || watches.isEmpty()){
                throw new InvalidWatchIDException();
            }
            // else, calculate the total price of this item (units included) and add it to the total
            // this calculation will also include any discounts if applicable
            else {
                Watch watch = watches.get(0);
                Discount discount = discountService.getDiscountsForWatch(watch);
                // if there is no discount
                if(discount == null){
                    cartTotal += watch.getUnitPrice() * numberOfUnits;
                }
                // if there is a discount
                else {
                    cartTotal += calculatePriceWithDiscount(watch, discount, numberOfUnits);
                }
            }
        }
        return cartTotal;
    }

    /*
    INPUT: list of watch IDs ie: ["001", "002", "001", "004", "003"]
    OUTPUT: Hashmap of occurences ie <"001" : 2, "002": 1, "003": 1, "004": 1]
    */
    private HashMap<String, Integer> convertListToMap(ArrayList<String> listOfWatchIDs){
        HashMap<String, Integer> map = new HashMap<>();
        for(String watchID: listOfWatchIDs){
            // get the value for key watchID (null if key does not exist)
            Integer value = map.get(watchID);
            // is the value null (key does not already exist) ? if it is then put a value of 1
            // if the value is not null (key exists) then simply increment value by 1 and put
            map.put(watchID, (value == null) ? 1 : value + 1);
        }
        return map;
    }
    /*
    INPUT:
    watch = Watch{..., unitPrice = 100.0},
    discount = Discount{..., min_units: 3, percentage: 0.33},
    numberOfUnits = 7

    OUTPUT: 500
     */
    private float calculatePriceWithDiscount(Watch watch, Discount discount, int numberOfUnits ){
        int numberOfDiscountedBatches = (numberOfUnits / discount.getMinUnits());
        int numberOfNonDiscountedWatches = numberOfUnits % discount.getMinUnits();
        float unitTotal = numberOfDiscountedBatches * discount.getPriceForMinUnits();
        unitTotal += numberOfNonDiscountedWatches * watch.getUnitPrice();

        return unitTotal;
    }

}
