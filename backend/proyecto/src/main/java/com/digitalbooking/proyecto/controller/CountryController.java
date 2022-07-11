package com.digitalbooking.proyecto.controller;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.Country;
import com.digitalbooking.proyecto.model.DTO.CountryDTO;
import com.digitalbooking.proyecto.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryService service;

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "List all Countries")
    @GetMapping("/list")
    public List<Country> listCountry(){
        return service.listCountries();
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Create new Country")
    @PostMapping("/new")
    public Country saveCountry(@RequestBody CountryDTO country) throws ResourceNotFoundException{
        return service.saveCountry(country);
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Delete a Country by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteCountry(id);
        return ResponseEntity.ok("Country with ID: "+ id +" deleted");
    }

}
