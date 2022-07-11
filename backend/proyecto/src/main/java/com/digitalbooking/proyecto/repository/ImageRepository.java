package com.digitalbooking.proyecto.repository;

import com.digitalbooking.proyecto.model.Category;
import com.digitalbooking.proyecto.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {
}
