package com.korostenskyi.app.data.repository;

import com.korostenskyi.app.data.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }
