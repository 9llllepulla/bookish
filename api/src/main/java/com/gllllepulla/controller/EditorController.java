package com.gllllepulla.controller;


import com.gllllepulla.service.EditorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.transfer.View;

import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping ("/editor")
public class EditorController {

    private final EditorService editorService;

    @PutMapping(value = "/authors")
    public ResponseEntity<View.Author> editAuthor(@RequestParam View.Author author) {
        return editorService.editAuthor(author)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<View.Author> createAuthor(@RequestBody View.Author author) {
        return ResponseEntity.ok()
                .body(editorService.createAuthor(author));
    }

    @DeleteMapping("/authors")
    public ResponseEntity<Void> deleteAuthorsByIds(@RequestParam Set<Long> ids) {
        editorService.deleteAuthorsByIds(ids);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "books")
    public ResponseEntity<View.Book> editBook(@RequestParam View.Book book) {
        return editorService.editBook(book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("books")
    public ResponseEntity<View.Book> createBook(@RequestBody View.Book book) {
        return ResponseEntity.ok()
                .body(editorService.createBook(book));
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteBooksByIds(@RequestParam Set<Long> ids) {
        editorService.deleteBooksByIds(ids);
        return ResponseEntity.ok().build();
    }

}
