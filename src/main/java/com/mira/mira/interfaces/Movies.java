package com.mira.mira.interfaces;

import com.mira.mira.entities.Movie;

import java.io.IOException;
import java.util.ArrayList;

public interface Movies {
    public ArrayList<Movie> search(String query, int page) throws IOException, InterruptedException;
    public ArrayList<Movie> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException;
}
