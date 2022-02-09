package com.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ui.Info;

import java.util.List;

@Slf4j
@RestController
@RequestMapping ("/search")
public class SearchController {

    @Operation (summary = "Список всех книг")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping("/books")
    public ResponseEntity<List<Info.Book>> getAllBooks() {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос книг по id")
    @GetMapping("books/{id}")
    public ResponseEntity<List<Info.Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос книг по наименованию")
    @GetMapping("books/{title}")
    public ResponseEntity<List<Info.Book>> getBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Список всех авторов")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping("authors")
    public ResponseEntity<List<Info.Author>> getAllAuthors() {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос автора по id")
    @GetMapping("authors/{id}")
    public ResponseEntity<Info.Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос автора по имени")
    @GetMapping("authors/{name}")
    public ResponseEntity<Info.Author> getAuthorByName(@PathVariable String name) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
