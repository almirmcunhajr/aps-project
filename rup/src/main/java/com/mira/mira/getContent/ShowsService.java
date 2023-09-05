package com.mira.mira.getContent;

import java.io.IOException;
import java.util.ArrayList;

public interface ShowsService {
    public ArrayList<Show> search(String query, int page) throws IOException, InterruptedException;
    public ArrayList<Show> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException;
    public ArrayList<Show> getPopular(int page, String region) throws IOException, InterruptedException;
}
