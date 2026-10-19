package com.example.adaptor.adaptor;

import com.example.adaptor.module.Episode;
import com.example.adaptor.module.Podcast;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Converts an RSS podcast feed into the application's podcast model. */
public class PodcastXmlAdaptor implements PodcastAdaptor {

    @Override
    public Podcast read(String data) {
        Document document = parse(data);
        Element channel = (Element) document.getElementsByTagName("channel").item(0);
        if (channel == null) {
            throw new IllegalArgumentException("RSS document does not contain a channel");
        }

        Podcast podcast = new Podcast();
        podcast.setTitle(channel.getElementsByTagName("title").item(0).getTextContent());
        podcast.setDescription(channel.getElementsByTagName("description").item(0).getTextContent());
        podcast.setImgUrl(value(channel.getElementsByTagName("image").item(0).getTextContent()));

        List<Episode> episodes = new ArrayList<>();
        NodeList items = channel.getElementsByTagName("item");
        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            Episode episode = new Episode();
            episode.setTitle(value(item.getElementsByTagName("title")
                    .item(0).getTextContent()));
            episode.setDescription(value(item.getElementsByTagName("description").item(0).getTextContent()));
            episode.setAudioUrl(value(((Element) item.getElementsByTagName("enclosure").item(0)).getAttribute("url")));
            episode.setImgUrl(value(((Element) item.getElementsByTagName("itunes:image").item(0)).getAttribute("href")));
            episodes.add(episode);
        }
        podcast.setEpisodes(episodes);
        return podcast;
    }

    private Document parse(String data) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            // factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            // factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            return factory.newDocumentBuilder().parse(
                    new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalArgumentException("Invalid podcast RSS XML", e);
        }
    }

   String value(String value) {
        if (value == null&& value.isBlank()) {
           return "";
        }
        return value;
    }
}
