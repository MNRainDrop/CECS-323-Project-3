package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="availablepackages")
public class AvailablePackage
{
    @Column(name="cost", nullable = false)
    private float cost;

    @Id
    @Column(name = "available_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableID;

    @JoinColumn(name="trim_id", nullable = false)
    @ManyToOne
    private Trim trim;

    //(must use "pack" because "packages" is a keyword in Java)
    @JoinColumn(name="package_id", nullable = false)
    @ManyToOne
    private Package pack;

    //Association with Automobile, via the AvailablePackage
    //One to Many to ChosenPackage
    @OneToMany(mappedBy = "availablepackage")
    private Set<ChosenPackage> chosenPackages;


    //Setters and Getters
    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public Set<ChosenPackage> getChosenPackages() {
        return chosenPackages;
    }

    public void setChosenPackages(Set<ChosenPackage> chosenPackages) {
        this.chosenPackages = chosenPackages;
    }

    //Only Getter
    public int getAvailableID() {
        return availableID;
    }

}
