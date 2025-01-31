package com.reyestech24.Airline.Airport;

import com.reyestech24.Airline.Flight.Flight;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private  String name;
    private  String code;
    private String city;
    private String country;


    public Airport(Long id, String name, String code, String city, String country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
    }

    public Airport(String name, String code, String city, String country) {
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
    }

    public Airport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
