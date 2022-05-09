package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="availablepackages")
public class AvailablePackage
{
    
    public AvailablePackage() {
    }

    public AvailablePackage(float cost, Trim trim, Package pack) {
        this.cost = cost;
        this.trim = trim;
        this.pack = pack;
    }

    @Column(name="cost", nullable = false)
    private float cost;

    @Id
    @Column(name = "available_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableID;

    //Junction between Package and Trim
    //One to Many to Trim
    @JoinColumn(name="trim_id", nullable = false)
    @ManyToOne
    private Trim trim;

    //Junction between Package and Trim
    //(must use "pack" because "packages" is a keyword in Java)
    @JoinColumn(name="package_id", nullable = false)
    @ManyToOne
    private Package pack;

    //Many to Many with Automobile, bidrectional
    @ManyToMany(mappedBy = "chosenpackages")
    private Set<Automobile> automobiles;


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

    public Set<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(Set<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    //Only Getter
    public int getAvailableID() {
        return availableID;
    }

}
