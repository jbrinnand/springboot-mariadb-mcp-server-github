package com.ct.springboot_mariadb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                           // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor              // Generates default constructor
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String number;
    private int balance;
    private Long personId;
}