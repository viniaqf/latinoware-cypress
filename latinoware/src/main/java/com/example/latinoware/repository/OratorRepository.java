package com.example.latinoware.repository;

import com.example.latinoware.entity.Orator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OratorRepository extends JpaRepository<Orator, Long> {
    List<Orator> findByActiveTrue();
}
