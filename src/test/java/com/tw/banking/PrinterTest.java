package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PrinterTest {

    @Test
    void should_printLine_header() {
        // given
        Console console = mock(Console.class);
        Printer printer = new Printer(console);

        List<Transaction> transactions = new ArrayList<>();
        // when
        printer.print(transactions);

        // then
        verify(console, times(1)).printLine(Printer.STATEMENT_HEADER);
    }

    @Test
    void should_return_statementLine_given_transaction_and_running_balance() {
        // given
        Transaction transaction = new Transaction("2021/06/24", 10);
        int runningBalance = 10;

        Printer printer = new Printer(new Console());
        // when
        String statementLine = printer.statementLine(transaction, runningBalance);

        // then
        assertEquals("2021/06/24 | 10 | 10", statementLine);
    }

    @Test
    void should_print_statementLines_given_transactions() {
        // given
        Console console = mock(Console.class);
        Printer printer = new Printer(console);

        Transaction transaction1 = new Transaction("24/06/2021", 200);
        Transaction transaction2 = new Transaction("24/06/2021", -100);

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);
        // when
        printer.print(transactions);

        // then
        verify(console, times(1)).printLine("24/06/2021 | 200 | 200");
        verify(console, times(1)).printLine("24/06/2021 | -100 | 100");
    }

}
