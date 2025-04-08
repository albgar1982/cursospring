package com.cursospring.restApiProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cursospring.restApiProject.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {}
