package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="packages")
public class Package 
{
   
    public Package() {
    }

    public Package(String name) {
        this.name = name;
    }

    //Primary key
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

    @Column(length = 100, name = "name", nullable = false)
    private String name;

    //Association with Trims, via the AvailablePackage
    //One to Many to AvailablePackages
    //(must use "pack" because "packages" is a keyword in Java)
    @OneToMany(mappedBy = "pack")
    private Set<AvailablePackage> availablePackages;

    //Many to Many with Features, bidirectional
    @JoinTable(
        name = "packagefeatures", 
        joinColumns = @JoinColumn(name = "package_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id",
        nullable = false)
    )
    @ManyToMany
    private Set<Feature> packagefeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Set<AvailablePackage> getAvailablePackages() {
        return availablePackages;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.availablePackages = availablePackages;
    }

    public Set<Feature> getPackagefeatures() {
        return packagefeatures;
    }

    public void setPackagefeatures(Set<Feature> packagefeatures) {
        this.packagefeatures = packagefeatures;
    }

    //Only Getters
    public int getPackageID() {
        return packageID;
    }

    public void addPackagefeatures(Feature feature) {
        packagefeatures.add(feature);
    }
}
