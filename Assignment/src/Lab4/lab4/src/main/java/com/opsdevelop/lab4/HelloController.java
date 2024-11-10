package com.opsdevelop.lab4;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class HelloController {
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
//        nameLabel.setPrefHeight(nameTextField.getHeight());
//        addressLabel.prefHeightProperty().bind(addressTextField.heightProperty());
    }

    @FXML
    protected void progRadioButtonChanged(ActionEvent event) {
        if (progCsRadio.isSelected()) {
            courseComboBox.getItems().setAll(coursesComputerScience);
            courseListView.getItems().clear();  // Clear the current items if the Program is changed
        } else if (progBizRadio.isSelected()) {
            courseComboBox.getItems().setAll(coursesBusiness);
            courseListView.getItems().clear();  // Clear the current items if the Program is changed
        } else {
            courseComboBox.getItems().clear();
        }
    }

    @FXML
    protected void courseComboBoxChanged(ActionEvent event) {
        String newSelectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
//        System.out.println(courseComboBox.getSelectionModel().getSelectedItem());

//        String[] currentSelectedCourses = courseListView.getSelectionModel().getSelectedItem().split(",");
//        String[] currentSelectedCourses = courseListView.getSelectionModel().getSelectedItems().toArray(new String[0]);
        ObservableList<String> currentSelectedCourses = courseListView.getItems();

        System.out.println("Before changed: " + currentSelectedCourses);

        if (newSelectedCourse == null || currentSelectedCourses.contains(newSelectedCourse)) {
            System.out.println("Course selected is empty or already in the list:" + newSelectedCourse);
        } else {
            System.out.println("Course selected as new course:" + newSelectedCourse);
            courseListView.getItems().add(newSelectedCourse);
        }

        System.out.println("After changed: " + currentSelectedCourses);
    }

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
        ObservableList<String> courses = courseListView.getItems();
        String selectedProgram = "";
        String activities = "";

        String activityStudCouncil = studCouncilCheckBox.isSelected() ? studCouncilCheckBox.getText() : "";
        String activityVolunteer = volunteerWorkCheckBox.isSelected() ? volunteerWorkCheckBox.getText() : "";

        // Check if any text input fields are empty, warn the user and quit
        if (name.isBlank() || address.isBlank() || province.isBlank() || city.isBlank()|| postal.isBlank() || phone.isBlank() || email.isBlank()) {
            System.out.println("Some text fields are empty");
            showErrorAlert("All text fields must be filled");
            return;
        // Check if the courses list is empty, warn the user and quit
        } else if (courses.isEmpty()) {
            System.out.println("Courses List View is empty");
            showErrorAlert("Please select at least one course");
            return;
        }

        String studentInfo = String.join(", ", name, address, province, city, postal, phone, email);
        String selectedCourses = String.join("\n", courses);

        // Get the selected toggle directly to get the Program chosen from the Radio button
        Toggle selectedToggle = programToggle.getSelectedToggle();
        if (selectedToggle != null) {
            RadioButton selectedRadioButton = (RadioButton) selectedToggle ;
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

        System.out.println(studentInfo);
        System.out.println(selectedCourses);
        System.out.println(activities);


        // Update the text area for all the information about the student to be displayed
        infoTextArea.setText(String.format("%s\n\nProgram: %s\n\nCourses:\n%s\n\n%s\n", studentInfo, selectedProgram, selectedCourses,activities));

        // Clear all the input fields upon the display
        clearInputFields();

    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

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