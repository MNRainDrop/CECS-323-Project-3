package model;
import jakarta.persistence.*;

@Entity(name="chosenpackages")
public class ChosenPackage {

    public ChosenPackage() {
    }

    public ChosenPackage(Automobile automobile, AvailablePackage availablepackage) {
        this.availablepackage = availablepackage;
        this.automobile = automobile;
    }

    //Foreign key with availablepackage
    //Many to One, Bidirectional
    @Id
    @JoinColumn(name = "available_id", nullable = false)
    @ManyToOne
    private AvailablePackage availablepackage;

    //Foreign key with automobiles
    //Many to One, Bidirectional
    @Id
    @JoinColumn(name = "auto_id", nullable = false)
    @ManyToOne
    private Automobile automobile;

    public AvailablePackage getAvailablepackage() {
        return availablepackage;
    }

    public void setAvailablepackage(AvailablePackage availablepackage) {
        this.availablepackage = availablepackage;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    //Setters and Getters

}