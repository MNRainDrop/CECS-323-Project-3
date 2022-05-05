package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="packages")
public class Package 
{
    @Column(length = 100, name = "name")
    private String name;

    //Primary key
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

    //Association with Trims, via the AvailablePackage
    //One to Many to AvailablePackages
    @OneToMany(mappedBy = "package")
    private Set<AvailablePackage> availablepackages;

    public int getPackageID()
    {
        return packageID;
    }

    public void setPackageID(int packageID) 
    {
        this.packageID = packageID;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}
