package model;

import jakarta.persistence.*;;

@Entity(name="availablepackages")
public class AvailablePackage
{
    @Column(name="cost")
    private float cost;

    @JoinColumn(name="package_id")
    @ManyToOne
    private Package packages;

    @JoinColumn(name="trim_id")
    @ManyToOne
    private Trim trims;

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
