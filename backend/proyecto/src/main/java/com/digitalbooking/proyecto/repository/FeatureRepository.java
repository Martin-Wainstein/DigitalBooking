package com.digitalbooking.proyecto.repository;

import com.digitalbooking.proyecto.model.Category;
import com.digitalbooking.proyecto.model.Feature;
import com.digitalbooking.proyecto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
