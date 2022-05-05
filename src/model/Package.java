package model;

import jakarta.persistence.*;

public class Package 
{
    @Column(length = 100, name = "name")
    private String name;

    //Primary key
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageID;

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
