package com.korostenskyi.app.data.network;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetworkDataSourceImpl implements NetworkDataSource {

    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://www.anapioficeandfire.com/api";

    @Override
    public Book getBookById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/books/" + id, Book.class);
    }

    @Override
    public Character getCharacterById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/characters/" + id, Character.class);
    }

    @Override
    public House getHouseById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/houses/" + id, House.class);
    }
}
