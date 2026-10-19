package com.example.adaptor.module;

import java.util.List;

public class Podcast {

    @Override
    public String toString() {
        return "Podcast [title=" + title + ", description=" + description + ", imgUrl=" + imgUrl + ", episodes=\n"
                + episodes + "]";
    }
    String title ;
    String description ;
    String imgUrl;
    List<Episode> episodes;
    String link;
    String pubDate;
    String generator;
    String language;
    String copyright;
    String category;
    String subtitle;
    String author;
    String explicit;
    String type;
    String ownerName;
    String ownerEmail;
    String atomLink;
    String fundingUrl;
    String fundingText;
    String imageTitle;
    String imageLink;
    String imageWidth;
    String imageHeight;
    String atomRel;
    String atomType;
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
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public List<Episode> getEpisodes() {
        return episodes;
    }
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    
    


}
