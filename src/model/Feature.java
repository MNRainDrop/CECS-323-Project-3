package model;
import jakarta.persistence.*;

//@Entity(name = "features")
public class Feature 
{
    private String name;

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}
