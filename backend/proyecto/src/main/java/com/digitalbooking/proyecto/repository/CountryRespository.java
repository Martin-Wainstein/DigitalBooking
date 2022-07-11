package com.digitalbooking.proyecto.repository;

import com.digitalbooking.proyecto.model.Category;
import com.digitalbooking.proyecto.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRespository  extends JpaRepository<Country, Long> {
}
