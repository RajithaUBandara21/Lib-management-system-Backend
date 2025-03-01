package com.example.library_management_system.entity;


import com.sun.jdi.Value;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_isbn" ,nullable = false  )
   private String isbn;

    @Column(name = "book_title" ,nullable = false  )
    private String title;
    @Column(name = "book_auther" ,nullable = false  )
    private String author;
    @Column(name = "book_category" ,nullable = false  )
    private String category;
    @Column(name = "book_qty" ,nullable = false  )
    private Integer qty;


}
