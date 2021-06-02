package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.PersonModel;
import sample.repository.PersonRepository;
import sample.service.PersonService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField lname;

    @FXML
    private TextField age;

    @FXML
    private ComboBox gender;

    @FXML
    private TableView<PersonModel> table;
    @FXML
    private TableColumn<PersonModel, Integer> ID;
    @FXML
    private TableColumn<PersonModel, String> firstname;

    @FXML
    private TableColumn<PersonModel, String> lastname;

    @FXML
    private TableColumn<PersonModel, Integer> Age;

    @FXML
    private TableColumn<PersonModel, String> gen;

    @FXML
    private TextField fname;

    @FXML
    private TextField id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list= FXCollections.observableArrayList("male","female");
        gender.setItems(list);
        getAllData();
    }
    public void ClearingInput(){
        id.setText("");
        fname.setText("");
        lname.setText("");
        age.setText("");

    }
    private final PersonService personService;
    public Controller(){
        this.personService = new PersonRepository();
    }

    private final ObservableList<PersonModel> person = FXCollections.observableArrayList();

    public void getAllData(){
        List<PersonModel> personList = personService.getPerson();

        person.addAll(personList);
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory <> ("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory <> ("lastname"));
        Age.setCellValueFactory(new PropertyValueFactory <> ("age"));
        gen.setCellValueFactory(new PropertyValueFactory <> ("gender"));
        table.setItems(person);

    }


    public void save(){
       String firstName = fname.getText();
       String lastName = lname.getText();
       String Ages = age.getText();
       String Gender = gender.getSelectionModel().getSelectedItem().toString();
       Boolean needfirstName = fname.getText().equals("");
       Boolean needlastName = lname.getText().equals("");
       Boolean needAge =age.getText().equals("");

       PersonModel personal = new PersonModel();

       if (!needfirstName && !needlastName && !needAge )
      {
          personal.setfFirstname(firstName);
          personal.setlLastname(lastName);
          personal.setAge(Integer.valueOf(String.valueOf(Ages)));
          personal.setGender(Gender);
          personService.savePerson(personal);
          //RefreshData
          System.out.println(" Pumasok Putangina");
          //cleared setText
          ClearingInput();
          refreshTable();
      }
      else {
          System.out.println("walang na save");
      }

   }


    public void refreshTable(){
        List<PersonModel> personList = personService.getPerson();


        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstname.setCellValueFactory(new PropertyValueFactory <> ("fname"));
        lastname.setCellValueFactory(new PropertyValueFactory <> ("lname"));
        Age.setCellValueFactory(new PropertyValueFactory <> ("Age"));
        gen.setCellValueFactory(new PropertyValueFactory <> ("gender"));
        person.setAll(personList);

    }




}



