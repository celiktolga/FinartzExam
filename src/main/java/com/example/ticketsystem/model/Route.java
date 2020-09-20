package com.example.ticketsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class Route implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport originAirport;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destinationAirport;



}
