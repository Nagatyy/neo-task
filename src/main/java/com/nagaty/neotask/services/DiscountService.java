package com.nagaty.neotask.services;

import com.nagaty.neotask.models.Discount;
import com.nagaty.neotask.models.Watch;


// to follow best practice, any discount service will implement from this interface
public interface DiscountService {
    public Discount getDiscountsForWatch(Watch watch);


}
