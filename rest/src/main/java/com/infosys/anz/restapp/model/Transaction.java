package com.infosys.anz.restapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.infosys.anz.restapp.control.PayloadFilter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the Transaction Entities
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@Entity
@Data
@EqualsAndHashCode
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(PayloadFilter.Transactions.class)
    private Long id;

    @JsonProperty("ValueDate")
    @JsonView(PayloadFilter.Transactions.class)
    private Date valueDate;

    @JsonProperty("DebitAmount")
    @JsonView(PayloadFilter.Transactions.class)
    private Double debit;

    @JsonProperty("CreditAmount")
    @JsonView(PayloadFilter.Transactions.class)
    private Double credit;

    @JsonProperty("DebitCredit")
    @Column(name = "transaction_type")
    @JsonView(PayloadFilter.Transactions.class)
    private String type;

    @JsonProperty("TransactionNarrative")
    @JsonView(PayloadFilter.Transactions.class)
    private String narrative;
}
