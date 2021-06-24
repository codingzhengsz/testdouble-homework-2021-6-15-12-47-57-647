package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionRepositoryTest {

    @Test
    void should_add_transaction_given_amount() {
        // given
        Clock clock = mock(Clock.class);
        when(clock.todayAsString()).thenReturn("2021-06-24 00:00:00");
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());

        // when
        transactionRepository.addDeposit(10);

        // then
        assertThat(transactionRepository.transactions.size()).isEqualTo(1);
    }
}
