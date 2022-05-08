package model;

import jakarta.persistence.*;

@Entity(name="trimfeatures")
public class TrimFeatures {
    
    @Id
    @JoinColumn(name="trim_id")
    @ManyToOne
    private Trim trim;

    @Id
    @JoinColumn(name="feature_id")
    @ManyToOne
    private Feature feature;

    //Setters and Getters
    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }
}