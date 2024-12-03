package com.opsdevelop.lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

// For Oracle database connectivity
import java.sql.*;
import java.util.ArrayList;

import io.github.cdimascio.dotenv.Dotenv;

public class HelloController {

    @FXML
    private Button addPlayedGameBtn;

    @FXML
    private TextField addressText;

    @FXML
    private Button reportBtn;

    @FXML
    private TableColumn<PlayerGameRecord, String> firstNameCol;

    @FXML
    private TextField firstNameText;

    @FXML
    private TableColumn<PlayerGameRecord, String> gameIdCol;

    @FXML
    private ComboBox<String> gameIdCombo;

    @FXML
    private TextField gameIdText;

    @FXML
    private Button gameNewBtn;

    @FXML
    private Button gameSearchBtn;

    @FXML
    private TextArea gameTextArea;

    @FXML
    private TableColumn<PlayerGameRecord, String> gameTitleCol;

    @FXML
    private TextField gameTitleText;

    @FXML
    private TableColumn<PlayerGameRecord, String> lastNameCol;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField phoneNumberText;

    @FXML
    private TableView<PlayerGameRecord> playerGameTable;

    @FXML
    private TableColumn<PlayerGameRecord, String> playerIdCol;

    @FXML
    private ComboBox<String> playerIdCombo;

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
    private TableColumn<PlayerGameRecord, Date> playingDateCol;

    @FXML
    private TextField postalCodeText;

    @FXML
    private TextField provinceText;

    @FXML
    private TableColumn<PlayerGameRecord, Integer> scoreCol;

    @FXML
    private TextField scoreText;

    private Connection connection;
    private Statement stmt;
    private static final Dotenv dotenv = Dotenv.configure().directory("src/main/resources").load();
    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    private final ObservableList<PlayerGameRecord> playerGameRecords = FXCollections.observableArrayList();

    private void connectDatabase() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(URL, USER, PASS);
            stmt = connection.createStatement();
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

    private void loadAllPlayerId() {

        ArrayList<String> player_ids = new ArrayList<String>();
        String player_id ;
        try {
            // Below two lines further validate the database connection
//            String tmp = connection.isValid(5) ? "Valid Connection" : "Invalid Connection";
//            System.out.println(tmp);
            String sql = "SELECT * from SUN_HUNG_TSANG_PLAYER ORDER BY PLAYER_ID";
//            String sql = "SELECT 1 from DUAL";
//            Statement stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                // Get the column by Index
//                player_id = rset.getString(1);
                // Get the column by ColumnLabel
                player_id = rset.getString("PLAYER_ID");
                System.out.println(player_id);
                player_ids.add(player_id);
            }
            playerIdCombo.getItems().setAll(player_ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadAllGameId () {
        String game_id ;
        ArrayList<String> game_ids = new ArrayList<String>();
        String sql = "SELECT GAME_ID from SUN_HUNG_TSANG_GAME ORDER BY GAME_ID";
        try {
//            Statement stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                game_id = rset.getString("GAME_ID");
                System.out.println(game_id);
                game_ids.add(game_id);
            }
            gameIdCombo.getItems().setAll(game_ids);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void loadPlayerGameRecords() {
        String sql = "SELECT pag.PLAYER_ID, p.FIRST_NAME, p.LAST_NAME, pag.GAME_ID, g.GAME_TITLE, pag.PLAYING_DATE, pag.SCORE FROM SUN_HUNG_TSANG_PLAYER_AND_GAME pag JOIN SUN_HUNG_TSANG_PLAYER p ON pag.PLAYER_ID = p.PLAYER_ID JOIN SUN_HUNG_TSANG_GAME g ON pag.GAME_ID = g.GAME_ID";

        // Clear any existing data in the ObservableList
        playerGameRecords.clear();

        try {
            ResultSet rset = stmt.executeQuery(sql);
            // Loop through the ResultSet and add the data to the ObservableList
            while (rset.next()) {
//                System.out.println("Query succeeded");
                String player_id = rset.getString("PLAYER_ID");
                String first_name = rset.getString("FIRST_NAME");
                String last_name = rset.getString("LAST_NAME");
                String game_id = rset.getString("GAME_ID");
                String game_title = rset.getString("GAME_TITLE");
                Date playing_date = rset.getDate("PLAYING_DATE");
                int score = rset.getInt("SCORE");

                // Add new PlayerGame object to the ObservableList
                playerGameRecords.add(new PlayerGameRecord(player_id,first_name,last_name,game_id,game_title,playing_date,score));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Constructor of HelloController for initializing playerGameRecords
//    public HelloController() {
//
//        playerGameRecords = FXCollections.observableArrayList();
//    }

    @FXML
    private void initialize() {
        connectDatabase();
        loadAllPlayerId();
        loadAllGameId();
        playerUpdateBtn.setDisable(true);   //Disable the Update Button and only enable after search

        // Set up the table columns
        playerIdCol.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        gameIdCol.setCellValueFactory(new PropertyValueFactory<>("gameId"));
        gameTitleCol.setCellValueFactory(new PropertyValueFactory<>("gameTitle"));
        playingDateCol.setCellValueFactory(new PropertyValueFactory<>("playingDate"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));

        // Link the data to the table
        playerGameTable.setItems(playerGameRecords);

    }

    // Method to show error alert that if certain fields are empty
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Validation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to show information of adding new Player or Game
    private void showInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void playerSearchBtnClicked() {
        String sql = "Select PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER FROM SUN_HUNG_TSANG_PLAYER where PLAYER_ID = '" + playerIdText.getText().trim() + "'";

        if (playerIdText.getText().isBlank()) {
            showErrorAlert("Player ID cannot be empty");
        } else {
            // Clear the fields first before continuing
//            playerIdText.clear();
            firstNameText.clear();
            lastNameText.clear();
            addressText.clear();
            postalCodeText.clear();
            provinceText.clear();
            phoneNumberText.clear();

            try {
                ResultSet rset = stmt.executeQuery(sql);

                if (rset.next()) {
                    playerIdText.setText(rset.getString("PLAYER_ID"));
                    firstNameText.setText(rset.getString("FIRST_NAME"));
                    lastNameText.setText(rset.getString("LAST_NAME"));
                    addressText.setText(rset.getString("ADDRESS"));
                    postalCodeText.setText(rset.getString("POSTAL_CODE"));
                    provinceText.setText(rset.getString("PROVINCE"));
                    phoneNumberText.setText(String.valueOf(rset.getLong("PHONE_NUMBER")));

                    // Allow the update if the Player can be found
                    playerUpdateBtn.setDisable(false);
                } else {
                    showErrorAlert("Player ID not found");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    protected void playerUpdateBtnClicked() {
        // Performing the update
        if (playerIdText.getText().isBlank() || firstNameText.getText().isBlank() || lastNameText.getText().isBlank() || addressText.getText().isBlank() || postalCodeText.getText().isBlank() || provinceText.getText().isBlank() || phoneNumberText.getText().isBlank()) {
            showErrorAlert("All fields are required");
        } else {
            String psql = "Update SUN_HUNG_TSANG_PLAYER set FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, POSTAL_CODE = ?, PROVINCE =?, PHONE_NUMBER = ? where PLAYER_ID = ? ";
            try {
                PreparedStatement pstmt = connection.prepareStatement(psql);
                pstmt.setString(1, firstNameText.getText().trim());
                pstmt.setString(2, lastNameText.getText().trim());
                pstmt.setString(3, addressText.getText().trim());
                pstmt.setString(4, postalCodeText.getText().trim());
                pstmt.setString(5, provinceText.getText().trim());
                pstmt.setLong(6, Long.parseLong(phoneNumberText.getText().trim()));
                pstmt.setString(7, playerIdText.getText().trim());
                int recordsUpdated = pstmt.executeUpdate();
                if (recordsUpdated > 0) {
                    System.out.println(recordsUpdated + " records updated");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            // After the update is performed, disable again until a search is performed.
            playerUpdateBtn.setDisable(true);
        }


    }

    @FXML
    protected void playerNewBtnClicked() {
        // Performing the insert of new Player
        if (firstNameText.getText().isBlank() || lastNameText.getText().isBlank() || addressText.getText().isBlank() || postalCodeText.getText().isBlank() || provinceText.getText().isBlank() || phoneNumberText.getText().isBlank()) {
            showErrorAlert("All fields except Player ID are required");
        } else {
            // Get the current maximum primary key first
            // All Primary Key format for Player table is P000 ("P" followed by 3 digits

            String sql = "SELECT PLAYER_ID FROM SUN_HUNG_TSANG_PLAYER ORDER BY TO_NUMBER(SUBSTR(PLAYER_ID, 2)) DESC FETCH FIRST 1 ROWS ONLY";
            // The above SQL returned the current maximum primary key

            String psql = "INSERT INTO SUN_HUNG_TSANG_PLAYER VALUES (?,?,?,?,?,?,?) ";
            // The above is the prepared statement for the insert
            try {
                // First build a new primary key by checking on the existing largest primary key
                ResultSet rset = stmt.executeQuery(sql);
                String newPlayerPK ;
                if (rset.next()) {
                    // if there is an existing maximum primary key
                    String curMaxPlayerPK = rset.getString("PLAYER_ID");
                    newPlayerPK = incPrimaryKey(curMaxPlayerPK);
                } else {
                    // There is no record in the table.
                    newPlayerPK = "P001";
                }

                PreparedStatement pstmt = connection.prepareStatement(psql);
                pstmt.setString(1, newPlayerPK);
                pstmt.setString(2, firstNameText.getText().trim());
                pstmt.setString(3, lastNameText.getText().trim());
                pstmt.setString(4, addressText.getText().trim());
                pstmt.setString(5, postalCodeText.getText().trim());
                pstmt.setString(6, provinceText.getText().trim());
                pstmt.setLong(7, Long.parseLong(phoneNumberText.getText().trim()));

                int recordsInserted = pstmt.executeUpdate();

                if (recordsInserted > 0) {
                    System.out.println(recordsInserted + " records inserted");
//                    showInformation(String.format("New Player is added.%nPlayer ID: %s%nFirst Name: %s%nLast Name: %s%nAddress: %s%nPostal Code: %s%nProvince: %s%nPhone Number: %d", newPlayerPK, firstNameText.getText().trim(), lastNameText.getText().trim(), addressText.getText().trim(), postalCodeText.getText().trim(), provinceText.getText().trim(),phoneNumberText.getText().trim()));
                    showInformation(String.format("New Player is added.%nPlayer ID: %s%n", newPlayerPK));
                }

                // As new record is added, refresh Player ID combo
                loadAllPlayerId();

                // Clear the input
                playerIdText.clear();
                firstNameText.clear();
                lastNameText.clear();
                addressText.clear();
                postalCodeText.clear();
                provinceText.clear();
                phoneNumberText.clear();


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @FXML
    private void gameSearchBtnClicked() {
        String sql = "Select GAME_ID, GAME_TITLE FROM SUN_HUNG_TSANG_GAME where GAME_ID = '" + gameIdText.getText().trim() + "'";

        if (gameIdText.getText().isBlank()) {
            showErrorAlert("Game ID cannot be empty");
        } else {
            // Clear the fields first before continuing
            gameTitleText.clear();

            try {
                ResultSet rset = stmt.executeQuery(sql);

                if (rset.next()) {
                    gameIdText.setText(rset.getString("GAME_ID"));
                    gameTitleText.setText(rset.getString("GAME_TITLE"));
                } else {
                    showErrorAlert("GAME ID not found");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    protected void gameNewBtnClicked() {
        // Performing the insert of new Game
        if (gameTitleText.getText().isBlank()) {
            showErrorAlert("Game Title field is required");
        } else {
            // Get the current maximum primary key first
            // All Primary Key format for Game table is G000 ("G" followed by 3 digits)

            String sql = "SELECT GAME_ID FROM SUN_HUNG_TSANG_GAME ORDER BY TO_NUMBER(SUBSTR(GAME_ID, 2)) DESC FETCH FIRST 1 ROWS ONLY";
            // The above SQL returned the current maximum primary key

            String psql = "INSERT INTO SUN_HUNG_TSANG_GAME VALUES (?,?) ";
            // The above is the prepared statement for the insert
            try {
                // First build a new primary key by checking on the existing largest primary key
                ResultSet rset = stmt.executeQuery(sql);
                String newGamePK ;
                if (rset.next()) {
                    // if there is an existing maximum primary key
                    String curMaxGamePK = rset.getString("GAME_ID");
                    newGamePK = incPrimaryKey(curMaxGamePK);
                } else {
                    // There is no record in the table.
                    newGamePK = "G001";
                }

                PreparedStatement pstmt = connection.prepareStatement(psql);
                pstmt.setString(1, newGamePK);
                pstmt.setString(2, gameTitleText.getText().trim());

                int recordsInserted = pstmt.executeUpdate();

                if (recordsInserted > 0) {
                    System.out.println(recordsInserted + " records inserted");
                    showInformation(String.format("New Game is added.%nGame ID: %s%n", newGamePK));
                    gameIdText.clear();
                    gameTitleText.clear();
                }
                // As new record is added, refresh Player ID combo
                loadAllGameId();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }


    @FXML
    protected void playerIdComboClicked(ActionEvent event) {

        String newSelectedPlayer = playerIdCombo.getSelectionModel().getSelectedItem();
        String sql = "Select PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER FROM SUN_HUNG_TSANG_PLAYER where PLAYER_ID = '" + newSelectedPlayer + "'";
        System.out.println(newSelectedPlayer);

        try {
            ResultSet rset = stmt.executeQuery(sql);
            // It should only return one player info.
            if (rset.next()) {
                String player_id = rset.getString("PLAYER_ID");
                String firstName = rset.getString("FIRST_NAME");
                String lastName = rset.getString("LAST_NAME");
                String address = rset.getString("ADDRESS");
                String postalCode = rset.getString("POSTAL_CODE");
                String province = rset.getString("PROVINCE");
                String phoneNumber = String.valueOf(rset.getLong("PHONE_NUMBER"));
                String playerTextOutput = String.format("Player ID: %s%nFirst Name: %s%nLast Name: %s%nAddress: %s%nPostal Code: %s%nProvince: %s%nPhone Number: %s", player_id, firstName, lastName, address, postalCode, province,phoneNumber);
                System.out.println(playerTextOutput);
                playerTextArea.setText(playerTextOutput);
            } else {
                showErrorAlert("Player ID not found");
            }
        } catch (SQLException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

    }

    @FXML
    protected void setGameIdComboClicked(ActionEvent event) {
        String newGameId = gameIdCombo.getSelectionModel().getSelectedItem();
        String sql = "SELECT GAME_ID,GAME_TITLE FROM SUN_HUNG_TSANG_GAME WHERE GAME_ID = '" + newGameId + "'";
        try {
            ResultSet rset = stmt.executeQuery(sql);
            // There should be only 1 record retured
            if (rset.next()) {
                String game_id = rset.getString("GAME_ID");
                String game_title = rset.getString("GAME_TITLE");
                String gameTextOutput = String.format("Game ID: %s%nGame Title: %s%n", game_id, game_title);
                System.out.println(gameTextOutput);
                gameTextArea.setText(gameTextOutput);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void addPlayedGameBtnClicked(ActionEvent event) {

        // First validate all fields are not empty
        String playerId = playerIdCombo.getSelectionModel().getSelectedItem();
        String gameId = gameIdCombo.getSelectionModel().getSelectedItem();
        String datepicked = playingDate.getEditor().getText().trim();
        String score = scoreText.getText().trim();

        if ( playerId == null || gameId == null || datepicked.isBlank() || score.isBlank() ) {
            showErrorAlert("Player ID, Game ID, Date and Score cannot be empty");
        // Validate the score input is an integer number
        } else if (!(isNumber(score))) {
            showErrorAlert("Score must be an integer number");
        } else {
            // Perform the update or insert
            String playerGameId = playerId + gameId;
            String sql = "SELECT PLAYER_GAME_ID from SUN_HUNG_TSANG_PLAYER_AND_GAME where PLAYER_GAME_ID = '" + playerGameId + "'";

            try {
                ResultSet rset = stmt.executeQuery(sql);

                if (rset.next()) {
                    // if an existing record is found, update the record to show the latest playing info.
                    String psql = "UPDATE SUN_HUNG_TSANG_PLAYER_AND_GAME set GAME_ID = ?, PLAYER_ID = ?, PLAYING_DATE = TO_DATE(?,'DD/MM/YYYY'),SCORE = ? where PLAYER_GAME_ID = ?";
                    PreparedStatement pstmt = connection.prepareStatement(psql);
                    pstmt.setString(5, playerGameId);
                    pstmt.setString(1, gameId);
                    pstmt.setString(2, playerId);
                    pstmt.setString(3, datepicked);
                    pstmt.setInt(4, Integer.parseInt(score));
                    int recordsUpdated = pstmt.executeUpdate();

                    if (recordsUpdated > 0) {
                        System.out.println(recordsUpdated + " records updated");
                    }

                } else {
                    // if there is no existing record, then create a new record

//                    String psql = "INSERT INTO SUN_HUNG_TSANG_PLAYER_AND_GAME values (?,?,?,?,?)";
                    // Note the date is treated as text and needs to convert to "DATE" in Oracle using TO_DATE()
                    String psql = "INSERT INTO SUN_HUNG_TSANG_PLAYER_AND_GAME values (?,?,?,TO_DATE(?,'DD/MM/YYYY'),?)";
                    PreparedStatement pstmt = connection.prepareStatement(psql);
                    pstmt.setString(1, playerGameId);
                    pstmt.setString(2, gameId);
                    pstmt.setString(3, playerId);
                    pstmt.setString(4, datepicked);
                    pstmt.setInt(5, Integer.parseInt(score));
                    int recordsInserted = pstmt.executeUpdate();

                    if (recordsInserted > 0) {
                        System.out.println(recordsInserted + " records inserted");
                    }

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    protected void reportBtnClicked(ActionEvent event) {

        loadPlayerGameRecords();

    }

    // Method to check if the input is a valid integer
    private boolean isNumber(String text) {
        try {
            // Attempt to parse the string as an integer
            Integer.parseInt(text);
            return true; // If successful, it's a valid integer
        } catch (NumberFormatException e) {
            return false; // If an exception occurs, it's not a valid number
        }
    }

    private String incPrimaryKey(String text) {
        // To increase the primary key by one assuming the format is P001 or G001
        String prefix = text.substring(0, 1);
        String suffix = text.substring(1);

        Integer i = Integer.parseInt(suffix);
        return String.format("%s%03d", prefix, i+1);
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