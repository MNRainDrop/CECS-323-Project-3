package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="models")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "year"})
})
public class Model 
{

    @Column(length = 100, name = "name")
    private String name;
    
    @Column(name = "year")
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

    public String getName() 
    {
        return name;
    }

    public int getModelID() 
    {
        return modelID;
    }

    public void setModelID(int modelID) 
    {
        this.modelID = modelID;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getYear() 
    {
        return year;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

}
