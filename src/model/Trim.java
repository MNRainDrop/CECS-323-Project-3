package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="trims")
public class Trim {

    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimID;

    @Column(unique = true, length = 100, name = "name")
    private String name;

    @Column(name = "cost")
    private float cost;
    
    //Foreign Key with Model
    //Many to One
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    //Parent Key of Automobile
    //One to Many
    @OneToMany(mappedBy = "trim")
    private List<Automobile> automobiles;

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
