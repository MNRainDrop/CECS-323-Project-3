package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name="trims")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"model_id", "name"})
})
public class Trim {

    //Primary Key
    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimID;

    @Column(length = 100, name = "name")
    private String name;

    @Column(name = "cost")
    private float cost;
    
    //Foreign Key with Model
    //Many to One, Bidirectional
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    //Association with Packages, via the a
    //One to Manyt to AvailablePackages
    @OneToMany(mappedBy = "trim")
    private Set<AvailablePackage> availablepackages;

    public String getName()
    {
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
