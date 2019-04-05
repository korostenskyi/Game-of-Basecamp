package com.korostenskyi.app.service.concurrent;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;

import java.util.concurrent.Future;

public interface ConcurrentTaskService {

    void stopService();

    Future<Book> getBookById(Long id);

    Future<Character> getCharacterById(Long id);

    Future<House> getHouseById(Long id);

    Future<Character> fetchCharacterByIdFromDatabase(Long id);

    Future<Iterable<Character>> fetchAllCharactersFromDatabase();
}
