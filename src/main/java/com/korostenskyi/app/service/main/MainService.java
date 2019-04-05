package com.korostenskyi.app.service.main;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.wire.response.AllCharactersResponse;
import com.korostenskyi.app.wire.response.MessageResponse;

public interface MainService {

    AllCharactersResponse fetchAllCharactersFromDatabase(int page, int pageSize);

    MessageResponse fight(Long uuid);

    MessageResponse postRandomCharacter();

    Book getBookById(Long id);

    Character getCharacterById(Long id);

    House getHouseById(Long id);

    void stopExecutor();
}
