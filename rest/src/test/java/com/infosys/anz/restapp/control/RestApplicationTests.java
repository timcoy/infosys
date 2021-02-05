package com.infosys.anz.restapp.control;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.infosys.anz.restapp.dao.AccountRepository;
import com.infosys.anz.restapp.dao.UserRepository;
import com.infosys.anz.restapp.model.Account;
import com.infosys.anz.restapp.model.Transaction;
import com.infosys.anz.restapp.model.User;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class RestApplicationTests {

    Logger log = LoggerFactory.getLogger(RestApplicationTests.class);

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAccountsByUserId() throws Exception {
        User user = user();
        Mockito.when(userRepository.findById(11L)).thenReturn(Optional.of(user));
        mvc.perform(MockMvcRequestBuilders.get("/accounts/11").content(user.toString())
        //@formatter:off
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].AccountNumber", Matchers.is("Account Number")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].AccountName", Matchers.is("Account Name")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].AccountType", Matchers.is("Account Type")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].OpeningAvailableBalance", Matchers.is(0.01)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].Currency", Matchers.is("Currency")))
            .andDo(MockMvcResultHandlers.print());
        //@formatter:on
    }

    @Test
    public void testTransactionsByAccountId() throws Exception {
        Account account = account();
        Mockito.when(accountRepository.findById(101L)).thenReturn(Optional.of(account));
        mvc.perform(MockMvcRequestBuilders.get("/account/101").content(account.toString())
        //@formatter:off
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[0].CreditAmount", Matchers.is(0.00)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[0].DebitAmount", Matchers.is(0.00)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[0].TransactionNarrative", Matchers.is("Narrative")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.transactions[0].DebitCredit", Matchers.is("Credit/Debit")))
            .andDo(MockMvcResultHandlers.print());
        //@formatter:on
    }

    @Test
    public void testNotFound() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/accounts/12")
        //@formatter:off
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is4xxClientError())
            .andDo(MockMvcResultHandlers.print());
        //@formatter:on
    }

    private User user() {
        User user = new User();
        user.setId(11L);
        user.setName("User Name");
        user.setAccounts(accounts());
        return user;
    }

    private Set<Account> accounts() {
        Set<Account> accounts = new HashSet<>();
        accounts.add(account());
        return accounts;
    }

    private Account account() {
        Account account = new Account();
        account.setId(101L);
        account.setNumber("Account Number");
        account.setName("Account Name");
        account.setType("Account Type");
        account.setBalance(new Double("0.01"));
        account.setCurrency("Currency");
        account.setTransactions(transactions());
        return account;
    }

    private Set<Transaction> transactions() {
        Set<Transaction> transactions = new HashSet<>();
        Transaction transaction = new Transaction();
        transaction.setId(1001L);
        transaction.setCredit(new Double("0.00"));
        transaction.setDebit(new Double("0.00"));
        transaction.setNarrative("Narrative");
        transaction.setType("Credit/Debit");
        transactions.add(transaction);
        return transactions;
    }
}
