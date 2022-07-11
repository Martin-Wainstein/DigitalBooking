package com.digitalbooking.proyecto.controller;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.DTO.ImageDTO;
import com.digitalbooking.proyecto.model.Image;
import com.digitalbooking.proyecto.service.ImageService;
import com.digitalbooking.proyecto.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ProductService productService;

    @Autowired
    ImageService service;

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "List all images")
    @GetMapping("/list")
    public List<Image> listImages(){
        return service.listImage();
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Create new Image of a product")
    @PostMapping("/new")
    public Image saveImage(@RequestBody ImageDTO image) throws ResourceNotFoundException {
        return service.saveImage(image);
    }

//    @CrossOrigin(origins = {"http://localhost:3000/", "http://load-balancer-grupo9-915343616.us-west-2.elb.amazonaws.com/"})
    @Operation(summary = "Delete a Image by id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) throws ResourceNotFoundException {
        service.deleteImage(id);
        return ResponseEntity.ok("Image with ID: "+ id +" deleted");
    }

}
