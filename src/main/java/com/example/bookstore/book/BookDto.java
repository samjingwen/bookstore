package com.example.bookstore.book;

import com.example.bookstore.author.AuthorDto;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class BookDto {
  String isbn;
  String title;
  List<AuthorDto> authors;
  int year;
  double price;
  String genre;
}
