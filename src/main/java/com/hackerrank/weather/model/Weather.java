package com.hackerrank.weather.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "dateRecorded")
    private Date dateRecorded;
    @ManyToOne
    private Location location;
    @Column(name = "temperature")
    private Float[] temperature;

    public Weather() {
    }

    public Weather(Long id, Date dateRecorded, Location location, Float[] temperature) {
        this.id = id;
        this.dateRecorded = dateRecorded;
        this.location = location;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRecorded() {
        return dateRecorded;
    }

    public void setDateRecorded(Date dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(Float[] temperature) {
        this.temperature = temperature;
    }
}
