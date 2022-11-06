package org.gyula.springbootblog.repository;

import java.util.List;

import org.gyula.springbootblog.domain.Blogger;
import org.springframework.data.repository.CrudRepository;

import org.gyula.springbootblog.domain.Blogger;

public interface BloggerRepository extends CrudRepository<Blogger, Long> {
    List<Blogger> findAll();
}