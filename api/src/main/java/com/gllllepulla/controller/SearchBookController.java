package com.gllllepulla.controller;

import com.gllllepulla.service.SearchBookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.transfer.View;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping ("/search")
public class SearchBookController {

    private final SearchBookService searchBookService;

    @Operation (summary = "Список всех книг")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping("/books")
    public ResponseEntity<Set<View.Book>> getAllBooks() {
        Set<View.Book> allBooks = searchBookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @Operation (summary = "Запрос книги по id")
    @GetMapping("books/{id}")
    public ResponseEntity<View.Book> getBookById(@PathVariable Long id) {
        return searchBookService.findBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (summary = "Запрос книг (-и) по наименованию (-ям)")
    @GetMapping(value = "books/title")
    public ResponseEntity<Set<View.Book>> getBooksByTitle(@RequestParam Set<String> titles) {
        Set<View.Book> books = searchBookService.findBooksByTitles(titles);
        return ResponseEntity.ok(books);
    }

    @Operation (summary = "Запрос книг (-и) по имени автора (-ов)")
    @GetMapping(value = "books/author")
    public ResponseEntity<Set<View.Book>> getBooksByAuthorsNames(@RequestParam Set<String> names) {
        Set<View.Book> books = searchBookService.findBooksByAuthorsNames(names);
        return ResponseEntity.ok(books);
    }

}
