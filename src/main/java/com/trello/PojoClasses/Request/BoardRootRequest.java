package com.trello.PojoClasses.Request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardRootRequest {

    public String name;
    public boolean defaultLabels;
    public boolean defaultLists;
    public String desc;
    public String prefs_permissionLevel;
    public String prefs_background;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultLabels() {
        return defaultLabels;
    }

    public void setDefaultLabels(boolean defaultLabels) {
        this.defaultLabels = defaultLabels;
    }

    public boolean isDefaultLists() {
        return defaultLists;
    }

    public void setDefaultLists(boolean defaultLists) {
        this.defaultLists = defaultLists;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrefs_permissionLevel() {
        return prefs_permissionLevel;
    }

    public void setPrefs_permissionLevel(String prefs_permissionLevel) {
        this.prefs_permissionLevel = prefs_permissionLevel;
    }

    public String getPrefs_background() {
        return prefs_background;
    }

    public void setPrefs_background(String prefs_background) {
        this.prefs_background = prefs_background;
    }

    @Override
    public String toString() {
        return "BoardRootRequest{" +
                "name='" + name + '\'' +
                ", defaultLabels=" + defaultLabels +
                '}';
    }
}
