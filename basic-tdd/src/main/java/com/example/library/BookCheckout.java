package com.example.library;

import java.time.LocalDate;
import java.util.Objects;

public class BookCheckout {

    private final String patronName;
    private final String title;
    private final LocalDate checkoutDate;

    private static final String ERROR_MESSAGE_TEMPLATE =
            "Provided %s is invalid: [%s]";

    public BookCheckout(String patronName,
                        String title, LocalDate checkoutDate) {


        if (patronName == null || patronName.trim().isEmpty()) throw new
                IllegalArgumentException
                (String.format
                        (ERROR_MESSAGE_TEMPLATE, "Patron Name", patronName));

        if (title == null || title.trim().isEmpty()) throw new
                IllegalArgumentException
                (String.format
                        (ERROR_MESSAGE_TEMPLATE, "Title", title));

        if (checkoutDate == null) throw new
                IllegalArgumentException
                (String.format
                        (ERROR_MESSAGE_TEMPLATE, "Checkout Date", checkoutDate));

        this.patronName = patronName;
        this.title = title;
        this.checkoutDate = checkoutDate;
    }

    public String getPatronName() {
        return patronName;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((checkoutDate == null) ? 0 : checkoutDate.hashCode());
        result = prime * result + ((patronName == null) ? 0 : patronName.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BookCheckout)) return false;
        else {
            BookCheckout other = (BookCheckout) obj;
            return Objects.equals(this.patronName, other.patronName) &&
                    Objects.equals(this.title, other.title) &&
                    Objects.equals(this.checkoutDate, other.checkoutDate);
        }
    }


}
