package com.gllllepulla.controller;


import com.gllllepulla.service.EditorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.model.Info;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping ("/editor")
public class EditorController {

    private final EditorService editorService;

    @PutMapping(value = "/authors")
    public ResponseEntity<Info.Author> editAuthor(@RequestParam Info.Author author) {
        return editorService.editAuthor(author)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<Info.Author> createAuthor(@RequestBody Info.Author author) {
        return ResponseEntity.ok()
                .body(editorService.createAuthor(author));
    }

    @DeleteMapping("/authors")
    public ResponseEntity<Void> deleteAuthorsByIds(@RequestParam Set<Long> ids) {
        editorService.deleteAuthorsByIds(ids);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/books")
    public ResponseEntity<Info.Book> editBook(@RequestParam Info.Book book) {
        return editorService.editBook(book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<Info.Book> createBook(@RequestBody Info.Book book) {
        return ResponseEntity.ok()
                .body(editorService.createBook(book));
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteBooksByIds(@RequestParam Set<Long> ids) {
        editorService.deleteBooksByIds(ids);
        return ResponseEntity.ok().build();
    }

}
