package com.example.bookstore.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  @GetMapping
  public List<BookDto> getBooksByTitleOrAuthor(
      @RequestParam(value = "title", required = false) String title,
      @RequestParam(value = "author", required = false) String author) {
    return bookService.findByTitleOrAuthor(title, author);
  }

  @PostMapping
  public void createBook(@RequestBody BookDto bookDto) {
    bookService.createBook(bookDto);
  }

  @PatchMapping("{id}")
  public void updateBook(@PathVariable("id") int id, @RequestBody BookDto bookDto) {
    bookService.updateBook(id, bookDto);
  }

  @DeleteMapping("{id}")
  public void deleteBook(@PathVariable("id") int id) {
    bookService.deleteBook(id);
  }
}
