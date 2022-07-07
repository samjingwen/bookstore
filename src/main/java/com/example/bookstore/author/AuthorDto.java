package com.example.bookstore.author;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Builder
@Value
public class AuthorDto {
  String name;
  LocalDate birthday;
}
