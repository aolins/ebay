package de.mobile.aol.data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aol on 2015.10.12..
 */
@Entity
@Table( name = "auto" )
@XmlRootElement
public class AutoEntry {
    public AutoEntry(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoEntry autoEntry = (AutoEntry) o;

        if (price != autoEntry.price) return false;
        if (id != null ? !id.equals(autoEntry.id) : autoEntry.id != null) return false;
        if (color != null ? !color.equals(autoEntry.color) : autoEntry.color != null) return false;
        if (make != null ? !make.equals(autoEntry.make) : autoEntry.make != null) return false;
        if (model != null ? !model.equals(autoEntry.model) : autoEntry.model != null) return false;
        if (bodyType != null ? !bodyType.equals(autoEntry.bodyType) : autoEntry.bodyType != null) return false;
        if (feature != null ? !feature.equals(autoEntry.feature) : autoEntry.feature != null) return false;
        return !(image != null ? !image.equals(autoEntry.image) : autoEntry.image != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
        result = 31 * result + (feature != null ? feature.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
    @Column
    String image = "no image";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
