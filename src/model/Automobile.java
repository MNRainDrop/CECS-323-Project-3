package model;

import java.util.*;
import jakarta.persistence.*;

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

    //Primary key 
    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoID;

    //Foreign key with trim
    //Many to One, Unidirectional
    @ManyToOne
    @JoinColumn(name = "trim_id" )
    private Trim trim;

    //Association with AvailablePackage, via the ChosenPackage
    //One to Many to ChosenPackage
    @OneToMany(mappedBy = "automobile")
    private Set<ChosenPackage> chosenPackages;
    
    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

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
