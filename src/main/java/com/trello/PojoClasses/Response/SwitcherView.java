package com.trello.PojoClasses.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwitcherView {


    public String viewType;
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
