package model;

import jakarta.persistence.*;

@Entity(name="modelfeatures")
public class ModelFeatures {

    public ModelFeatures() {
    }

    public ModelFeatures(Model model, Feature feature) {
        this.model = model;
        this.feature = feature;
    }

    @Id
    @JoinColumn(name="model_id", nullable = false)
    @ManyToOne
    private Model model;

    @Id
    @JoinColumn(name="feature_id", nullable = false)
    @ManyToOne
    private Feature feature;
    
    //Setters and Getters

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }
}
