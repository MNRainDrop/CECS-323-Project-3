package model;
import jakarta.persistence.*;

@Entity(name="chosenpackages")
public class ChosenPackage {

    //Foreign key with availablepackage
    //Many to One, Bidirectional
    @Id
    @JoinColumn(name = "available_id" )
    @ManyToOne
    private AvailablePackage availablepackage;

    //Foreign key with automobiles
    //Many to One, Bidirectional
    @Id
    @JoinColumn(name = "auto_id" )
    @ManyToOne
    private Automobile automobile;

    //Setters and Getters
    //None for this one
}