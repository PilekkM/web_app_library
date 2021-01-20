CREATE SEQUENCE books_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE authors_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE rented_books_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;

CREATE SEQUENCE users_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE books (
    id int8 NOT NULL DEFAULT nextval('books_id'),
    author_id int8,
    title VARCHAR (255),
    quantity int,
    PRIMARY KEY (id));

CREATE TABLE authors (
    id int8 NOT NULL DEFAULT nextval('authors_id'),
    names VARCHAR (255),
    surname VARCHAR (255),
    PRIMARY KEY (id)
);

CREATE TABLE rented_books (
    id int8 NOT NULL DEFAULT nextval('rented_books_id'),
    book_id int8,
    user_id int8,
    return_date DATE,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id int8 NOT NULL DEFAULT nextval('users_id'),
    name VARCHAR (255),
    surname VARCHAR (255),
    personal_id varchar (255),
    age int,
    PRIMARY KEY (id)
);

ALTER TABLE if EXISTS books
ADD CONSTRAINT authors_fk
FOREIGN KEY(author_id) REFERENCES authors;

ALTER TABLE if EXISTS rented_books
ADD CONSTRAINT users_fk
FOREIGN KEY(user_id) REFERENCES users;

ALTER TABLE if EXISTS rented_books
ADD CONSTRAINT books_fk
FOREIGN KEY(book_id) REFERENCES books;
