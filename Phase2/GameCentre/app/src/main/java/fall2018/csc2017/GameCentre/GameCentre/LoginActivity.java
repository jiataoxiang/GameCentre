package fall2018.csc2017.GameCentre.GameCentre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fall2018.csc2017.GameCentre.Data.DatabaseHandler;
import fall2018.csc2017.GameCentre.Data.User;
import fall2018.csc2017.GameCentre.R;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEntered;
    private EditText passwordEntered;
    private DatabaseHandler db;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHandler(this);
        // Make sure admin is always a user in database
        if (!db.userExists("admin")){
            user = new User("admin", "admin");
            db.addUser(user);
            saveToFile(db.getUserFile("admin"));

        }
        usernameEntered = findViewById(R.id.userName);
        passwordEntered = findViewById(R.id.Password);
        addSignInListener();
        addSignUpListener();
    }

    /**
     * set up sign in button
     * check password when clicked
     */
    private void addSignInListener() {
        Button signIn = findViewById(R.id.SignInButton);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEntered.getText().toString();
                String password = passwordEntered.getText().toString();
                if (!db.userExists(username)) {
                    Toast.makeText(LoginActivity.this, "Username Does Not Exist", Toast.LENGTH_SHORT).show();
                }else{
                    String userFile = db.getUserFile(username);
                    loadFromFile(userFile);
                    if (user.checkPassword(password)){
                        Intent intent = new Intent(getApplication(), GameCentreInterfaceActivity.class);
                        intent.putExtra("user", username);
                        startActivity(intent);

                    }else{
                        Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        usernameEntered.setText("");
                        passwordEntered.setText("");
                    }
                }
            }
        });
    }

    /**
     * Navigate to sign up page (activity)
     */
    private void addSignUpListener() {
        Button signUp = findViewById(R.id.SignUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }


    /**
     *load fileName to user
     * @param fileName
     */
    private void loadFromFile(String fileName) {

        try {
            InputStream inputStream = this.openFileInput(fileName);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                user = (User) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected data type: " + e.toString());
        }
    }

    /**
     * save user to filename
     * @param fileName
     */
    private void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(user);
            outputStream.close();
            Log.d("Save", "saveToFile: user saved");
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}






















