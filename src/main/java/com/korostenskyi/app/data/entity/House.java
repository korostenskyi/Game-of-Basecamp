package com.korostenskyi.app.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class House {

    private Long id;
    private String url;
    private String name;
    private String region;
    private String coatOfArms;
    private String words;
    private List<String> titles;
    private List<String> seats;
    private String currentLord;
    private String heir;
    private String overlord;
    private String founded;
    private String diedOut;
    private List<String> ancestralWeapons;
    private List<String> cadetBranches;
    private List<String> swornMembers;

    public House(String url, String name, String region, String coatOfArms, String words, List<String> titles, List<String> seats, String currentLord, String heir, String overlord, String founded, String diedOut, List<String> ancestralWeapons, List<String> cadetBranches, List<String> swornMembers) {
        this.url = url;
        this.name = name;
        this.region = region;
        this.coatOfArms = coatOfArms;
        this.words = words;
        this.titles = titles;
        this.seats = seats;
        this.currentLord = currentLord;
        this.heir = heir;
        this.overlord = overlord;
        this.founded = founded;
        this.diedOut = diedOut;
        this.ancestralWeapons = ancestralWeapons;
        this.cadetBranches = cadetBranches;
        this.swornMembers = swornMembers;
    }

    public House() {
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

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "coat_of_arms")
    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    @Column(name = "words")
    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Column(name = "titles")
    @ElementCollection(targetClass = String.class)
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Column(name = "seats")
    @ElementCollection(targetClass = String.class)
    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    @Column(name = "current_lord")
    public String getCurrentLord() {
        return currentLord;
    }

    public void setCurrentLord(String currentLord) {
        this.currentLord = currentLord;
    }

    @Column(name = "heir")
    public String getHeir() {
        return heir;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    @Column(name = "overlord")
    public String getOverlord() {
        return overlord;
    }

    public void setOverlord(String overlord) {
        this.overlord = overlord;
    }

    @Column(name = "founded")
    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    @Column(name = "died_out")
    public String getDiedOut() {
        return diedOut;
    }

    public void setDiedOut(String diedOut) {
        this.diedOut = diedOut;
    }

    @Column(name = "ancestral_weapons")
    @ElementCollection(targetClass = String.class)
    public List<String> getAncestralWeapons() {
        return ancestralWeapons;
    }

    public void setAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    @Column(name = "cadet_branches")
    @ElementCollection(targetClass = String.class)
    public List<String> getCadetBranches() {
        return cadetBranches;
    }

    public void setCadetBranches(List<String> cadetBranches) {
        this.cadetBranches = cadetBranches;
    }

    @Column(name = "sworn_members")
    @ElementCollection(targetClass = String.class)
    public List<String> getSwornMembers() {
        return swornMembers;
    }

    public void setSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
    }
}
