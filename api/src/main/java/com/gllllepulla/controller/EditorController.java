package com.gllllepulla.controller;

import com.gllllepulla.service.EditorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.model.Info;

import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/editor")
public class EditorController {

    @Autowired
    private final Map<String, EditorService> services;

    @PutMapping(value = "authors")
    public ResponseEntity<Info.Author> editAuthor(@RequestParam Info.Author author) {
        EditorService<Info.Author> editorService = services.get(ItemType.authors.name());
        return editorService.edit(author)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("authors")
    public ResponseEntity<Info.Author> createAuthor(@RequestBody Info.Author author) {
        EditorService<Info.Author> editorService = services.get(ItemType.authors.name());
        return ResponseEntity.ok()
                .body(editorService.create(author));
    }

    @PutMapping(value = "/books")
    public ResponseEntity<Info.Book> editBook(@RequestParam Info.Book book) {
        EditorService<Info.Book> editorService = services.get(ItemType.books.name());
        return editorService.edit(book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<Info.Book> createBook(@RequestBody Info.Book book) {
        EditorService<Info.Book> editorService = services.get(ItemType.books.name());
        return ResponseEntity.ok()
                .body(editorService.create(book));
    }

    @DeleteMapping("{type}")
    public ResponseEntity<Void> deleteByIds(@PathVariable("type") ItemType type,
                                            @RequestParam Set<Long> ids) {
        services.get(type.name()).deleteByIds(ids);
        return ResponseEntity.ok().build();
    }

}
