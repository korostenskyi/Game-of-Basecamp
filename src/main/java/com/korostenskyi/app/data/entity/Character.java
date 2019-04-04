package com.korostenskyi.app.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Character {

    private Long id;
    private String url;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private List<String> titles;
    private List<String> aliases;
    private String father;
    private String mother;
    private String spouse;
    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;

    public Character() {
    }

    public Character(String url, String name, String gender, String culture, String born, String died, List<String> titles, List<String> aliases, String father, String mother, String spouse, List<String> allegiances, List<String> books, List<String> povBooks, List<String> tvSeries, List<String> playedBy) {
        this.url = url;
        this.name = name;
        this.gender = gender;
        this.culture = culture;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
        this.allegiances = allegiances;
        this.books = books;
        this.povBooks = povBooks;
        this.tvSeries = tvSeries;
        this.playedBy = playedBy;
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

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "culture")
    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    @Column(name = "born")
    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Column(name = "died")
    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    @Column(name = "titles")
    @ElementCollection(targetClass = String.class)
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Column(name = "aliases")
    @ElementCollection(targetClass = String.class)
    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    @Column(name = "father")
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Column(name = "mother")
    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Column(name = "spouse")
    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    @Column(name = "allegiances")
    @ElementCollection(targetClass = String.class)
    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    @Column(name = "books")
    @ElementCollection(targetClass = String.class)
    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Column(name = "pov_books")
    @ElementCollection(targetClass = String.class)
    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    @Column(name = "tv_series")
    @ElementCollection(targetClass = String.class)
    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    @Column(name = "played_by")
    @ElementCollection(targetClass = String.class)
    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }
}
