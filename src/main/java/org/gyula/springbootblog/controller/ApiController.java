package org.gyula.springbootblog.controller;

import java.util.List;

import org.gyula.springbootblog.domain.Story;
import org.gyula.springbootblog.domain.User;
import org.gyula.springbootblog.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

//    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @PostMapping("/reg")
    public String greetingSubmit(@ModelAttribute User user) {
        System.out.println("UJ USER");
        log.info("Uj user!");
		log.debug(user.getUsername());
		log.debug(user.getPassword());
        return "auth/login";
    }
}