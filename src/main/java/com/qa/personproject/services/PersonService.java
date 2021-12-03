package com.qa.personproject.services;

import com.qa.personproject.entities.Person;
import com.qa.personproject.entities.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo){
        super();
        this.repo = repo;
    }
//    private List<Person> people = new ArrayList<>();


    public String test(){return "Testing 1, 2, 3!";}

    // Create

    public Person addPerson(Person person) {
//        this.people.add(person);
        return this.repo.save(person);
    }

    // READ
    public List<Person> getAll() {
        return this.repo.findAll();
    }

    // Update
    public Person updatePerson(Long id, Person person) {
        Optional<Person> existingOptional = this.repo.findById(id);
        Person existing = existingOptional.get();
        existing.setAge(person.getAge());
        existing.setFirstname(person.getFirstname());
        existing.setLastname(person.getLastname());

        return this.repo.save(existing);
    }

    //Delete
    public boolean removePerson(Long id) {
        // Remove Person and return it
        this.repo.deleteById(id);
        boolean exists = this.repo.existsById(id);
        return !exists;
    }
}
