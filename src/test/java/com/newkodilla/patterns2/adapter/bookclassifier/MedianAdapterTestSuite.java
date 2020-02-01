package com.newkodilla.patterns2.adapter.bookclassifier;

import com.newkodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite
{
    @Test
    public void publicationYearMedianTest()
    {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author1", "Title1", 1990, "ISBN1"));
        bookSet.add(new Book("Author1", "Title2", 1994, "ISBN2"));
        bookSet.add(new Book("Author2", "Title3", 1995, "ISBN3"));
        bookSet.add(new Book("Author3", "Title4", 2004, "ISBN4"));
        bookSet.add(new Book("Author4", "Title5", 2012, "ISBN5"));
        //When
        int libraryAMedianYearOfPublication = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println("\nMedian year of publication in library A: " + libraryAMedianYearOfPublication + "\n");
        Assert.assertEquals(1995, libraryAMedianYearOfPublication);
    }
}
