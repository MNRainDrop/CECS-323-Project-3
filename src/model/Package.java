package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="packages")
public class Package 
{
    //Primary key
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

    @Column(length = 100, name = "name")
    private String name;

    //Association with Trims, via the AvailablePackage
    //One to Many to AvailablePackages
    //(must use "pack" because "packages" is a keyword in Java)
    @OneToMany(mappedBy = "pack")
    private Set<AvailablePackage> availablePackages;

    //Association with Features, via the PackageFeatures
    //One to Many to PackageFeatures
    //(must use "pack" because "packages" is a keyword in Java)
    @OneToMany(mappedBy = "pack")
    private Set<PackageFeatures> packageFeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
