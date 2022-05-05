package model;

import jakarta.persistence.*;

@Entity(name="availablepackages")
public class AvailablePackage
{
    @Column(name="cost")
    private float cost;

    @ManyToOne
    @JoinColumn(name="trim_id")
    private Trim trimID;

    @ManyToOne
    @JoinColumn(name="package_id")
    private Package packageID;

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
