package sample.service.Impl;

import sample.model.PersonModel;
import sample.repository.PersonRepository;
import sample.service.PersonService;

public class PersonImplService implements PersonService {

   private final PersonRepository personRepository;

    public PersonImplService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    /*private PersonRepository personRepository = new PersonRepository();*/



    @Override
    public void savePerson(PersonModel personModel) {
        this.personRepository.savePerson(personModel);
    }




}
