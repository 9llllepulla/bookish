package com.controller;

import com.transfer.Info;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping ("/search")
public class SearchAuthorController {

    @Operation (summary = "Список всех авторов")
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    @GetMapping ("authors")
    public ResponseEntity<List<Info.Author>> getAllAuthors() {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос автора по id")
    @GetMapping("authors/{id}")
    public ResponseEntity<Info.Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @Operation (summary = "Запрос автора по имени")
    @GetMapping(value = "authors/name")
    public ResponseEntity<List<Info.Author>> getAuthorsByName(@RequestParam Set<String> names) {
        return ResponseEntity.ok().build();// FIXME: stub
    }
}
