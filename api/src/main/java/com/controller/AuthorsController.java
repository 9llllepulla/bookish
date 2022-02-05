package com.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transfer.AuthorDto;

import java.util.List;

@Slf4j
@RestController
@RequestMapping ("/authors")
public class AuthorsController {

    @Operation (summary = "Список всех авторов")
    @GetMapping
    @ApiResponses (value = {
            @ApiResponse (responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content (schema = @Schema (hidden = true)))
    })
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
