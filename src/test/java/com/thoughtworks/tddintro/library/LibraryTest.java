package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {

    public List<String> books = new ArrayList<String>();
    public PrintStream printStream = mock(PrintStream.class);
    public DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
    public Library library = new Library(books, printStream, dateTimeFormatter);
    public DateTime time = new DateTime();

    @Before
    public void setUp() throws Exception {
        List<String> books = new ArrayList<String>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);
        DateTime time = new DateTime();
    }

    /*

        List books tests. Implement the first three tests for the Verify exercise

     */


    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);


        library.listBooks();

        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library.listBooks();

        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {

        String one = "1";
        String two = "2";
        books.add(one);
        books.add(two);

        //BufferedReader reader = mock(BufferedReader.class);

        //when(reader.readLine()).thenReturn("1", "2");

        library.listBooks();

        verify(printStream).println(one);
        verify(printStream).println(two);

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */


    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {

        when(dateTimeFormatter.print(time)).thenReturn("");

        library.welcome(time);

        verify(printStream).println(contains(""));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");

        library.welcome(time);

        verify(printStream).println(contains("2013-04-08 16:33:17"));
    }
}