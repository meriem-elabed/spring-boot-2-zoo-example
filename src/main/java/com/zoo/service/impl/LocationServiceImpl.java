package com.zoo.service.impl;

import com.zoo.model.Location;
import com.zoo.repository.LocationRepository;
import com.zoo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Location findById(String id) {
        Optional<Location>  found = repository.findById(id);

        if(found.isPresent())
            return found.get();

        return null;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public Location save(Location Location) {
        return repository.save(Location);
    }



    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
