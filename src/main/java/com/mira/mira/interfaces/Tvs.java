package com.mira.mira.interfaces;

import com.mira.mira.entities.Tv;

import java.io.IOException;
import java.util.ArrayList;

public interface Tvs {
    public ArrayList<Tv> search(String query, int page) throws IOException, InterruptedException;
    public ArrayList<Tv> discoverByGenres(ArrayList<String> genres, int page) throws IOException, InterruptedException;
}
