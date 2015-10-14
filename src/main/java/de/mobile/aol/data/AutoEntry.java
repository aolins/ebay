package de.mobile.aol.data;

import javax.persistence.*;

/**
 * Created by aol on 2015.10.12..
 */
@Entity
@Table( name = "auto" )
public class AutoEntry {
    public AutoEntry(String color, String make, String model, String bodyType, String feature, int price) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.bodyType = bodyType;
        this.feature = feature;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    String color;
    @Column
    String make;
    @Column
    String model;
    @Column
    String bodyType;
    @Column
    String feature;
    @Column
    int price;


    @Override
    public String toString() {
        return "AutoEntry{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", feature='" + feature + '\'' +
                ", price=" + price +
                '}';
    }
}
