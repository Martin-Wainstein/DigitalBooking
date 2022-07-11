package com.digitalbooking.proyecto.service;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.Booking;
import com.digitalbooking.proyecto.model.Category;
import com.digitalbooking.proyecto.model.DTO.ImageDTO;
import com.digitalbooking.proyecto.model.Image;
import com.digitalbooking.proyecto.repository.CountryRespository;
import com.digitalbooking.proyecto.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImageService {

    @Autowired
    ImageRepository repository;

    @Autowired
    ProductService p_service;

    public List<Image> listImage(){
        return repository.findAll();
    }

    public Image saveImage(ImageDTO image) throws ResourceNotFoundException {
        Image img = new Image(image.getTitle(), image.getUrlimg(), p_service.findById(image.getId_product()).get());
        return repository.save(img);
    }

    public Image updateImage(Image image) throws ResourceNotFoundException {
        Optional<Image> searchedCategory = repository.findById(image.getId());
        if (searchedCategory.isPresent()){
            return repository.save(image);
        }
        else {
            throw new ResourceNotFoundException("Image with ID: "+ image.getId()+" doesn´t exist");
        }
    }

    public void deleteImage(Long id) throws ResourceNotFoundException{
        Optional<Image> searchedImage = repository.findById(id);
        if (searchedImage.isPresent()){
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Image with ID: "+ id +" doesn´t exist");
        }
    }
}
