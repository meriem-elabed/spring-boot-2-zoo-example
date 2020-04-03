package com.zoo.controller;

import com.zoo.dto.LocationDTO;
import com.zoo.service.LocationService;
import com.zoo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/locations")
public class LocationRestController {

    @Autowired
    private LocationService service;

    @GetMapping
    public List<LocationDTO> getAll() {
        return ObjectMapperUtils.mapAll(service.findAll(), LocationDTO.class);
    }


}
