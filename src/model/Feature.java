package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "features")
public class Feature 
{
    @Column(unique = true, length = 100, name = "name")
    private String name;

    //Primary Key
    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureID;

    //Association with Features, via the ModelFeatures
    //One to Many to ModelFeatures
    @OneToMany(mappedBy = "feature")
    private Set<ModelFeatures> modelFeatures;
    
    //Association with Features, via the TrimFeatures
    //One to Many to TrimFeatures
    @OneToMany(mappedBy = "feature")
    private Set<TrimFeatures> trimFeatures;

    //Association with Features, via the PackageFeatures
    //One to Many to PackageFeatures
    @OneToMany(mappedBy = "feature")
    private Set<PackageFeatures> packageFeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
