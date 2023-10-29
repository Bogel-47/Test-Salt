package com.testsalt.demo.model;


import java.sql.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custId;
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private Date tglRegistrasi;
    private String status;

    // Getter and setter methods
}

