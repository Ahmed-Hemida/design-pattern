package com.example.adaptor.module;

public class Episode {

    String title ;
    String description ;
    String audioUrl ;
    String imgUrl ;

    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }


    @Override
    public String toString() {
        return "Episode [\ntitle=" + title + ", description=" + description + ", audioUrl=" + audioUrl + ", imgUrl="
                + imgUrl + "\n]";
    }
}
