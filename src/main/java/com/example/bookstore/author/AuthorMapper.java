package com.example.bookstore.author;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {
  AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

  AuthorDto authorToAuthorDto(Author author);

  Author authorDtoToAuthor(AuthorDto authorDto);
}
