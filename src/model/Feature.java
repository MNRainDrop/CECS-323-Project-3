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

    //Many to Many with Models, bidirectional
    @ManyToMany(mappedBy = "modelfeatures")
    private Set<Model> modelfeatures;

    //Many to Many with Trims, bidirectional
    @ManyToMany(mappedBy = "trimfeatures")
    private Set<Trim> trimfeatures;

    //Many to Many with package, bidirectional
    @ManyToMany(mappedBy = "packagefeatures")
    private Set<Package> packagefeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Model> getModelfeatures() {
        return modelfeatures;
    }

    public void setModelfeatures(Set<Model> modelfeatures) {
        this.modelfeatures = modelfeatures;
    }

    public Set<Trim> getTrimfeatures() {
        return trimfeatures;
    }

    public void setTrimfeatures(Set<Trim> trimfeatures) {
        this.trimfeatures = trimfeatures;
    }

    public Set<Package> getPackagefeatures() {
        return packagefeatures;
    }

    public void setPackagefeatures(Set<Package> packagefeatures) {
        this.packagefeatures = packagefeatures;
    }

    //Only Getters
    public int getFeatureID() {
        return featureID;
    }
}
