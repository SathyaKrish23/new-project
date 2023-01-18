package com.web.doList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.doList.Entity.Person;

@Repository
public interface UserRepository  extends JpaRepository<Person,Long> {

	Person findByName(String name);

}
