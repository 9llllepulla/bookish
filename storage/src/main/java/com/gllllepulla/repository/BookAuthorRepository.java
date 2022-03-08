package com.gllllepulla.repository;

import com.gllllepulla.entities.Author;
import com.gllllepulla.entities.Book;
import com.gllllepulla.entities.BookAuthor;
import com.gllllepulla.entities.BookAuthorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorPK> {

    @Query("select b.author from BookAuthor b where b.primaryKey.bookId = :bookId")
    List<Author> findAuthorsByBookId(@Param("bookId") Long bookId);

    @Query("select b.book from BookAuthor b where b.primaryKey.authorId = :authorId")
    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);
}
