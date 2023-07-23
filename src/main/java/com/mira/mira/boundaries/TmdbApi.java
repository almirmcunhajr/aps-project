package com.mira.mira.boundaries;

import com.mira.mira.configurations.TmdbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class TmdbApi {

    private final HttpClient httpClient;
    private final String apiKey;

    @Autowired
    public TmdbApi(TmdbConfig tmdbConfig) {
        this.httpClient = HttpClient.newHttpClient();
        this.apiKey = tmdbConfig.getApiKey();
    }

    public String searchMovies(String query, int page) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/search/movie")
                .queryParam("query", query)
                .queryParam("page", page)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String searchTvs(String query, int page) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/search/tv")
                .queryParam("query", query)
                .queryParam("page", page)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String discoverMovies(String genres, int page) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/discover/movie")
                .queryParam("with_genres", genres)
                .queryParam("page", page)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String discoverTvs(String genres, int page) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/discover/tv")
                .queryParam("with_genres", genres)
                .queryParam("page", page)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getPopularMovies(int page, String region) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/movie/popular")
                .queryParam("page", page)
                .queryParam("region", region)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getPopularTvs(int page, String region) throws IOException, InterruptedException {
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/tv/popular")
                .queryParam("page", page)
                .queryParam("region", region)
                .build()
                .toUri();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Bearer " + apiKey)
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
