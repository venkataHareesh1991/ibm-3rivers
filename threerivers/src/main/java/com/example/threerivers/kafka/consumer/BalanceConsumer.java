package com.example.threerivers.kafka.consumer;

import com.example.threerivers.kafka.BalanceData;
import com.example.threerivers.models.Account;
import com.example.threerivers.repositories.AccountReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BalanceConsumer {
    @Autowired
    private AccountReposiotry accountRepository;

    @KafkaListener(topics = "three_rivers_balance", groupId = "group_id")
    public void consumeMessage(BalanceData message) {

        System.out.println(message);
        Account accountData = accountRepository.findAccountByacNo(message.getAcNo()).isPresent() ?
                accountRepository.findAccountByacNo(message.getAcNo()).get() : null;

        if (accountData == null)
            return;

        accountData.setBalance(message.getBalance());
        accountData.setLastUpdatedTime(message.getLastUpdatedTime());
        accountRepository.save(accountData);
    }
}