package com.korostenskyi.app.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    private Long id;
    private String url;
    private String name;
    private String isbn;
    private List<String> authors;
    private int numberOfPages;
    private String publisher;
    private String country;
    private String mediaType;
    private Date released;
    private List<String> characters;
    private List<String> povCharecters;

    public Book() {
    }

    public Book(String url, String name, String isbn, List<String> authors, int numberOfPages, String publisher, String country, String mediaType, Date released, List<String> characters, List<String> povCharecters) {
        this.url = url;
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.country = country;
        this.mediaType = mediaType;
        this.released = released;
        this.characters = characters;
        this.povCharecters = povCharecters;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "authors")
    @ElementCollection(targetClass = String.class)
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Column(name = "number_of_pages")
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "media_type")
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Column(name = "released")
    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    @Column(name = "characters")
    @ElementCollection(targetClass = String.class)
    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    @Column(name = "pov_characters")
    @ElementCollection(targetClass = String.class)
    public List<String> getPovCharecters() {
        return povCharecters;
    }

    public void setPovCharecters(List<String> povCharecters) {
        this.povCharecters = povCharecters;
    }
}
