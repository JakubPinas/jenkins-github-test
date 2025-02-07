package com.trello.PojoClasses.Response.Additional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trello.PojoClasses.Response.Limits;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelRoot {

    public String id;
    public String idBoard;
    public String name;
    public String color;
    public int uses;
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

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "LabelRoot{" +
                "id='" + id + '\'' +
                ", idBoard='" + idBoard + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", uses=" + uses +
                ", limits=" + limits +
                '}';
    }
}
