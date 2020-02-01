package com.newkodilla.patterns2.adapter.bookclassifier.librarya;

import java.util.Set;

public interface Classifier
{
    public int publicationYearMedian(Set<Book> bookSet);
}
