package com.qa.personproject.controllers;

import com.qa.personproject.entities.Person;
import com.qa.personproject.services.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service){
        super();
        this.service = service;
    }

    @GetMapping("/test")
    public String test(){return this.service.test();}

    // Create
    @PostMapping("/create")
    public Person addPerson(@RequestBody @Valid Person person) {
        return this.service.addPerson(person);
    }

    // Read
    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    // Update
    @PutMapping("/update")
    public Person updatePerson(@PathParam("id") Long id, @RequestBody @Valid Person person) {
        return this.service.updatePerson(id, person);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable Long id) {
        return this.service.removePerson(id);
    }


}
