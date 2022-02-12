package com.gllllepulla.repository;

import com.gllllepulla.entities.BookAuthor;
import com.gllllepulla.entities.BookAuthorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorPK> {

}
