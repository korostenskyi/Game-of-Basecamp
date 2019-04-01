package com.korostenskyi.app.data.network;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;

public interface NetworkDataSource {

    Book getBookById(Long id);

    Character getCharacterById(Long id);

    House getHouseById(Long id);
}
