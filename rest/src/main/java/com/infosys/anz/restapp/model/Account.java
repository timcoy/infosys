package com.infosys.anz.restapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.infosys.anz.restapp.control.PayloadFilter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the Account Entities
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@Entity
@Data
@EqualsAndHashCode
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(PayloadFilter.BaseView.class)
    @JsonProperty("AccountNumber")
    private String number;

    @JsonView(PayloadFilter.BaseView.class)
    @JsonProperty("AccountName")
    private String name;

    @JsonView(PayloadFilter.Accounts.class)
    @JsonProperty("AccountType")
    @Column(name = "account_type")
    private String type;

    @JsonView(PayloadFilter.Transactions.class)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @JsonView(PayloadFilter.Accounts.class)
    @JsonProperty("BalanceDate")
    @Column(name = "balance_date")
    private Date balanceDate;

    @JsonView(PayloadFilter.Accounts.class)
    @JsonProperty("Currency")
    private String currency;

    @JsonView(PayloadFilter.Accounts.class)
    @JsonProperty("OpeningAvailableBalance")
    private Double balance;
}
