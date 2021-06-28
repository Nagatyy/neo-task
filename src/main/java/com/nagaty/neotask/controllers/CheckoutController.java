package com.nagaty.neotask.controllers;

import com.nagaty.neotask.exceptions.InvalidWatchIDException;
import com.nagaty.neotask.services.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CheckoutController {
    @Autowired
    private WatchService watchService;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkout(@RequestBody ArrayList<String> listOfWatchIDs){
        float cartTotal;
        try{
            cartTotal = watchService.calculateCartPrice(listOfWatchIDs);
        } catch (InvalidWatchIDException ex) {
            // to be handled by the CustomExceptionHandler
            throw ex;
        }
        // returning price as as float for accuracy
        HashMap<String, Float> map = new HashMap<>();
        map.put("price", cartTotal);
        return ResponseEntity.ok(map);
    }
}
