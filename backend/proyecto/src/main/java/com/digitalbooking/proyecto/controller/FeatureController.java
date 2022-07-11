package com.digitalbooking.proyecto.controller;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.DTO.FeatureDTO;
import com.digitalbooking.proyecto.model.Feature;
import com.digitalbooking.proyecto.service.FeatureService;
import com.digitalbooking.proyecto.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    ProductService productService;

    @Autowired
    FeatureService service;

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "List all features")
    @GetMapping("/list")
    public List<Feature> listFeatures(){
        return service.listFeature();
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Create new Feature of a product")
    @PostMapping("/new")
    public Feature saveFeature(@RequestBody FeatureDTO feature) throws ResourceNotFoundException {
        return service.saveFeature(feature);
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Delete a Feature by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFeature(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteFeature(id);
        return ResponseEntity.ok("Feature with ID: "+ id +" deleted");
    }
}
