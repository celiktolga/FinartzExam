package com.example.ticketsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Flight extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id")
    private Company company;  //THY,PEGASUS
    @ManyToOne(optional = false)
    @JoinColumn(name = "route_id")
    private Route route;
    private double  price;
    private Integer soldSeat;
    private Integer quota;
}
