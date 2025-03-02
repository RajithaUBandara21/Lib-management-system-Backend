package com.example.library_management_system.dto.paginate;

import com.example.library_management_system.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedGetAllBooksDTO {
   private List<BookDTO> books;
   private long itemCount;
}
