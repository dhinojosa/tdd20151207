package com.example.library;

import org.junit.Test;

import javax.activation.FileDataSource;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

public class BookCheckoutReaderTest {

    @Test
    public void testOneItemIterator() {
        BookCheckout dummy =
                new BookCheckout
                        ("A", "B", LocalDate.of(2013, 11, 10));

        List<String> stuff = Arrays.asList("A~B~2013-11-10");

        BookCheckoutReader bcr =
                new BookCheckoutReader(
                        stuff.iterator(),
                        (arg) -> {
                            assertThat(arg).isEqualTo("A~B~2013-11-10");
                            return dummy;
                        });

        BookCheckout bc = bcr.next();
        assertThat(bc).isEqualTo(dummy);
    }

    @Test
    public void testZeroItemIterator() {
        BookCheckout dummy =
                new BookCheckout
                        ("A", "B", LocalDate.of(2013, 11, 10));

        List<String> stuff = Collections.emptyList();

        BookCheckoutReader bcr =
                new BookCheckoutReader(
                        stuff.iterator(),
                        (arg) -> {
                            fail("This should not be called");
                            return dummy;
                        });

        assertThat(bcr.hasNext()).isFalse();
    }

    @Test
    public void testThreeItemIterator() {
        BookCheckout dummy =
                new BookCheckout
                        ("A", "B", LocalDate.of(2013, 11, 10));

        List<String> stuff = Arrays.asList("A~B~2014-11-10",
                                           "C~D~2015-06-13",
                                           "E~F~2015-06-13");

        BookCheckoutReader bcr =
                new BookCheckoutReader(
                        stuff.iterator(),
                        (arg) -> dummy);

        for (int i = 0; i < stuff.size(); i++) {
            bcr.next();
        }

        assertThat(bcr.hasNext()).isEqualTo(false);
    }


    @Test
    public void testIntegrationWithEverything() throws MalformedURLException {
        InputStream is = this.getClass().
                getResourceAsStream("/library.txt");
        Scanner scanner = new Scanner(is);
        scanner.useDelimiter
                (System.getProperty("line.separator"));
        BookCheckoutReader reader =
                new BookCheckoutReader
                        (scanner,
                                BookCheckoutParser::parseLine);
        List<BookCheckout> bookCheckouts = new ArrayList<>();

        while(reader.hasNext()) {
            bookCheckouts.add(reader.next());
        }

        assertThat(bookCheckouts).hasSize(11);

        SimpleBookPenaltyCalculator sb =
                new SimpleBookPenaltyCalculator(10, 1);


        List<PatronNamePenalty> newList = bookCheckouts.
                stream().
                map(bc ->
                        new PatronNamePenalty
                                (bc.getPatronName(),
                                        sb.calculate
                                                (LocalDate.of(2015,10,10), bc.getCheckoutDate()))).
                           sorted().
                           limit(5).
                           collect(Collectors.toList());
    }
}
