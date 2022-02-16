package com.gllllepulla.repository;

import com.gllllepulla.entities.Author;
import com.gllllepulla.entities.Book;
import com.gllllepulla.entities.BookAuthor;
import com.gllllepulla.entities.BookAuthorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorPK> {

    // TODO написать запрос поиска авторов объединяя таблицы book_authors & authors
    List<Author> findAuthorsByBookId(Long bookId);

    // TODO написать запрос поиска книг объединяя таблицы book_authors & books
    List<Book> findBooksByAuthorId(Long authorId);
}
