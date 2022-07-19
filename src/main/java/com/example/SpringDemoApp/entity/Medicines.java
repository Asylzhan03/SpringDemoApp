package com.example.SpringDemoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="medicines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @Column(name="amount")
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
}
