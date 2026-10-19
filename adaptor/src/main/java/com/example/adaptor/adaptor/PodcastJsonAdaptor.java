package com.example.adaptor.adaptor;

import com.example.adaptor.module.Podcast;
import com.example.adaptor.module.Episode;

import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class PodcastJsonAdaptor implements PodcastAdaptor {

    @Override
    public Podcast read(String data) {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(data);
        JsonNode show = root != null && root.has("show") ? root.get("show") : root;
        if (show == null || !show.isObject()) {
            throw new IllegalArgumentException("Expected a show object in the podcast response");
        }

        Podcast podcast = new Podcast();
        podcast.setTitle(text(show, "title"));
        podcast.setDescription(text(show, "description"));
        podcast.setImgUrl(text(show, "profile_img_url"));

        List<Episode> episodes = new ArrayList<>();
        JsonNode seasons = show.get("seasons");
        if (seasons != null && seasons.isArray()) {
            for (JsonNode season : seasons) {
                JsonNode podcasts = season.get("podcasts");
                if (podcasts == null || !podcasts.isArray()) {
                    continue;
                }
                for (JsonNode episodeNode : podcasts) {
                    Episode episode = new Episode();
                    episode.setTitle(text(episodeNode, "title"));
                    episode.setDescription(text(episodeNode, "description"));
                    episode.setAudioUrl(text(episodeNode, "podcast_url"));
                    episode.setImgUrl(text(episodeNode, "profile_img_url"));
                    episodes.add(episode);
                }
            }
        }
        podcast.setEpisodes(episodes);
        return podcast;
    }

    private String text(JsonNode node, String field) {
        JsonNode value = node.get(field);
        return value == null || value.isNull() ? null : value.asString();
    }

}
