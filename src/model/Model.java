package model;

//import java.util.*;
import jakarta.persistence.*;

@Entity(name="models")
public class Model 
{

    @Column(unique = true, length = 100, name = "name")
    private String name;
    
    @Column(unique = true, name = "year")
    private int year;
    
    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelID;

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
