package model;

import jakarta.persistence.*;

@Entity(name="packagefeatures")
public class PackageFeatures {

    //(must use "pack" because "packages" is a keyword in Java)
    @Id
    @JoinColumn(name="package_id")
    @ManyToOne
    private Package pack;

    @Id
    @JoinColumn(name="feature_id")
    @ManyToOne
    private Feature feature;

    //Setters and Getters
    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }
}
