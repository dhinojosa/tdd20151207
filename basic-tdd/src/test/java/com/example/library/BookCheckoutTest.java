package com.example.library;

import com.example.UnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.time.LocalDate;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

public class BookCheckoutTest {

    private String patronName;
    private String title;
    private LocalDate date;

    @Before
    public void setUp() {
        patronName = "Sean Bean";
        title = "The Song of Ice and Fire";
        date = LocalDate.of(2014, 4, 30);
    }

    @Test
    @Category(value = UnitTest.class)
    public void testProperties() {
        BookCheckout bookCheckout = new BookCheckout(patronName, title, date);

        assertThat(bookCheckout.getPatronName()).isEqualTo(patronName);
        assertThat(bookCheckout.getTitle()).isEqualTo(title);
        assertThat(bookCheckout.getCheckoutDate()).isEqualTo(date);
    }

    @Test
    @Category(value = UnitTest.class)
    public void testPropertiesDifferentSet() {
        String patronName = "Elvis Presley";
        String title = "Viva Las Vegas";
        LocalDate date = LocalDate.of(2015, 1, 11);

        BookCheckout bookCheckout = new BookCheckout(patronName, title, date);

        assertThat(bookCheckout.getPatronName()).isEqualTo(patronName);
        assertThat(bookCheckout.getTitle()).isEqualTo(title);
        assertThat(bookCheckout.getCheckoutDate()).isEqualTo(date);
    }

    @Test
    @Category(value = UnitTest.class)
    public void testRequiredPatronName() {
        try {
            new BookCheckout(null, title, date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).hasMessage("Provided Patron Name is invalid: [null]");
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testRequiredTitle() {
        try {
            new BookCheckout(patronName, null, date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).
                    hasMessage("Provided Title is invalid: [null]");
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testRequiredCheckoutDate() {
        try {
            new BookCheckout(patronName, title, null);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).
                    hasMessage(
                            "Provided Checkout Date is invalid: [null]");
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testPatronNameIsNotEmpty() {
        try {
            new BookCheckout("", title, date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).
                    hasMessage
                            ("Provided Patron Name is invalid: []");
        }
    }
    /*
	 @Rule
     public ExpectedException thrown = 
            ExpectedException.none();
    
     @Test
     public void testRequiredFieldsTitleIsEmpty() {
           String patronName = "Elvis";
           String title = "";
           LocalDate date = LocalDate.of(1888, 2, 12);
          
           thrown.expect(IllegalArgumentException.class);
           thrown.expectMessage("Title cannot be empty.");
          
           BookCheckout bookCheckout =
                     new BookCheckout(patronName, title, date);
     }*/

    @Test
    @Category(value = UnitTest.class)
    public void testTitleIsNotEmpty() {
        try {
            new BookCheckout(patronName, "", date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).
                    hasMessage
                            ("Provided Title is invalid: []");
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testPatronNameIsNotEmptyWithSpaces() {
        String patronNameFluffy = "      ";
        try {
            new BookCheckout(patronNameFluffy, title, date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).
                    hasMessage
                            (String.format
                                    ("Provided Patron Name is invalid: [%s]", patronNameFluffy));
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testTitleIsNotEmptyWithSpaces() {
        String titleFluffy = "    ";
        try {
            new BookCheckout(patronName, titleFluffy, date);
            fail("This should not run");
        } catch (IllegalArgumentException iae) {
            assertThat(iae).hasMessage
                    (String.format
                            ("Provided Title is invalid: [%s]", titleFluffy));
        }
    }

    @Test
    @Category(value = UnitTest.class)
    public void testEquality() {
        BookCheckout bc1 =
                new BookCheckout(patronName, title, date);
        BookCheckout bc2 =
                new BookCheckout(patronName, title, date);
        assertThat(bc1).isEqualTo(bc2);
    }

    @Test
    @Category(value = UnitTest.class)
    public void testEqualityWithDifferentObjects() {
        BookCheckout bc1 =
                new BookCheckout(patronName, title, date);
        assertThat(bc1).isNotEqualTo("Cool");
    }

    @Test
    @Category(value = UnitTest.class)
    public void testEqualityWithDifferentPatronName() {
        BookCheckout bc1 =
                new BookCheckout(patronName, title, date);
        BookCheckout bc2 =
                new BookCheckout("Stu", title, date);
        assertThat(bc1).isNotEqualTo(bc2);
    }

    @Test
    @Category(value = UnitTest.class)
    public void testEqualityWithDifferentTitle() {
        BookCheckout bc1 =
                new BookCheckout(patronName, title, date);
        BookCheckout bc2 =
                new BookCheckout(patronName, "Foo", date);
        assertThat(bc1).isNotEqualTo(bc2);
    }
    @After
    public void cleanUp() {
        patronName = null;
    }
}
