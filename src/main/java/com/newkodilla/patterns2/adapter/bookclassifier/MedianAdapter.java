package com.newkodilla.patterns2.adapter.bookclassifier;

import com.newkodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.newkodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.newkodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier
{

    @Override
    public int publicationYearMedian(Set<Book> bookSet)
    {
        Map<BookSignature, com.newkodilla.patterns2.adapter.bookclassifier.libraryb.Book> books = new HashMap<>();

        Iterator<Book> bookIterator = bookSet.iterator();

        while (bookIterator.hasNext())
        {
            Book currentBook = bookIterator.next();
            books.put(new BookSignature(currentBook.getSignature()), new BookFromLibraryB(currentBook.getAuthor(), currentBook.getTitle(), currentBook.getPublicationYear()));
        }
        return medianPublicationYear(books);
    }
}
