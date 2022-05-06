package model;

import jakarta.persistence.*;

@Entity(name="availablepackages")
public class AvailablePackage
{
    @Column(name="cost")
    private float cost;

    @JoinColumn(name="trim_id")
    @ManyToOne
    private Trim trim;

    //(must use "pack" because "packages" is a keyword in Java)
    @JoinColumn(name="package_id")
    @ManyToOne
    private Package pack;

    @Id
    @Column(name = "available_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableID;

    public float getCost()
    {
        return cost;
    }

    public void setCost(float cost)
    {
        this.cost = cost;
    }
}
