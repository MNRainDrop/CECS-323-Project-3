package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="trims")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"model_id", "name"})
})
public class Trim {

    public Trim() {
    }

    public Trim(String name, float cost, Model model) {
        this.name = name;
        this.cost = cost;
        this.model = model;
    }

    //Primary Key
    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimID;

    @Column(length = 100, name = "name", nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private float cost;
    
    //Foreign Key with Model
    //Many to One, Bidirectional
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    //Association with Packages, via the AvailablePackage
    //One to Many to AvailablePackages
    @OneToMany(mappedBy = "trim")
    private Set<AvailablePackage> availablePackages;

    //Association with Features, via the TrimFeatures
    //One to Many to TrimFeatures
    @OneToMany(mappedBy = "trim")
    private Set<TrimFeatures> trimfeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Set<AvailablePackage> getAvailablePackages() {
        return availablePackages;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.availablePackages = availablePackages;
    }

    public Set<TrimFeatures> getTrimfeatures() {
        return trimfeatures;
    }

    public void setTrimfeatures(Set<TrimFeatures> trimfeatures) {
        this.trimfeatures = trimfeatures;
    }

    //Only Getters
    public int getTrimID() {
        return trimID;
    }
}
