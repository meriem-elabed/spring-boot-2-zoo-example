package com.zoo.service;


import com.zoo.model.Dragon;

import java.util.List;


public interface DragonService {

    Dragon findById(String id);

    List<Dragon> findAll();

    Dragon update(Dragon Dragon);

    Dragon create(Dragon dragon);

    void delete(String id);

}
