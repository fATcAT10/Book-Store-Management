package com.rugved.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MyBooks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
