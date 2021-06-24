package com.example.loginapp;

public class District {

    private int id, imageRessourceId;
    private String name, description;
    private float lat, longi;

    public District(int id, int imageRessourceId, String name, String description, float lat, float longi){
        this.id = id;
        this.imageRessourceId = imageRessourceId;
        this.name= name;
        this.description = description;
        this.lat = lat;
        this. longi = longi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageRessourceId() {
        return imageRessourceId;
    }

    public void setImageRessourceId(int imageRessourceId) {
        this.imageRessourceId = imageRessourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLongi() {
        return longi;
    }

    public void setLongi(float longi) {
        this.longi = longi;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", imageRessourceId=" + imageRessourceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lat=" + lat +
                ", longi=" + longi +
                '}';
    }
}
