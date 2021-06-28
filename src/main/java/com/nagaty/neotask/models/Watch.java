package com.nagaty.neotask.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name="watches")
public class Watch {
    // this is an internal ID to be used for simplicity
    // it is different from watch_id below in that is is an int
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // I will add another 'watch_id' String as this is specified in the requirements
    @Column(name="watch_id", unique=true, nullable = false)
    private String watchID;
    @Column(name="watch_name", unique=true, nullable = false)
    private String watchName;
    @Column(name="unit_price", nullable = false)
    private float unitPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWatchID() {
        return watchID;
    }

    public void setWatchID(String watchID) {
        this.watchID = watchID;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "watchID=" + watchID +
                ", watchName='" + watchName + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watch watch = (Watch) o;
        return watchName.equals(watch.watchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchName);
    }
}