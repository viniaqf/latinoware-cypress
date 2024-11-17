package com.example.latinoware.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_orator", schema = "public")
@AllArgsConstructor @NoArgsConstructor
public class Orator extends AbstractEntity {

    @Getter @Setter
    @Column(name = "oratorName", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "age")
    private Integer age;

    @Getter @Setter
    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @Getter @Setter
    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Getter @Setter
    @OneToMany(mappedBy = "orator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;
}
