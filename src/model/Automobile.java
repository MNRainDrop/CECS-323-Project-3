package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile 
{
    
    public Automobile() {
    }

    public Automobile(String vin, Trim trim) {
        this.vin = vin;
        this.trim = trim;
    }

    @Column(unique = true, length = 100, name = "vin", nullable = false)
    private String vin;

    //Primary key 
    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoID;

    //Foreign key with trim
    //Many to One, Unidirectional
    @ManyToOne
    @JoinColumn(name = "trim_id", nullable = false)
    private Trim trim;

    //Association with AvailablePackage, via the ChosenPackage
    //One to Many to ChosenPackage
    @OneToMany(mappedBy = "automobile")
    private Set<ChosenPackage> chosenPackages;
    

    //Setters and Getters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Set<ChosenPackage> getChosenPackages() {
        return chosenPackages;
    }

    public void setChosenPackages(Set<ChosenPackage> chosenPackages) {
        this.chosenPackages = chosenPackages;
    }

    //Only Getter
    public int getAutoID() {
        return autoID;
    }


    public Set<Feature> getFeatures()
    {
        Set<Feature> features = new HashSet<Feature>();
        //Some magic here... idk yet
        return features;
    }
    
    public double stickerPrice()
    {
        double stickerPrice;
        double trimCost = trim.getCost();
        double packagesCost = 0;
        for(ChosenPackage pack : chosenPackages)
        {
            packagesCost += pack.getAvailablepackage().getCost();
        }
        stickerPrice = trimCost + packagesCost;
        System.out.println(trimCost + " + " + packagesCost + " = " + stickerPrice);
        return stickerPrice;
    }
}
