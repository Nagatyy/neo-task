package com.nagaty.neotask.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
/*---
A discount on a watch will be represented using the Discount entity
One watch can have multiple discounts active - hence the ManyToOne mapping
A discount like '3 for 200' is essentially just a percentage discount with
a minimum number of units required.
Example: a watch with a unit price of 100 with a 3 for 200 discount is
essentially just a 33.33% discount when a min of 3 watches are purchased.
---*/

@Entity
//@Table(name="discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="discount_id")
    private int discountID;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "watch", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Watch watch;     // a discount will refer to a watch
    @Column(name="min_units", nullable = false)
    private int minUnits;
    @Column(nullable = false)
    private float percentage;

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public int getMinUnits() {
        return minUnits;
    }

    public void setMinUnits(int minUnits) {
        this.minUnits = minUnits;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountID=" + discountID +
                ", watch=" + watch +
                ", minUnits=" + minUnits +
                ", percentage=" + percentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return minUnits == discount.minUnits && Float.compare(discount.percentage, percentage) == 0 && watch.equals(discount.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watch, minUnits, percentage);
    }
}
