package model;

import jakarta.persistence.*;

@Entity(name="availablepackages")
public class AvailablePackage {
    private float cost;

    public float getCost() {
        return cost;
    }



    public void setCost(float cost) {
        this.cost = cost;
    }
}
