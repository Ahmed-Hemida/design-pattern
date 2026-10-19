package com.example.adaptor;

import com.example.adaptor.adaptor.PodcastAdaptor;
import com.example.adaptor.adaptor.PodcastJsonAdaptor;
import com.example.adaptor.adaptor.PodcastXmlAdaptor;
import com.example.adaptor.module.Podcast;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;




public class AdaptorApplication {

	public static void main(String[] args) {

		try {
			xmlApi();
			// jsonApi();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public static void jsonApi() throws IOException, InterruptedException {
		String url = "";

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Accept", "application/json")
				.GET()
				.build();

		HttpResponse<String> response = client.send(
				request,  
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

		if (response.statusCode() != 200) {
			throw new RuntimeException(
					"HTTP error: " + response.statusCode());
		}

		String data = response.body();
		// Process the JSON data here
		PodcastAdaptor adaptor = new PodcastJsonAdaptor();
		Podcast podcast = adaptor.read(data);
		System.out.println("----------------------------- Start Podcast----------------------------- " );
		System.out.println("Podcast: " + podcast.toString());
		System.out.println("----------------------------- end Podcast----------------------------- " );

	}
	public static void xmlApi() throws Exception {
        String url = "https://media.podeo.co/rss/MjMxNzg";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "HTTP error: " + response.statusCode()
            );
        }
		PodcastAdaptor adaptor = new PodcastXmlAdaptor();
		Podcast podcast = adaptor.read(response.body());
		System.out.println("----------------------------- Start Podcast----------------------------- " );
		System.out.println("Podcast: " + podcast.toString());
		System.out.println("----------------------------- end Podcast----------------------------- " );
    }
}
