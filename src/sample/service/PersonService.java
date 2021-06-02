package sample.service;


import sample.model.PersonModel;

import java.util.List;


public interface PersonService {


    List<PersonModel> getPerson();

    void savePerson(PersonModel personal);

}
