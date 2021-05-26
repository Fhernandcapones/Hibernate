package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.PersonModel;
import sample.repository.PersonRepository;
import sample.service.PersonService;
import java.net.URL;
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
    private TextField fname;

    @FXML
    private TextField id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list= FXCollections.observableArrayList("male","female");
        gender.setItems(list);
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
          personal.setfName(firstName);
          personal.setlName(lastName);
          personal.setAge(Integer.parseInt(String.valueOf(Ages)));
          personal.setGender(Gender);
          personService.savePerson(personal);
          //RefreshData
          System.out.println(" Pumasok Putangina");
          //cleared setText
          ClearingInput();

      }
      else {
          System.out.println("walang na save");
      }

   }








}



