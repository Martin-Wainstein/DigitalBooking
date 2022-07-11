package com.digitalbooking.proyecto.service;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.Booking;
import com.digitalbooking.proyecto.model.DTO.BookingDTO;
import com.digitalbooking.proyecto.model.Product;
import com.digitalbooking.proyecto.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    @Autowired
    UserService u_service;

    @Autowired
    ProductService p_service;

    public List<Booking> listBookings(){
        return repository.findAll();
    }

    public Booking saveBooking(BookingDTO booking) throws ResourceNotFoundException {
        Booking bo = new Booking(booking.getDate_from(),booking.getDate_to(),booking.getStart_time(), u_service.findById(booking.getId_user()).get(), p_service.findById(booking.getId_product()).get());
        return repository.save(bo);
    }

    public Booking updateBooking(Booking booking) throws ResourceNotFoundException {
        Optional<Booking> searchedBooking = repository.findById(booking.getId());
        if (searchedBooking.isPresent()){
            return repository.save(booking);
        }
        else {
            throw new ResourceNotFoundException("booking with ID: "+ booking.getId()+" doesn´t exist");
        }
    }

    public List<Booking> findBookingByProduct(Long id) throws ResourceNotFoundException {
        List<Booking> searchedBooking = repository.findBookingByProduct(id);
        if (searchedBooking != null) {
            return repository.findBookingByProduct(id);
        } else {
            throw new ResourceNotFoundException("Booking with product with ID: " + id + " doesn´t exist");
        }
    }

    public List<Booking> findBookingByUser(Long id) throws ResourceNotFoundException {
        List<Booking> searchedBooking = repository.findBookingByUser(id);
        if (searchedBooking != null) {
            return repository.findBookingByUser(id);
        } else {
            throw new ResourceNotFoundException("Booking with product with ID: " + id + " doesn´t exist");
        }
    }

    public void deleteBooking(Long id) throws ResourceNotFoundException{
        Optional<Booking> searchedBooking = repository.findById(id);
        if (searchedBooking.isPresent()){
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Booking with ID: "+ id +" doesn´t exist");
        }
    }
}
