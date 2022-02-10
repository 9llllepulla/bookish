package com.repository;

import com.entities.BookAuthor;
import com.entities.BookAuthorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorPK> {

}
