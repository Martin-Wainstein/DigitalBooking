package com.digitalbooking.proyecto.repository;

import com.digitalbooking.proyecto.model.Category;
import com.digitalbooking.proyecto.model.Product;
import com.digitalbooking.proyecto.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository  extends JpaRepository<Rule, Long> {
}
