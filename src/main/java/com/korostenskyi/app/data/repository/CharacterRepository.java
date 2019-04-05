package com.korostenskyi.app.data.repository;

import com.korostenskyi.app.data.entity.Character;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long> { }
