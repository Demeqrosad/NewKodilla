package com.newkodilla.patterns2.adapter.bookclassifier;

import com.newkodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.newkodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.newkodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.newkodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics
{
    Statistics statistics = new Statistics();

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books)
    {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books)
    {
        return statistics.medianPublicationYear(books);
    }
}
