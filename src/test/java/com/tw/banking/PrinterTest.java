package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

}
