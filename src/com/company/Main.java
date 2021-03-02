package com.company;

public class Main {

    public static void main(String[] args) {


        Book[] Books = new Book[]{new Book("Война и мир", "Толстой"),
                new Book("Преступление и наказание", "Достоевский", 1, 600),
                new Book("Журнал Мурзилка", 12, 30)};
        Reader reader = new Reader();
        Book book = reader.choiceBook(Books);
        reader.readBook(book);
        System.out.println(reader.getRate(book));

    }
}


class Book {
    String name, author;
    int serialNumber, pagesNumber;

    Book(String name, String author, int serialNumber, int pagesNumber) {
        this.name = name;
        this.author = author;
        this.serialNumber = serialNumber;
        this.pagesNumber = pagesNumber;

    }

    Book(String name, String author, int serialNumber) {
        this.name = name;
        this.author = author;
        this.serialNumber = serialNumber;
    }

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    Book(String name, int pagesNumber) {
        this.name = name;
        this.pagesNumber = pagesNumber;
    }

    Book(String name, int serialNumber, int pagesNumber) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Название книги='" + name + '\'' +
                ", автор='" + author + '\'' +
                ", Порядковый номер в серии=" + serialNumber +
                ", Количество страниц=" + pagesNumber +
                '}';
    }
}

class Reader {
    Book choiceBook(Book[] Books) {
        final java.util.Random random = new java.util.Random();
        Book book = Books[random.nextInt(Books.length)];
        return book;
    }

    void readBook(Book book) {
        System.out.println(book.toString());
    }

    int getRate(Book book) {
        final java.util.Random random = new java.util.Random();
        int bookNameNum, bookAuthorNum, bookPages, bookSer;
        if (book.name == null) {
            bookNameNum = -random.nextInt(10);
        } else {
            bookNameNum = book.name.length();
        }

        if (book.author == null) {
            bookAuthorNum = -random.nextInt(10);
        } else {
            bookAuthorNum = book.author.length();
        }

        if (book.serialNumber == 0) {
            bookSer = -random.nextInt(10);
        } else {
            bookSer = book.serialNumber;
        }

        if (book.pagesNumber == 0) {
            bookPages = -random.nextInt(10);
        } else {
            bookPages = book.pagesNumber;
        }

        int rate = bookAuthorNum + bookNameNum + bookPages + bookSer;
        return rate;
    }
}
