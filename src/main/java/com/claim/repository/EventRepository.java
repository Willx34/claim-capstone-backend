package com.claim.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query(value = "SELECT * FROM Event WHERE created_by = ?1", nativeQuery = true)
	List<Event> findEventByEmail(String email);
	
}
