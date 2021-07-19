package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.entity.EventPost;

@Repository
public interface EventPostRepository extends JpaRepository<EventPost, Integer> {


	
}
