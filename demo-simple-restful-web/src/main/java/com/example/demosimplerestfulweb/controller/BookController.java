package com.example.demosimplerestfulweb.controller;


import com.example.demosimplerestfulweb.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
添加、查找和查看
 */
// @RestController 将返回的对象数据直接以 JSON 或 XML 形式写入 HTTP 响应(Response)中
@RestController
// @RequestMapping 默认映射所有HTTP Action
@RequestMapping({"/api"})
public class BookController {
    private List<Book> books = new ArrayList<>();

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book){
        books.add(book);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") int id){
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByName(@RequestParam("name") String name){
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
