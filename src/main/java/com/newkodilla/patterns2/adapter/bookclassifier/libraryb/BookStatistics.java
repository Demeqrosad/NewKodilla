package com.newkodilla.patterns2.adapter.bookclassifier.libraryb;

import java.util.Map;

public interface BookStatistics
{
    public int averagePublicationYear(Map<BookSignature, Book> books);
    public int medianPublicationYear(Map<BookSignature, Book> books);
}
