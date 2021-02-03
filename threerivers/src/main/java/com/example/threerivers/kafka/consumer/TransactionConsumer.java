package com.example.threerivers.kafka.consumer;

import com.example.threerivers.kafka.BalanceData;
import com.example.threerivers.kafka.TransactionData;
import com.example.threerivers.models.Account;
import com.example.threerivers.models.Transaction;
import com.example.threerivers.repositories.AccountReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionConsumer {

    @Autowired
    private AccountReposiotry accountRepository;

    @KafkaListener(topics = "three_rivers_transaction", groupId = "group_id")
    public void consumeMessage(TransactionData message) {

        System.out.println(message);
        Account accountData = accountRepository.findAccountByacNo(message.getAcNo()).isPresent() ?
                accountRepository.findAccountByacNo(message.getAcNo()).get() : null;

        if (accountData == null)
            return;
        Transaction transaction = new Transaction();
        transaction.setTransactionTime(message.getTransactionTime());
        transaction.setTransactionType(message.getType());
        transaction.setAmount(message.getAmount());

        List<Transaction> transactions = accountData.getTransactions();
        if(transactions == null)
            transactions = Collections.singletonList(transaction);
        else
            transactions.add(transaction);

        accountData.setTransactions(transactions);
        accountRepository.save(accountData);
    }
}