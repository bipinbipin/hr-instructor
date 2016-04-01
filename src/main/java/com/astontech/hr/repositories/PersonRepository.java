package com.astontech.hr.repositories;

import com.astontech.hr.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bipin on 3/25/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
