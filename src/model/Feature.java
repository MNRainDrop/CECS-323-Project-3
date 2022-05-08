package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "features")
public class Feature 
{
    
    public Feature() {
    }

    public Feature(String name, Set<ModelFeatures> modelFeatures, Set<TrimFeatures> trimFeatures,
            Set<PackageFeatures> packageFeatures) {
        this.name = name;
        this.modelFeatures = modelFeatures;
        this.trimFeatures = trimFeatures;
        this.packageFeatures = packageFeatures;
    }

    @Column(unique = true, length = 100, name = "name", nullable = false)
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

    public Set<ModelFeatures> getModelFeatures() {
        return modelFeatures;
    }

    public void setModelFeatures(Set<ModelFeatures> modelFeatures) {
        this.modelFeatures = modelFeatures;
    }

    public Set<TrimFeatures> getTrimFeatures() {
        return trimFeatures;
    }

    public void setTrimFeatures(Set<TrimFeatures> trimFeatures) {
        this.trimFeatures = trimFeatures;
    }

    public Set<PackageFeatures> getPackageFeatures() {
        return packageFeatures;
    }

    public void setPackageFeatures(Set<PackageFeatures> packageFeatures) {
        this.packageFeatures = packageFeatures;
    }

    //Only Getters
    public int getFeatureID() {
        return featureID;
    }
}
