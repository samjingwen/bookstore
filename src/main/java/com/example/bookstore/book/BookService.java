package com.example.bookstore.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public void createBook(BookDto bookDto) {
    bookRepository.save(BookMapper.INSTANCE.bookDtoToBook(bookDto));
  }

  public List<BookDto> findByTitleOrAuthor(String title, String author) {
    return bookRepository.findAllByTitleOrAuthorsName(title, author).stream()
        .map(BookMapper.INSTANCE::bookToBookDto)
        .toList();
  }

  public void updateBook(int id, BookDto bookDto) {
    Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);
    book.setId(id);
    bookRepository.save(book);
  }

  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }
}
