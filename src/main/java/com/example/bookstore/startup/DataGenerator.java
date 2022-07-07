package com.example.bookstore.startup;

import com.example.bookstore.author.AuthorDto;
import com.example.bookstore.book.BookDto;
import com.example.bookstore.book.BookService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DataGenerator implements ApplicationRunner {

  private final BookService bookService;

  @Override
  public void run(ApplicationArguments args) {
    var faker = new Faker(new Random(0));
    IntStream.range(0, 10)
        .forEach(
            each ->
                bookService.createBook(
                    BookDto.builder()
                        .isbn(faker.number().digits(13))
                        .title(faker.book().title())
                        .authors(
                            List.of(
                                AuthorDto.builder()
                                    .name(faker.name().fullName())
                                    .birthday(
                                        faker.date().birthday().toLocalDateTime().toLocalDate())
                                    .build(),
                                AuthorDto.builder()
                                    .name(faker.name().fullName())
                                    .birthday(
                                        faker.date().birthday().toLocalDateTime().toLocalDate())
                                    .build()))
                        .year(faker.number().numberBetween(1800, 2022))
                        .price(faker.number().randomDouble(2, 20, 999))
                        .genre(faker.book().genre())
                        .build()));
  }
}
