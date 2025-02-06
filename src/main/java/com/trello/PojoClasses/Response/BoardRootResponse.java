package com.trello.PojoClasses.Response;

import com.fasterxml.jackson.annotation.JsonProperty;



public class BoardRootResponse {



    @JsonProperty
    public String id;

    @JsonProperty
    public String name;

    @JsonProperty
    public String desc;

    @JsonProperty
    public Object descData;

    @JsonProperty
    public boolean closed;

    @JsonProperty
    public String idOrganization;

    @JsonProperty
    public Object idEnterprise;

    @JsonProperty
    public boolean pinned;

    @JsonProperty
    public String url;

    @JsonProperty
    public String shortUrl;

    @JsonProperty
    public Prefs prefs;

    @JsonProperty
    public LabelNames labelNames;

    @JsonProperty
    public Limits limits;



    public BoardRootResponse(String name, String desc, boolean closed, String idOrganization, boolean pinned, Prefs prefs) {
        this.name = name;
        this.desc = desc;
        this.closed = closed;
        this.idOrganization = idOrganization;
        this.pinned = pinned;
        this.prefs = prefs;
    }


    public BoardRootResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Object getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Object idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public LabelNames getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", descData=" + descData +
                ", closed=" + closed +
                ", idOrganization='" + idOrganization + '\'' +
                ", idEnterprise=" + idEnterprise +
                ", pinned=" + pinned +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", prefs=" + prefs +
                ", labelNames=" + labelNames +
                ", limits=" + limits +
                '}';
    }
}

