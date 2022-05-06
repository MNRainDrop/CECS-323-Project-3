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

}