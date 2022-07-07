package com.example.bookstore.book;

import com.example.bookstore.author.AuthorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    uses = {AuthorMapper.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  BookDto bookToBookDto(Book book);

  Book bookDtoToBook(BookDto bookDto);
}
