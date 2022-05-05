package model;

import java.util.*;
import jakarta.persistence.*;

public class Package 
{
    private String name;

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    //primary key
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

     //Parent Key of Package to AvailablePackage
    //One to Many
    @OneToMany(mappedBy = "package")
    private List<AvailablePackage> availablePackages;
}
