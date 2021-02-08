package com.infosys.anz.restapp.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.infosys.anz.restapp.dao.AccountRepository;
import com.infosys.anz.restapp.dao.UserRepository;
import com.infosys.anz.restapp.errors.RecordNotFoundException;
import com.infosys.anz.restapp.model.Account;
import com.infosys.anz.restapp.model.User;

/**
 * The AccountController is used for retrieving an Account information
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@RestController
public class AccountController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    /**
     * 
     * @param userId
     * @return a list of accounts for a specific userId
     */
    @JsonView(PayloadFilter.Accounts.class)
    @GetMapping(value = "/accounts/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User accountsByUserId(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RecordNotFoundException("Unable to locate any accounts for userId " + userId));
    }

    /**
     * 
     * @param accountId
     * @return a list of transactions for a specific accountId
     */
    @JsonView(PayloadFilter.Transactions.class)
    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> transactionsByAccountId(@PathVariable Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (!account.isPresent())
            throw new RecordNotFoundException("Unable to locate any transactions for accountId " + accountId);
        return ResponseEntity.ok(account.get());
    }
}
