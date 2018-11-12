package fall2018.csc2017.GameCentre.Data;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {

    private String username;
    private String password;
    private String nickname;
    private HashMap<String, Integer> score;
    private byte[] avatar;

    /**
     * Construct a User object when signed up
     * Initialized with a username, a password and an empty hashmap which records all game the
     * user has played and the highest score the user got in that game.
     * <p>
     * nickname is initialized to be the same as username in case nickname is not entered.
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.nickname = username;
        this.username = username;
        this.password = password;
        this.score = new HashMap<String, Integer>();
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    /**
     * set nickname
     * In the sign up UI, if the input of nickname is not empty, nickname should be set to be
     * the input after user object is constructed using setNickname()
     *
     * @param name
     */
    public void setNickname(String name) {
        this.nickname = name;
    }

    /**
     * @return nickname of user
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * @return username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set Username, but shouldn't be used, just in case.
     * username should not be changed
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set password, when password needs to be changed.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * check if the entered password is correct and return either true or false
     *
     * @param password
     * @return
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Update score taking gameType and score as input.
     * update score only when the input score is higher than current highest score.
     *
     * @param gameType
     * @param score
     * @return true if update succeeds, false if not updated (input score < current score)
     */
    public boolean updateScore(String gameType, Integer score) {
        if (this.score.containsKey(gameType)) {
            if (this.score.get(gameType) < score) {
                this.score.put(gameType, score);
                return true;
            }
        } else {
            this.score.put(gameType, score);
        }
        return false;
    }

    /**
     * @param game
     * @return the file name where the game state of the user of a specific game is stored
     */
    public String getFile(String game) {
        if (this.score.containsKey(game)) {
            return this.username + "_" + game + "_state.ser";
        } else {
            return "DNE";
        }
    }

    /**
     * -1 is returned if the user has never played the game but the method is called
     * Theoretically this shouldn't happen because game is added to hashmap at the beginning
     * of each game if it's the first time playing
     *
     * @param game
     * @return score the user got in a specific game
     */
    public int getScore(String game) {
        if (this.score.containsKey(game)) {
            return this.score.get(game);
        } else {
            return -1;
        }
    }


}
