package com.infosys.anz.restapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.anz.restapp.model.User;

/**
 * DAO for fetching the User
 * 
 * @author Tim Coy tim.coy@gmail.com
 *
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
