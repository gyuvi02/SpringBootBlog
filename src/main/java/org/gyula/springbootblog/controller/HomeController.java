package org.gyula.springbootblog.controller;

import org.gyula.springbootblog.domain.Blogger;
import org.gyula.springbootblog.domain.User;
import org.gyula.springbootblog.service.EmailService;
import org.gyula.springbootblog.service.StoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private EmailService emailService;


    private StoryService storyService;

//    @Autowired
//    public void setStoryService(StoryService storyService) {
//        this.storyService = storyService;
//    }

    // This is for testing branches
//    @Secured("ADMIN")
    @RequestMapping("/")
    public String stories(Model model) {
        model.addAttribute("pageTitle", "Just a story...");
        model.addAttribute("stories", storyService.getStories());
        return "stories";
    }

    @RequestMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    //    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @PostMapping("/reg")
    public String greetingSubmit(@ModelAttribute User user) {
        log.info("Uj user!");
        emailService.sendMessage(user.getEmail());
        //		log.debug(user.getUsername());
        //		log.debug(user.getPassword());
        return "auth/login";
    }

//    @RequestMapping("/title/{title}")
//    public String searchForUser(@PathVariable(value = "title") String title, Model model) throws Exception {
//        if (title == null)
//            throw new Exception("There is no such blog title");
//        model.addAttribute("story", storyService.getSpecificStory(title));
//        return "story";
//    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
        model.addAttribute("errMessage", ex.getMessage());
        return "error";
    }

//    @RequestMapping("/story")
//    public String story(Model model) {
//        model.addAttribute("pageTitle", "What a Spring Boot!");
//        model.addAttribute("story", storyService.getStory());
//        return "story";
//    }

    @RequestMapping("/{bloggerName}")
    public String blogger(@PathVariable(value = "bloggerName") String bloggerName, Model model) {
        model.addAttribute("pageTitle", "Just a story...");
        model.addAttribute("stories", storyService.getByBlogger(bloggerName));
        return "stories";
    }

}
