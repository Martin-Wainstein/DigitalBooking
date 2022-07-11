package com.digitalbooking.proyecto.model.DTO;

import com.digitalbooking.proyecto.model.Country;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CityDTO {
    private String name;
    //@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Long id_country;
}
