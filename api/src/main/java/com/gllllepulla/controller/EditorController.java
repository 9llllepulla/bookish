package com.gllllepulla.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gllllepulla.transfer.Info;

@Slf4j
@RestController
@RequestMapping ("/editor")
public class EditorController {

    @PutMapping(value = "/authors")
    public ResponseEntity<Void> editAuthor(@RequestParam Info.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("/authors")
    public ResponseEntity<Info.Author> createAuthor(@RequestBody Info.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PutMapping(value = "books")
    public ResponseEntity<Void> editAuthor(@RequestParam Info.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("books")
    public ResponseEntity<Info.Book> createBook(@RequestBody Info.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
