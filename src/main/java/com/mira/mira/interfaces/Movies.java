package com.mira.mira.interfaces;

import com.mira.mira.entities.Movie;

import java.io.IOException;
import java.util.ArrayList;

public interface Movies {
    public ArrayList<Movie> getMovies(String query, int page) throws IOException, InterruptedException;
}
