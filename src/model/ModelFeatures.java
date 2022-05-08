package model;

import jakarta.persistence.*;

@Entity(name="modelfeatures")
public class ModelFeatures {

    @Id
    @JoinColumn(name="model_id")
    @ManyToOne
    private Model model;

    @Id
    @JoinColumn(name="feature_id")
    @ManyToOne
    private Feature feature;
    
    //Setters and Getters
    //No Setters
    //Only Getters
    public Model getModel() {
        return model;
    }

    public Feature getFeature() {
        return feature;
    }

    //Setters and Getters
    //No Setters
    //Only Getters

    
}
