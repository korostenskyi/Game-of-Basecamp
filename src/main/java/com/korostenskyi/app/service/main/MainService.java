package com.korostenskyi.app.service.main;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.wire.response.AllCharactersResponse;
import com.korostenskyi.app.wire.response.MessageResponse;

public interface MainService {

    AllCharactersResponse fetchAllCharactersFromDatabase(Integer page, Integer pageSize);

    MessageResponse fight(Long characterId1, Long characterId2);

    MessageResponse postRandomCharacter();

    Book getBookById(Long id);

    Character getCharacterById(Long id);

    House getHouseById(Long id);

    House getRandomHouseCastle();

    void stopExecutor();
}
