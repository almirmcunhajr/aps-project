package com.mira.mira.exploration;

import com.mira.mira.getContent.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ExplorationRestController {
    private final ExplorationController explorationController;

    @Autowired
    public ExplorationRestController(ExplorationController explorationController) {
        this.explorationController = explorationController;
    }

    @GetMapping("/explore")
    public ArrayList<Content> explore(int page) throws IOException, InterruptedException {
        return explorationController.explore(page);
    }
}
