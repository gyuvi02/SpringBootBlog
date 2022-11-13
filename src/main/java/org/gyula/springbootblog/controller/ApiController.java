package org.gyula.springbootblog.controller;

import java.util.List;

import org.gyula.springbootblog.domain.Story;
import org.gyula.springbootblog.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }


//    @Secured("USER")
    @RequestMapping("/story")
    public Story story() {
        return storyService.getStory();
    }


    @RequestMapping("/title/{title}")
    public Story searchForUser(@PathVariable(value = "title") String title) {
        return storyService.getSpecificStory(title);
    }

//    @Secured("ADMIN")
    @RequestMapping("/stories/{name}")
    public List<Story> searchStoriesByBloggerName(@PathVariable(value = "name") String name) {
        return storyService.getByBlogger(name);
    }
}