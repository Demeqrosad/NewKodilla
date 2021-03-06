package com.newkodilla.patterns2.adapter.bookclassifier.libraryb;

public class Book
{
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public Book(String author, String title, int yearOfPublication)
    {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getYearOfPublication()
    {
        return this.yearOfPublication;
    }
}
