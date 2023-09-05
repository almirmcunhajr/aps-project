package com.mira.mira.search;

import com.mira.mira.getContent.GetContentController;
import com.mira.mira.getContent.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class SearchController {
    private final GetContentController getContentController;

    @Autowired
    public SearchController(GetContentController getContentController) {
        this.getContentController = getContentController;
    }

    public ArrayList<Content> search(String query, int page) throws IOException, InterruptedException {
        return getContentController.search(query, page);
    }
}
