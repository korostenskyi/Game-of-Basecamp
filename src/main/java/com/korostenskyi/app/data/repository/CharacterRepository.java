package com.korostenskyi.app.data.repository;

import com.korostenskyi.app.data.entity.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> { }
