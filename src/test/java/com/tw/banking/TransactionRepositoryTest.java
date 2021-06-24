package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionRepositoryTest {

    @Test
    void should_add_transaction_when_addDeposit_given_amount() {
        // given
        Clock clock = mock(Clock.class);
        when(clock.todayAsString()).thenReturn("2021-06-24 00:00:00");

        TransactionRepository transactionRepository = new TransactionRepository(new Clock());

        // when
        transactionRepository.addDeposit(10);

        // then
        assertThat(transactionRepository.transactions.size()).isEqualTo(1);
    }

    @Test
    void should_create_transaction_with_amount_when_add_deposit() throws Exception {
        // given
        Transaction transaction = new Transaction("", 10);
        PowerMockito.whenNew(Transaction.class).withArguments(anyString(), eq(10)).thenReturn(transaction);

        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        // when
        transactionRepository.addDeposit(10);

        // then
        assertEquals(transactionRepository.transactions.get(0).amount(), 10);
    }
}
