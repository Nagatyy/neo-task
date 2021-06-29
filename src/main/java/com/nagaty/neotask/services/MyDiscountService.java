package com.nagaty.neotask.services;

import com.nagaty.neotask.models.Discount;
import com.nagaty.neotask.models.Watch;
import com.nagaty.neotask.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDiscountService implements DiscountService{
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public Discount getDiscountsForWatch(Watch watch) {
        // although multiple discounts are possible, for simplicity, I will only take the first
        // (in a realistic situation we could return all and see which are applicable and which are not)
        List<Discount> discounts = discountRepository.findByWatch(watch);
//        if(discounts == null){
//            TODO: maybe throw an exception
//        }
        return discounts.isEmpty() ? null : discounts.get(0);
    }
}
