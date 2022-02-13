package com.gllllepulla.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.transfer.View;

@Slf4j
@RestController
@RequestMapping ("/editor")
public class EditorController {

    @PutMapping(value = "/authors")
    public ResponseEntity<Void> editAuthor(@RequestParam View.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("/authors")
    public ResponseEntity<View.Author> createAuthor(@RequestBody View.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PutMapping(value = "books")
    public ResponseEntity<Void> editAuthor(@RequestParam View.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("books")
    public ResponseEntity<View.Book> createBook(@RequestBody View.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
