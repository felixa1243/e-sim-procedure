package com.iqbalnetwork.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @Column(length = 150)
    private String street;
    @Column(length = 150)
    private String city;
    @Column(length = 150)
    private String state;
    @Column(length = 150)
    private String zip;
}
