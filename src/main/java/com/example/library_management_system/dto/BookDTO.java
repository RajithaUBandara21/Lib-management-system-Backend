package com.example.library_management_system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private Integer qty;
}
