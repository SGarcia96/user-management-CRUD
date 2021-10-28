package com.sgarcia.course.service;

import com.sgarcia.course.dao.PersonDao;
import com.sgarcia.course.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, @Valid Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
