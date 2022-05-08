package model;

import jakarta.persistence.*;

@Entity(name="trimfeatures")
public class TrimFeatures {
    
    public TrimFeatures() {
    }

    public TrimFeatures(Trim trim, Feature feature) {
        this.trim = trim;
        this.feature = feature;
    }

    @Id
    @JoinColumn(name="trim_id", nullable = false)
    @ManyToOne
    private Trim trim;

    @Id
    @JoinColumn(name="feature_id", nullable = false)
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