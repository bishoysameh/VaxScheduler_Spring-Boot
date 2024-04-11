package com.example.demo.vaccine;

// import java.sql.Date;

import com.example.demo.vaccinationCenter.VaccinationCenter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccines")
public class Vaccine {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @SequenceGenerator(
            name  = "vaccine_sequence",
            sequenceName = "vaccine sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vaccine_sequence"
    )
 
    private Long id;
    private String name;
    private String precautions;



// Define the many-to-one relationship with vaccination centers
    @ManyToOne
    @JoinColumn(name = "vaccination_center_id", referencedColumnName = "id")
    private VaccinationCenter vaccinationCenter;



    private String timeGapFirstSecondDose;
    

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Getters and setters for precautions
    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
    
    // Getters and setters for vaccinationCenter
    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }
    
    // Getters and setters for timeGapFirstSecondDose
    public String getTimeGapFirstSecondDose() {
        return timeGapFirstSecondDose;
    }

    public void setTimeGapFirstSecondDose(String timeGapFirstSecondDose) {
        this.timeGapFirstSecondDose = timeGapFirstSecondDose;
    }


    @Override
    public String toString() {
        return "Vaccine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", precautions='" + precautions + '\'' +
                 ", vaccinationCenter=" + vaccinationCenter +
                ", timeGapFirstSecondDose=" + timeGapFirstSecondDose +
                '}';
    }
}
