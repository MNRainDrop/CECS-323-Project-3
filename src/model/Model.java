package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="models")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "year"})
})
public class Model 
{
    
    public Model() {
    }

    public Model(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return year + " " + name + " (ID " + modelID + ")";
    }

    @Column(length = 100, name = "name", nullable = false)
    private String name;
    
    @Column(name = "year", nullable = false)
    private int year;
    
    //Primary Key
    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelID;

    //Parent Key of Model to Trim
    //One to Many
    @OneToMany(mappedBy = "model")
    private List<Trim> trims;

    //Many to Many with Features, unidirectional
    @ManyToMany
    @JoinTable(
        name = "modelfeatures", 
        joinColumns = @JoinColumn(name = "model_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id",
        nullable = false)
    )
    private Set<Feature> modelfeatures;

    //Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Trim> getTrims() {
        return trims;
    }

    public void setTrims(List<Trim> trims) {
        this.trims = trims;
    }

    public Set<Feature> getModelfeatures() {
        return modelfeatures;
    }

    public void setModelfeatures(Set<Feature> modelfeatures) {
        this.modelfeatures = modelfeatures;
    }

    //Only Getters
    public int getModelID() {
        return modelID;
    }

    public void addModelfeatures(Feature feature) {
        modelfeatures.add(feature);
    }
}
