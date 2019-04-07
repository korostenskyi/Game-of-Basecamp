package com.korostenskyi.app.data.repository;

import com.korostenskyi.app.data.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> { }
