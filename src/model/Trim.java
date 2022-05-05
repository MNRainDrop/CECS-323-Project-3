package model;

import jakarta.persistence.*;

@Entity(name="trims")
public class Trim {

    @Column(unique = true, length = 100, name = "name")
    private String name;

    @Column(name = "cost")
    private float cost;
    
    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimID;

    //Foreign key to Model

    public String getName() {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
}
