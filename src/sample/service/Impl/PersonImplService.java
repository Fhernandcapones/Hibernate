package sample.service.Impl;

import sample.model.PersonModel;
import sample.repository.PersonRepository;
import sample.service.PersonService;

import java.util.List;

public class PersonImplService implements PersonService {

   private final PersonRepository personRepository;

    public PersonImplService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    /*private PersonRepository personRepository = new PersonRepository();*/



    @Override
    public java.util.List<PersonModel> getPerson() {
        return getPerson();
    }

    @Override
    public void savePerson(PersonModel personModel) {
        this.personRepository.savePerson(personModel);
    }




}
