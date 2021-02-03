package com.example.threerivers.services;

import com.example.threerivers.models.*;
import com.example.threerivers.models.details.AccountDetails;
import com.example.threerivers.repositories.AccountReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountReposiotry accountRepository;

    public AccountDetails getAccountDetails(String accountNumber, Instant from,
                                            Instant to, TypeOfTransaction transactionType) {

        Account account = accountRepository.findAccountByacNo(accountNumber).isPresent() ?
                accountRepository.findAccountByacNo(accountNumber).get() : null;

        if (account == null)
            return null;

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setBalance(account.getBalance());
        List<Transaction> transactions = account.getTransactions();

        if (from != null)
            transactions = transactions.stream().filter(transaction -> transaction.getTransactionTime()
                    .isAfter(from)).collect(Collectors.toList());
        if (to != null)
            transactions = transactions.stream().filter(transaction -> transaction.getTransactionTime()
                    .isBefore(to)).collect(Collectors.toList());
        if (transactionType != null)
            transactions = transactions.stream().filter(transaction -> transactionType.equals(transaction
                    .getTransactionType())).collect(Collectors.toList());

        accountDetails.setListOfTransactions(transactions);

        return accountDetails;
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}