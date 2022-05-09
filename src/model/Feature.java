package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "features")
public class Feature 
{
    
    public Feature() {
    }

    public Feature(String name) {
        this.name = name;
    }

    @Column(unique = true, length = 100, name = "name", nullable = false)
    private String name;

    //Primary Key
    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureID;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Only Getters
    public int getFeatureID() {
        return featureID;
    }
}
