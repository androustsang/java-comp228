package com.opsdevelop.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;

// For Oracle database connectivity
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class HelloController {

    @FXML
    private Button addPlayedGameBtn;

    @FXML
    private TextField addressText;

    @FXML
    private Button displayPlayerGameBtn;

    @FXML
    private TableColumn<?, ?> firstNameCol;

    @FXML
    private TextField firstNameText;

    @FXML
    private TableColumn<?, ?> gameIdCol;

    @FXML
    private ComboBox<?> gameIdCombo;

    @FXML
    private TextField gameIdText;

    @FXML
    private Button gameNewBtn;

    @FXML
    private Button gameSearchBtn;

    @FXML
    private TextArea gameTextArea;

    @FXML
    private TableColumn<?, ?> gameTitleCol;

    @FXML
    private TextField gameTitleText;

    @FXML
    private Button gameUpdateBtn;

    @FXML
    private TableColumn<?, ?> lastNameCol;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private TableView<?> playerGameTable;

    @FXML
    private TableColumn<?, ?> playerIdCol;

    @FXML
    private ComboBox<?> playerIdCombo;

    @FXML
    private TextField playerIdText;

    @FXML
    private Button playerNewBtn;

    @FXML
    private Button playerSearchBtn;

    @FXML
    private TextArea playerTextArea;

    @FXML
    private Button playerUpdateBtn;

    @FXML
    private DatePicker playingDate;

    @FXML
    private TableColumn<?, ?> playingDateCol;

    @FXML
    private TextField postalCodeText;

    @FXML
    private TextField provinceText;

    @FXML
    private TableColumn<?, ?> scoreCol;

    @FXML
    private TextField scoreText;

    private Connection connection;
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    private void connectDatabase() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Database connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        };

    }

    private void disconnectDatabase() {
        try {
            connection.close();
            System.out.println("Database connection is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void initialize() {
        connectDatabase();

    }

    // Method to show error alert that if certain fields are empty
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void playerSearchBtnClicked() throws SQLException {

        Statement sql_stmt = connection.createStatement();


        if (playerIdText.getText().isEmpty()) {
            showErrorAlert("Player ID cannot be empty");
        } else {


        }

    }
//    @FXML
//    protected void cleanup() {
//        disconnectDatabase();
//    }


//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
}