package org.gyula.springbootblog.repository;

import java.util.List;

import org.gyula.springbootblog.domain.Blogger;
import org.gyula.springbootblog.domain.Story;
import org.springframework.data.repository.CrudRepository;

import org.gyula.springbootblog.domain.Story;

public interface StoryRepository extends CrudRepository<Story, Long> {

    //SELECT * FROM STORY
    List<Story> findAll();

    //SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
    Story findFirstByOrderByPostedDesc();

    Story findByTitle(String title);

    List<Story> findByBlogger(Blogger blogger);

}