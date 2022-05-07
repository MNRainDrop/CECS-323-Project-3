package model;
import jakarta.persistence.*;

@Entity(name="chosenpackages")
public class ChosenPackage {
    //Foreign key with availablepackage
    //Many to One, Unidirectional?
    @ManyToOne
    @JoinColumn(name = "available_id" )
    private AvailablePackage availablepackage;

    public AvailablePackage getAvailablepackage() {
        return availablepackage;
    }

    public void setAvailablepackage(AvailablePackage availablepackage) {
        this.availablepackage = availablepackage;
    }

    //Foreign key with automobiles
    //Many to One, Unidirectional?
    @ManyToOne
    @JoinColumn(name = "auto_id" )
    private Automobile automobile;

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }
}
