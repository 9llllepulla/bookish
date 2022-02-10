package com.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.transfer.Info;

@Slf4j
@RestController
@RequestMapping ("/editor")
public class EditorController {

    @PutMapping(value = "/authors", params = "author")
    public ResponseEntity<Void> editAuthor(@RequestParam (name = "author") Info.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("/authors")
    public ResponseEntity<Info.Author> createAuthor(@RequestBody Info.Author author) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PutMapping(value = "books", params = "book")
    public ResponseEntity<Void> editAuthor(@RequestParam(name = "book") Info.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

    @PostMapping("books")
    public ResponseEntity<Info.Book> createBook(@RequestBody Info.Book book) {
        return ResponseEntity.ok().build();// FIXME: stub
    }

}
