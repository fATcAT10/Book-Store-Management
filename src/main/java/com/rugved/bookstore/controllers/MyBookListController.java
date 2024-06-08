package com.rugved.bookstore.controllers;

import com.rugved.bookstore.service.MyBookListService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    private final MyBookListService service;
    public MyBookListController(MyBookListService service) {
        this.service = service;
    }

    @RequestMapping("deleteMyList/{id}")
    public String deleteMyList(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/my_books";
    }
}
