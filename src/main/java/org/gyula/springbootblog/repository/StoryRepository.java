package org.gyula.springbootblog.repository;

import java.util.List;

import org.gyula.springbootblog.domain.Blogger;
import org.gyula.springbootblog.domain.Story;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.gyula.springbootblog.domain.Story;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

    //SELECT * FROM STORY
    List<Story> findAll();

    //SELECT * FROM STORY WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
    Story findFirstByOrderByPostedDesc();

//    Story findByTitle(String title);

//    List<Story> findAllByBloggerIgnoreCaseOrderByPosted(Blogger blogger);
    List<Story> findAllByBloggerNameIgnoreCaseOrderByPosted (String blogger);

    //	@Query(value = "select * from story where title = ?1 limit 1", nativeQuery = true)
    //	@Query(value = "select * from story where title = :title limit 1", nativeQuery = true)
    @Query(value = "select s from Story s where s.title = :title")
    Story findByTitle(@Param("title") String title);
}