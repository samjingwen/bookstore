create table author
(
    id       integer      not null auto_increment,
    name     varchar(255),
    birthday date,
    primary key (id)
);

create table book
(
    id        integer not null auto_increment,
    isbn      varchar(255) unique,
    title     varchar(255),
    "year"    integer,
    price     numeric(20, 2),
    genre     varchar(255),
    primary key (id)
);

create table book_author(
  book_id integer,
  author_id integer,
  foreign key (book_id) references book(id),
  foreign key (author_id) references author(id)
);
