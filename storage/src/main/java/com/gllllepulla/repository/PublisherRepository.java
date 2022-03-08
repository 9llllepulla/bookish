package com.gllllepulla.repository;

import com.gllllepulla.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Query("select p.publisherName from Publisher p where p.publisherName = :publisherName")
    Optional<Publisher> findByName(@Param("publisherName") String publisherName);
}
