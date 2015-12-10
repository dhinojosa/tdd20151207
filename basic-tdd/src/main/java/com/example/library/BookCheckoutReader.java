package com.example.library;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

public class BookCheckoutReader {

    private final Iterator<String> iterator;
    private final Function<String, BookCheckout> function;

    public BookCheckoutReader(Iterator<String> iterator,
                              Function<String, BookCheckout>
                                      function) {
        this.iterator = iterator;
        this.function = function;
    }

    public BookCheckout next() {
        return function.apply(iterator.next());
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
