package com.mira.contentfetchservice;

import com.mira.contentfetchservice.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "movies-service")
public interface MoviesService {

    @GetMapping("/search")
    ArrayList<Movie> search(@RequestParam("query") String query, @RequestParam("page") int page);
}
