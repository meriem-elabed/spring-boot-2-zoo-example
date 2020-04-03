package com.zoo.service;


import com.zoo.model.Location;

import java.util.List;


public interface LocationService {

    Location findById(String id);

    List<Location> findAll();

    Location save(Location Location);

    void delete(String id);

}
