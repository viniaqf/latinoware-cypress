package com.example.latinoware.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Table(name = "tb_orator")
@AllArgsConstructor @NoArgsConstructor
public class Orator extends AbstractEntity {

    @Getter @Setter
    @Column(name = "oratorName", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "age")
    private String age;

    @Getter @Setter
    @Column(name = "jobTitle")
    private String jobTitle;

    @Getter @Setter
    @Column(name = "companyName")
    private String companyName;

}
