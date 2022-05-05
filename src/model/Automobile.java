package model;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "automobiles")
public class Automobile 
{
    @Column(unique = true, length = 100, name = "vin")
    private String vin;

    public String getVin() 
    {
        return vin;
    }

    public void setVin(String vin) 
    {
        this.vin = vin;
    }

    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoID;
    
    public int getAutoID() 
    {
        return autoID;
    }
    
    public void setAutoID(int autoID) 
    {
        this.autoID = autoID;
    }

    public Set<Feature> getFeatures()
    {
        Set<Feature> temp = new HashSet<Feature>(); //not sure what I am doing :D
        //addAll(temp);
        return temp;
    }

    public double stickerPrice()
    {
        //double total = AvailablePackage.getCost() + Trim.getCost(); //not sure what I am doing ):
        //return total;
        return 0; 
    }
}
