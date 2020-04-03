package com.zoo.controller;

import com.zoo.dto.DragonDTO;
import com.zoo.model.Dragon;
import com.zoo.service.DragonService;
import com.zoo.service.LocationService;
import com.zoo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dragons")
public class DragonRestController {

    @Autowired
    private DragonService service;
    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/")
    public List<DragonDTO> getAll() {
        return ObjectMapperUtils.mapAll(service.findAll(), DragonDTO.class);
    }

    @GetMapping(value = "/{id}")
    public DragonDTO getById(@PathVariable String id) {
        return ObjectMapperUtils.map(service.findById(id), DragonDTO.class);
    }

    @PostMapping
    public ResponseEntity<?> addDragon(@RequestBody DragonDTO dragonDto) {
        Dragon dragon = ObjectMapperUtils.map(dragonDto, Dragon.class);
        service.create(dragon);
        return new ResponseEntity("Dragon added successfully", HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDragon(@PathVariable String id, @RequestBody DragonDTO dragonDto) {
        Dragon dragon = ObjectMapperUtils.map(dragonDto, Dragon.class);
        service.update(dragon);
        return new ResponseEntity("Dragon updated successfully", HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity("Dragon deleted successfully", HttpStatus.OK);
    }


}
