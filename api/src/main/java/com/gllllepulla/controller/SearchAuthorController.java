package com.gllllepulla.controller;

import com.gllllepulla.service.SearchAuthorService;
import com.gllllepulla.model.Info;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping ("/search")
public class SearchAuthorController {

    private final SearchAuthorService searchAuthorService;

    @Operation (summary = "Список всех авторов")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping ("authors")
    public ResponseEntity<Set<Info.Author>> getAllAuthors() {
        Set<Info.Author> allAuthors = searchAuthorService.getAllAuthors();
        return ResponseEntity.ok(allAuthors);
    }

    @Operation (summary = "Запрос автора по id")
    @GetMapping("authors/{id}")
    public ResponseEntity<Info.Author> getAuthorById(@PathVariable Long id) {
        return searchAuthorService.findAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (summary = "Запрос автора (-ов) по имени (-ам)")
    @GetMapping(value = "authors/name")
    public ResponseEntity<Set<Info.Author>> getAuthorsByName(@RequestParam Set<String> names) {
        Set<Info.Author> authors = searchAuthorService.findAuthorsByNames(names);
        return ResponseEntity.ok(authors);
    }

    @Operation (summary = "Запрос автора (-ов) по названию книг (-и)")
    @GetMapping(value = "authors/books")
    public ResponseEntity<Set<Info.Author>> getAuthorsByBooksTitles(@RequestParam Set<String> titles) {
        Set<Info.Author> authors = searchAuthorService.findAuthorsByBookTitles(titles);
        return ResponseEntity.ok(authors);
    }
}
