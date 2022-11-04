package org.gyula.springbootblog.controller;

import org.gyula.springbootblog.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/")
    public String stories(Model model) {
        model.addAttribute("pageTitle", "Just a story...");
        model.addAttribute("stories", storyService.getStories());
        return "stories";
    }

    @RequestMapping("/title/{title}")
    public String searchForUser(@PathVariable(value = "title") String title, Model model) throws Exception {
        if (title == null)
            throw new Exception("There is no such blog title");
        model.addAttribute("story", storyService.getSpecificStory(title));
        return "story";
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
        model.addAttribute("errMessage", ex.getMessage());
        return "exceptionHandler";
    }

//    @RequestMapping("/story")
//    public String story(Model model) {
//        model.addAttribute("pageTitle", "Minden napra egy SFJ sztori!");
//        model.addAttribute("story", storyService.getStory());
//        return "story";
//    }

}