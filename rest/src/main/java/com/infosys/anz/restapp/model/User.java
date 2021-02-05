package com.infosys.anz.restapp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.infosys.anz.restapp.control.PayloadFilter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the User Entity
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@Entity
@Data
@EqualsAndHashCode
@JsonIgnoreProperties(value = { "transactions" })
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonView(PayloadFilter.Accounts.class)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Account> accounts;
}
