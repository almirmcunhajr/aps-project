package com.mira.mira.tmdb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.mira.mira.getContent.Show;
import com.mira.mira.getContent.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class TmdbShowsService implements ShowsService {
    private final TmdbApi tmdbApi;

    @Autowired
    public TmdbShowsService(TmdbApi tmdbApi) {
        this.tmdbApi = tmdbApi;
    }

    public ArrayList<Show> search(String query, int page) throws IOException, InterruptedException {
        ArrayList<Show> shows = new ArrayList<>();

        String response = tmdbApi.searchTvs(query, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Show show = new Show();
            show.title = result.path("title").asText();
            show.overview = result.path("overview").asText();
            show.language = result.path("original_language").asText();
            show.extId = result.path("id").asInt();

            ArrayList<Integer> genresIds = new ArrayList<>();
            for (JsonNode genreId : result.path("genre_ids")) {
                genresIds.add(genreId.asInt());
            }
            show.genres = getGenresByIds(genresIds);

            shows.add(show);
        }

        return shows;
    }

    public ArrayList<Show> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException {
        ArrayList<Show> shows = new ArrayList<>();

        String genresFilter = String.join("OR", genres);

        String response = tmdbApi.discoverTvs(genresFilter, page);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Show show = new Show();
            show.title = result.path("title").asText();
            show.overview = result.path("overview").asText();
            show.language = result.path("original_language").asText();
            show.extId = result.path("id").asInt();

            ArrayList<Integer> genresIds = new ArrayList<>();
            for (JsonNode genreId : result.path("genre_ids")) {
                genresIds.add(genreId.asInt());
            }
            show.genres = getGenresByIds(genresIds);

            shows.add(show);
        }

        return shows;
    }

    public ArrayList<Show> getPopular(int page, String region) throws IOException, InterruptedException {
        ArrayList<Show> shows = new ArrayList<>();

        String response = tmdbApi.getPopularTvs(page, region);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("results");
        for (JsonNode result : results) {
            Show show = new Show();
            show.title = result.path("title").asText();
            show.overview = result.path("overview").asText();
            show.language = result.path("original_language").asText();
            show.extId = result.path("id").asInt();

            ArrayList<Integer> genresIds = new ArrayList<>();
            for (JsonNode genreId : result.path("genre_ids")) {
                genresIds.add(genreId.asInt());
            }
            show.genres = getGenresByIds(genresIds);

            shows.add(show);
        }

        return shows;
    }

    public ArrayList<String> getGenresByIds(ArrayList<Integer> ids) throws IOException, InterruptedException {
        ArrayList<String> genres = new ArrayList<>();

        String response = tmdbApi.getTVGenres();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response);
        JsonNode results = root.path("genres");
        for (JsonNode result : results) {
            if (ids.contains(result.path("id").asInt())) {
                genres.add(result.path("name").asText());
            }
        }

        return genres;
    }
}
