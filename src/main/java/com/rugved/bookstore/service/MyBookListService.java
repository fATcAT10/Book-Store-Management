package com.rugved.bookstore.service;

import com.rugved.bookstore.entities.MyBookList;
import com.rugved.bookstore.repositories.MyBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    private final MyBookRepository mybook;
    public MyBookListService(MyBookRepository mybook) {
        this.mybook = mybook;
    }

    public void saveMyBooks(MyBookList bookList){
        mybook.save(bookList);
    }

    public List<MyBookList> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(int id){
        mybook.deleteById(id);
    }
}
