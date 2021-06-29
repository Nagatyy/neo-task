package com.nagaty.neotask.repositories;

import com.nagaty.neotask.models.Discount;
import com.nagaty.neotask.models.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    List<Discount> findByWatch(Watch watch);
}
