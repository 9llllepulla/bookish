package com.gllllepulla.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.transfer.View;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping ("/search")
public class SearchBookController {

    @Operation (summary = "Список всех книг")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping("/books")
    public ResponseEntity<List<View.Book>> getAllBooks() {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос книги по id")
    @GetMapping("books/{id}")
    public ResponseEntity<View.Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос книг (-и) по наименованию (-ям)")
    @GetMapping(value = "books/title")
    public ResponseEntity<List<View.Book>> getBooksByTitle(@RequestParam Set<String> titles) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос книг (-и) по имени автора (-ов)")
    @GetMapping(value = "books/author")
    public ResponseEntity<List<View.Book>> getBooksByAuthorName(@RequestParam Set<String> names) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
