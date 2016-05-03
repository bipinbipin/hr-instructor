package com.astontech.hr.repositories;

import com.astontech.hr.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Bipin on 3/25/2016.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByLastName(@Param("name") String name);
}
