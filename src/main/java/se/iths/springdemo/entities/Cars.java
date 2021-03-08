package se.iths.springdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand;
    private String model;

    public Cars(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
