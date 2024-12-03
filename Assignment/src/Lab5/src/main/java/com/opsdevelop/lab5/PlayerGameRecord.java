package com.opsdevelop.lab5;

import java.sql.Date;

// Player and Game records for TableView display
// Some fields from the 3 tables are included in the TableView
public class PlayerGameRecord {

    private final String playerId;
    private final String firstName;
    private final String lastName;
    private final String gameId;
    private final String gameTitle;
    private final Date playingDate;
    private final int score;

    public PlayerGameRecord(String playerId, String firstName, String lastName, String gameId, String gameTitle, Date playingDate, int score) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.playingDate = playingDate;
        this.score = score;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public Date getPlayingDate() {
        return playingDate;
    }

    public int getScore() {
        return score;
    }
}

