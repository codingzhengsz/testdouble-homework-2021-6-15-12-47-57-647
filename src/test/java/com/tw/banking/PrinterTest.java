package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

}
