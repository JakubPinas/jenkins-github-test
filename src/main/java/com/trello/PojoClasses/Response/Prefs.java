package com.trello.PojoClasses.Response;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prefs {

    public String permissionLevel;
    public boolean hideVotes;
    public String voting;
    public String comments;
    public String invitations;
    public boolean selfJoin;
    public boolean cardCovers;
    public boolean showCompleteStatus;
    public boolean cardCounts;
    public boolean isTemplate;
    public String cardAging;
    public boolean calendarFeedEnabled;
    public ArrayList<Object> hiddenPluginBoardButtons;
    public ArrayList<SwitcherView> switcherViews;
    public String background;
    public String backgroundColor;
    public Object backgroundImage;
    public Object backgroundDarkImage;
    public boolean backgroundTile;
    public String backgroundBrightness;
    public Object sharedSourceUrl;
    public Object backgroundImageScaled;
    public String backgroundBottomColor;
    public String backgroundTopColor;
    public boolean canBePublic;
    public boolean canBeEnterprise;
    public boolean canBeOrg;
    public boolean canBePrivate;
    public boolean canInvite;


    public Prefs() {
    }

    public Prefs(String background, String backgroundColor, String backgroundBottomColor, String backgroundTopColor) {
        this.background = background;
        this.backgroundColor = backgroundColor;
        this.backgroundBottomColor = backgroundBottomColor;
        this.backgroundTopColor = backgroundTopColor;
    }


    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public boolean isHideVotes() {
        return hideVotes;
    }

    public void setHideVotes(boolean hideVotes) {
        this.hideVotes = hideVotes;
    }

    public String getVoting() {
        return voting;
    }

    public void setVoting(String voting) {
        this.voting = voting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInvitations() {
        return invitations;
    }

    public void setInvitations(String invitations) {
        this.invitations = invitations;
    }

    public boolean isSelfJoin() {
        return selfJoin;
    }

    public void setSelfJoin(boolean selfJoin) {
        this.selfJoin = selfJoin;
    }

    public boolean isCardCovers() {
        return cardCovers;
    }

    public void setCardCovers(boolean cardCovers) {
        this.cardCovers = cardCovers;
    }

    public boolean isShowCompleteStatus() {
        return showCompleteStatus;
    }

    public void setShowCompleteStatus(boolean showCompleteStatus) {
        this.showCompleteStatus = showCompleteStatus;
    }

    public boolean isCardCounts() {
        return cardCounts;
    }

    public void setCardCounts(boolean cardCounts) {
        this.cardCounts = cardCounts;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public String getCardAging() {
        return cardAging;
    }

    public void setCardAging(String cardAging) {
        this.cardAging = cardAging;
    }

    public boolean isCalendarFeedEnabled() {
        return calendarFeedEnabled;
    }

    public void setCalendarFeedEnabled(boolean calendarFeedEnabled) {
        this.calendarFeedEnabled = calendarFeedEnabled;
    }

    public ArrayList<Object> getHiddenPluginBoardButtons() {
        return hiddenPluginBoardButtons;
    }

    public void setHiddenPluginBoardButtons(ArrayList<Object> hiddenPluginBoardButtons) {
        this.hiddenPluginBoardButtons = hiddenPluginBoardButtons;
    }

    public ArrayList<SwitcherView> getSwitcherViews() {
        return switcherViews;
    }

    public void setSwitcherViews(ArrayList<SwitcherView> switcherViews) {
        this.switcherViews = switcherViews;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Object getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Object backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Object getBackgroundDarkImage() {
        return backgroundDarkImage;
    }

    public void setBackgroundDarkImage(Object backgroundDarkImage) {
        this.backgroundDarkImage = backgroundDarkImage;
    }

    public boolean isBackgroundTile() {
        return backgroundTile;
    }

    public void setBackgroundTile(boolean backgroundTile) {
        this.backgroundTile = backgroundTile;
    }

    public String getBackgroundBrightness() {
        return backgroundBrightness;
    }

    public void setBackgroundBrightness(String backgroundBrightness) {
        this.backgroundBrightness = backgroundBrightness;
    }

    public Object getSharedSourceUrl() {
        return sharedSourceUrl;
    }

    public void setSharedSourceUrl(Object sharedSourceUrl) {
        this.sharedSourceUrl = sharedSourceUrl;
    }

    public Object getBackgroundImageScaled() {
        return backgroundImageScaled;
    }

    public void setBackgroundImageScaled(Object backgroundImageScaled) {
        this.backgroundImageScaled = backgroundImageScaled;
    }

    public String getBackgroundBottomColor() {
        return backgroundBottomColor;
    }

    public void setBackgroundBottomColor(String backgroundBottomColor) {
        this.backgroundBottomColor = backgroundBottomColor;
    }

    public String getBackgroundTopColor() {
        return backgroundTopColor;
    }

    public void setBackgroundTopColor(String backgroundTopColor) {
        this.backgroundTopColor = backgroundTopColor;
    }

    public boolean isCanBePublic() {
        return canBePublic;
    }

    public void setCanBePublic(boolean canBePublic) {
        this.canBePublic = canBePublic;
    }

    public boolean isCanBeEnterprise() {
        return canBeEnterprise;
    }

    public void setCanBeEnterprise(boolean canBeEnterprise) {
        this.canBeEnterprise = canBeEnterprise;
    }

    public boolean isCanBeOrg() {
        return canBeOrg;
    }

    public void setCanBeOrg(boolean canBeOrg) {
        this.canBeOrg = canBeOrg;
    }

    public boolean isCanBePrivate() {
        return canBePrivate;
    }

    public void setCanBePrivate(boolean canBePrivate) {
        this.canBePrivate = canBePrivate;
    }

    public boolean isCanInvite() {
        return canInvite;
    }

    public void setCanInvite(boolean canInvite) {
        this.canInvite = canInvite;
    }

    @Override
    public String toString() {
        return "Prefs{" +
                "permissionLevel='" + permissionLevel + '\'' +
                ", hideVotes=" + hideVotes +
                ", voting='" + voting + '\'' +
                ", comments='" + comments + '\'' +
                ", invitations='" + invitations + '\'' +
                ", selfJoin=" + selfJoin +
                ", cardCovers=" + cardCovers +
                ", showCompleteStatus=" + showCompleteStatus +
                ", cardCounts=" + cardCounts +
                ", isTemplate=" + isTemplate +
                ", cardAging='" + cardAging + '\'' +
                ", calendarFeedEnabled=" + calendarFeedEnabled +
                ", hiddenPluginBoardButtons=" + hiddenPluginBoardButtons +
                ", switcherViews=" + switcherViews +
                ", background='" + background + '\'' +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", backgroundImage=" + backgroundImage +
                ", backgroundDarkImage=" + backgroundDarkImage +
                ", backgroundTile=" + backgroundTile +
                ", backgroundBrightness='" + backgroundBrightness + '\'' +
                ", sharedSourceUrl=" + sharedSourceUrl +
                ", backgroundImageScaled=" + backgroundImageScaled +
                ", backgroundBottomColor='" + backgroundBottomColor + '\'' +
                ", backgroundTopColor='" + backgroundTopColor + '\'' +
                ", canBePublic=" + canBePublic +
                ", canBeEnterprise=" + canBeEnterprise +
                ", canBeOrg=" + canBeOrg +
                ", canBePrivate=" + canBePrivate +
                ", canInvite=" + canInvite +
                '}';

    }
}
