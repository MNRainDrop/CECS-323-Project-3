package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile implements Comparable<Automobile>
{
    
    public Automobile() {
    }

    public Automobile(String vin, Trim trim) {
        this.vin = vin;
        this.trim = trim;
    }

    @Override
    public String toString() {
        return vin + " (ID " + autoID + "), " + trim;
    }

    @Override
    public int compareTo(Automobile a)
    {
        return this.vin.compareTo(a.vin);
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

    //Many to Many with Available Package, bidirection
    @ManyToMany
    @JoinTable(
        name = "chosenpackages",
        joinColumns = @JoinColumn(name = "auto_id"),
        inverseJoinColumns = @JoinColumn(name = "available_id",
        nullable = false)
    )
    private Set<AvailablePackage> chosenpackages;


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

    public Set<AvailablePackage> getPacks() {
        return chosenpackages;
    }

    public void setPacks(Set<AvailablePackage> chosenpackages) {
        this.chosenpackages = chosenpackages;
    }

    //Only Getter
    public int getAutoID() {
        return autoID;
    }
    
    public void addChosenpackages(AvailablePackage availablePackage) {
        chosenpackages.add(availablePackage);
    }


    public ArrayList<Feature> getFeatures()
    {
        Set<Feature> features = new HashSet<Feature>();
        features.addAll(trim.getTrimfeatures());
        for(AvailablePackage pack : chosenpackages)
        {
            features.addAll(pack.getPack().getPackagefeatures());
        }
        features.addAll(trim.getModel().getModelfeatures());
        ArrayList<Feature> f = new ArrayList<>(features);
        return f;
    }
    
    public double stickerPrice()
    {
        double stickerPrice;
        double trimCost = trim.getCost();
        double packagesCost = 0;

        for (AvailablePackage pack: chosenpackages)
        {
            packagesCost += pack.getCost();
        }
        stickerPrice = trimCost + packagesCost;
        return stickerPrice;
    }

}
