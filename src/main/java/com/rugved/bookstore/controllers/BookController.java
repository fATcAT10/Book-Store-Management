package com.rugved.bookstore.controllers;

import com.rugved.bookstore.entities.Book;
import com.rugved.bookstore.entities.MyBookList;
import com.rugved.bookstore.service.BookService;
import com.rugved.bookstore.service.MyBookListService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private final BookService service;
    private final MyBookListService myBookListService;

    public BookController(BookService service, MyBookListService myBookListService) {
        this.service = service;
        this.myBookListService = myBookListService;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("available_books")
    public ModelAndView getAllBook(){
        List<Book> list=service.getAllBook();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list=myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @GetMapping("mylist/{id}")
    public String getMyList(@PathVariable int id){
        Book b=service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookListService.saveMyBooks(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("editBook/{id}")
    public String editBook(@PathVariable int id,Model model){
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        service.deleteById(id);
        return "redirect:/available_books";
    }
}
