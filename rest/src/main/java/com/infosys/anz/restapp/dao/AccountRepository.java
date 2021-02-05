package com.infosys.anz.restapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.anz.restapp.model.Account;

/**
 * DAO for fetching the Accounts
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@Transactional
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
