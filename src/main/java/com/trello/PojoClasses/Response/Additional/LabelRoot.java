package com.trello.PojoClasses.Response.Additional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trello.PojoClasses.Response.Limits;

public class LabelRoot {

    @JsonProperty
    public String id;

    @JsonProperty
    public String idBoard;

    @JsonProperty
    public String name;

    @JsonProperty
    public String color;

    @JsonProperty("uses")
    public int myuses;

    public Limits limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMyuses() {
        return myuses;
    }

    public void setMyuses(int myuses) {
        this.myuses = myuses;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }
}
