package com.astontech.hr.repositories;

import com.astontech.hr.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bipin on 5/12/2016.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
