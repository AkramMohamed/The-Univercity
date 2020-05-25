package com.example.theunivercity;

import java.util.Date;

public class Post {
    private int id_post ;
    private String dateP ;
    private String themeP , titleP , textP ;
    private int validPco , commentPco ;
    private String commentsP ;


    public Post() {
    }

    public Post(int id_post, String dateP, String themeP, String titleP, String textP,int validPco, int commentPco, String commentsP) {
        this.id_post = id_post;
        this.dateP = dateP;
        this.themeP = themeP;
        this.titleP = titleP;
        this.textP = textP;
        this.validPco = validPco;
        this.commentPco = commentPco;
        this.commentsP = commentsP;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getDateP() {
        return dateP;
    }

    public void setDateP(String dateP) {
        this.dateP = dateP;
    }

    public String getThemeP() {
        return themeP;
    }

    public void setThemeP(String themeP) {
        this.themeP = themeP;
    }

    public String getTitleP() {
        return titleP;
    }

    public void setTitleP(String titleP) {
        this.titleP = titleP;
    }

    public String getTextP() {
        return textP;
    }

    public void setTextP(String textP) {
        this.textP = textP;
    }

    public int getValidPco() {
        return validPco;
    }

    public void setValidPco(int validPco) { this.validPco = validPco; }

    public int getCommentPco() { return commentPco; }

    public void setCommentPco(int commentPco) { this.commentPco = commentPco; }

    public String getCommentsP() { return commentsP; }

    public void setCommentsP(String commentsP) { this.commentsP = commentsP; }
}
