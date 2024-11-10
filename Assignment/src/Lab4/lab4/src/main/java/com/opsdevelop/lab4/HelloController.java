package com.opsdevelop.lab4;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    // Define the list of courses for each program / major
    private String[] coursesComputerScience = {"Java", "Python", "C#", "JavaScript"};
    private String[] coursesBusiness = {"Accounting", "Marketing", "Human Resources","Organizational Behaviour"};

    @FXML
    private TextField nameTextField, addressTextField, provinceTextField, cityTextField, postalTextField, phoneTextField, emailTextField ;
    @FXML
    private CheckBox studCouncilCheckBox, volunteerWorkCheckBox;
    @FXML
    private ToggleGroup programToggle;
    @FXML
    private RadioButton progCsRadio, progBizRadio;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private ComboBox<String> courseComboBox;
    @FXML
    private ListView<String> courseListView;
    // Note the use of generic type parameter <String> to state only items of type String for the UI control
    @FXML
    private Button displayBtn;

    @FXML
    private void initialize() {
        // if there is any initialization to be done, it is ran automatically in this method.
    }

    // Method to handle when either of the program / major radio button is clicked
    @FXML
    protected void progRadioButtonChanged(ActionEvent event) {
        if (progCsRadio.isSelected()) {  // if Computer Science button is selected
            courseComboBox.getItems().setAll(coursesComputerScience); // update the ComboBox to the corresponding list
            courseListView.getItems().clear();  // Clear the current items if the Program is changed
        } else if (progBizRadio.isSelected()) {  //if Business button is selected
            courseComboBox.getItems().setAll(coursesBusiness); //update the ComboBox to the corresponding list
            courseListView.getItems().clear();  // Clear the current items if the Program is changed
        } else {
            courseComboBox.getItems().clear();
        }
    }

    // Method to handle when user select from ComboBox and add to the ListView
    @FXML
    protected void courseComboBoxChanged(ActionEvent event) {
        String newSelectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
//        System.out.println(courseComboBox.getSelectionModel().getSelectedItem());

//        String[] currentSelectedCourses = courseListView.getSelectionModel().getSelectedItem().split(",");
        ObservableList<String> currentSelectedCourses = courseListView.getItems(); // Get the current list in ListView

//        System.out.println("Before changed: " + currentSelectedCourses); //For debugging

        // if the selected course is already in the ListView , print for debugging
        if (newSelectedCourse == null || currentSelectedCourses.contains(newSelectedCourse)) {
            System.out.println("Course selected is empty or already in the list:" + newSelectedCourse); //For debugging
        } else {
            //Only add the course if it is not in the current ListView
            System.out.println("Course selected as new course:" + newSelectedCourse); //For debugging
            courseListView.getItems().add(newSelectedCourse);
        }

        System.out.println("After changed: " + currentSelectedCourses); //For debugging
    }

    // Method to handle when the Display button is clicked
    @FXML
    protected void displayBtnClicked(ActionEvent event) {
        // using trim() method to remove whitespaces at both ends
        String name = nameTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String province = provinceTextField.getText().trim();
        String city = cityTextField.getText().trim();
        String postal = postalTextField.getText().trim();
        String phone = phoneTextField.getText().trim();
        String email = emailTextField.getText().trim();
        // Get all the textfield values

        // Get all the selected courses
        ObservableList<String> courses = courseListView.getItems();

        // Variables to be used for storing the program and other activities
        String selectedProgram = "";
        String activities = "";

        // Store the CheckBox text if it is selected
        String activityStudCouncil = studCouncilCheckBox.isSelected() ? studCouncilCheckBox.getText() : "";
        String activityVolunteer = volunteerWorkCheckBox.isSelected() ? volunteerWorkCheckBox.getText() : "";

        // Validation check if any text input fields are empty, warn the user and quit
        if (name.isBlank() || address.isBlank() || province.isBlank() || city.isBlank()|| postal.isBlank() || phone.isBlank() || email.isBlank()) {
            System.out.println("Some text fields are empty");
            showErrorAlert("All text fields must be filled");
            return;
        // Validation check if the courses list is empty, warn the user and quit
        } else if (courses.isEmpty()) {
            System.out.println("Courses List View is empty");
            showErrorAlert("Please select at least one course");
            return;
        }

        // Get all the Student Information from the text field and store in string
        String studentInfo = String.join(", ", name, address, province, city, postal, phone, email);

        // Store in string from the above courses from ListView
        String selectedCourses = String.join("\n", courses);

        // Get the selected toggle group directly to get the Program chosen from the Radio button
        Toggle selectedToggle = programToggle.getSelectedToggle(); // This gets the selected UI control (as toggle)
        if (selectedToggle != null) {
            RadioButton selectedRadioButton = (RadioButton) selectedToggle ;
            //As Toggle is parent class with less methods, Cast to RadioButton to use other methods
            selectedProgram = selectedRadioButton.getText();
            System.out.println(selectedProgram);
        } else {
            System.out.println("No program chosen");
        }

        // Check if any activity is selected, if so, join them together as string with a heading
        if (!activityStudCouncil.isEmpty() || !activityVolunteer.isEmpty()) {
            activities = "Activities:";
            activities = !activityStudCouncil.isEmpty() ? String.join("\n", activities,activityStudCouncil) : activities;
            activities = !activityVolunteer.isEmpty() ? String.join("\n", activities,activityVolunteer) : activities;
        }

        System.out.println(studentInfo); //For debugging
        System.out.println(selectedCourses); //For debugging
        System.out.println(activities); //For debugging


        // Update the text area for all the information about the student to be displayed
        infoTextArea.setText(String.format("%s\n\nProgram: %s\n\nCourses:\n%s\n\n%s\n", studentInfo, selectedProgram, selectedCourses,activities));

        // Clear all the input fields upon the display
        clearInputFields();

    }

    // Method to show error alert that if certain fields are empty
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to clear all the input fields
    private void clearInputFields() {
        nameTextField.clear();
        addressTextField.clear();
        provinceTextField.clear();
        cityTextField.clear();
        postalTextField.clear();
        phoneTextField.clear();
        emailTextField.clear();

        studCouncilCheckBox.setSelected(false);
        volunteerWorkCheckBox.setSelected(false);

        progCsRadio.setSelected(false);
        progBizRadio.setSelected(false);

        courseComboBox.getItems().clear();
        courseListView.getItems().clear();

    }
}