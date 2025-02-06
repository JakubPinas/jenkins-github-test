package com.trello.PojoClasses.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SwitcherView {

    @JsonProperty
    public String viewType;

    @JsonProperty
    public boolean enabled;


    public SwitcherView() {
    }

    public SwitcherView(String viewType, boolean enabled) {
        this.viewType = viewType;
        this.enabled = enabled;
    }



    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "SwitcherView{" +
                "viewType='" + viewType + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
