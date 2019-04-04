package com.korostenskyi.app.data.repository;

import com.korostenskyi.app.data.entity.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> { }
