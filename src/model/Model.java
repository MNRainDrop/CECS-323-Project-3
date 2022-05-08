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

    //Association with Features, via the ModelFeatures
    //One to Many to ModelFeatures
    @OneToMany(mappedBy = "model")
    private Set<ModelFeatures> modelFeatures;

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

    public Set<ModelFeatures> getModelFeatures() {
        return modelFeatures;
    }

    public void setModelFeatures(Set<ModelFeatures> modelFeatures) {
        this.modelFeatures = modelFeatures;
    }

    //Only Getters
    public int getModelID() {
        return modelID;
    }
}
