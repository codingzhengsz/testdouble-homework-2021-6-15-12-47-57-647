package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {

    @Test
    void should_add_deposit_given_amount() {
        // given
        Printer printer = mock(Printer.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);

        Account account = new Account(transactionRepository, printer);
        // when
        account.deposit(10);

        // then
        verify(transactionRepository, times(1)).addDeposit(eq(10));
    }

    @Test
    void should_add_withdraw_given_amount() {
        // given
        Printer printer = mock(Printer.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);

        Account account = new Account(transactionRepository, printer);
        // when
        account.withdraw(10);

        // then
        verify(transactionRepository, times(1)).addWithdraw(eq(10));
    }


    @Test
    void should_print_statement_given_transactions() {
        //given
        Printer printer = mock(Printer.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);

        List<Transaction> transactions = new ArrayList<>();
        when(transactionRepository.allTransactions()).thenReturn(transactions);

        Account account = new Account(transactionRepository, printer);
        //when
        account.printStatement();

        // then
        verify(printer, times(1)).print(transactions);
    }

}
