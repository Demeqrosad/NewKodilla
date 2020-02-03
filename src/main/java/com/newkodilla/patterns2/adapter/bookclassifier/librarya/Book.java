package com.newkodilla.patterns2.adapter.bookclassifier.librarya;

public class Book
{
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public Book(String author, String title, int publicationYear, String signature)
    {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getPublicationYear()
    {
        return this.publicationYear;
    }

    public String getSignature()
    {
        return this.signature;
    }
}
