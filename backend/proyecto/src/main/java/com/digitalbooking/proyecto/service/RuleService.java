package com.digitalbooking.proyecto.service;

import com.digitalbooking.proyecto.exceptions.ResourceNotFoundException;
import com.digitalbooking.proyecto.model.*;
import com.digitalbooking.proyecto.model.DTO.RuleDTO;
import com.digitalbooking.proyecto.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    RuleRepository repository;

    @Autowired
    ProductService p_service;

    public List<Rule> listRule(){
        return repository.findAll();
    }

    public Rule saveRule(RuleDTO rule) throws ResourceNotFoundException {
        Rule ru = new Rule(rule.getType(), rule.getDescription(), p_service.findById(rule.getId_product()).get());
        return repository.save(ru);
    }

    public Rule updateRule(Rule rule) throws ResourceNotFoundException {
        Optional<Rule> searchedRule = repository.findById(rule.getId());
        if (searchedRule.isPresent()){
            return repository.save(rule);
        }
        else {
            throw new ResourceNotFoundException("Rule with ID: "+ rule.getId()+" doesn´t exist");
        }
    }

    public void deleteRule(Long id) throws ResourceNotFoundException{
        Optional<Rule> searchedRule = repository.findById(id);
        if (searchedRule.isPresent()){
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Rule with ID: "+ id +" doesn´t exist");
        }
    }
}
