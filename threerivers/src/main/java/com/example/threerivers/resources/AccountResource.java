package com.example.threerivers.resources;

import com.example.threerivers.exception.AccountInvalid;
import com.example.threerivers.models.Account;
import com.example.threerivers.models.TypeOfTransaction;
import com.example.threerivers.models.details.AccountDetails;
import com.example.threerivers.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping("{acNo}")
    public AccountDetails getAccountDetails(@PathVariable String acNo,
                                            @RequestParam(required = false) Instant from,
                                            @RequestParam(required = false) Instant to,
                                            @RequestParam(required = false) TypeOfTransaction transactionType) {
        AccountDetails accountDetails = accountService.
                getAccountDetails(acNo, from, to, transactionType);
        if (accountDetails == null)
            throw new AccountInvalid("You have entered an invalid account. Please provide a valid account data");

        return accountDetails;
    }

    @PostMapping("/save")
    public void saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
    }
}