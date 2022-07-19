package com.example.SpringDemoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="doctor_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="doctor_position")
    private String doctorPosition;

    @Column(name="salary")
    private Long salary;
}
