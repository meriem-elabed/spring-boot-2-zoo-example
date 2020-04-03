package com.zoo.service.impl;

import com.zoo.model.Dragon;
import com.zoo.repository.DragonRepository;
import com.zoo.service.DragonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author ragcrix
 */
@Service
public class DragonServiceImpl implements DragonService {

    @Autowired
    private DragonRepository repository;

    @Override
    public Dragon findById(String id) {
        Optional<Dragon>  found = repository.findById(id);

        if(found.isPresent())
            return found.get();

        return null;
    }

    @Override
    public List<Dragon> findAll() {
        return repository.findAll();
    }

    @Override
    public Dragon update(Dragon dragon) {
        return repository.save(dragon);
    }

    @Override
    public Dragon create(Dragon dragon) {
        dragon.setId(UUID.randomUUID().toString());
        return repository.save(dragon);
    }


    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
