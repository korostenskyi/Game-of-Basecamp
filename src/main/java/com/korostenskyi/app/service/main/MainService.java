package com.korostenskyi.app.service.main;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.wire.MessageResponse;

public interface MainService {

    MessageResponse greetUser();

    MessageResponse fight(Long uuid);

    void stopExecutor();

    Book getBookById(Long id);

    Character getCharacterById(Long id);

    House getHouseById(Long id);
}
