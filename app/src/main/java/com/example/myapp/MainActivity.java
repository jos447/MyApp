package com.example.myapp;

/*import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText inputText1, inputText2;
    private Button addButton,ViewData;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        inputText1 = findViewById(R.id.inputText1);
        inputText2 = findViewById(R.id.inputText2);
        addButton = findViewById(R.id.addButton);
ViewData=findViewById(R.id.button);
        databaseReference = FirebaseDatabase.getInstance().getReference("data");
ViewData.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
});
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                addData();
            }
        });
    }

    private void addData() {
        String data1 = inputText1.getText().toString().trim();
        String data2 = inputText2.getText().toString().trim();

        if (!data1.isEmpty() && !data2.isEmpty()) {
            // Combine the two data fields into one string
            String combinedData = data1 + " - " + data2;  // Using " - " as a separator

            String key = databaseReference.push().getKey();  // Only one key needed

            databaseReference.child(key).setValue(combinedData)
                    .addOnSuccessListener(aVoid -> {
                        inputText1.setText("");
                        inputText2.setText("");
                        Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this, "Failed to add data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
            Toast.makeText(MainActivity.this, "Data added (offline mode)", Toast.LENGTH_SHORT).show();
            inputText1.setText("");
            inputText2.setText("");
        } else {
            Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show();
        }
    }}*/


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText inputText1, inputText2;
    private Button addButton, viewDataButton;
    private DatabaseReference databaseReference;

    // New Views for password input and verification
    private EditText passwordInput;
    private Button verifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        inputText1 = findViewById(R.id.inputText1);
        inputText2 = findViewById(R.id.inputText2);
        addButton = findViewById(R.id.addButton);
        viewDataButton = findViewById(R.id.button);
        databaseReference = FirebaseDatabase.getInstance().getReference("data");

        // Initialize new views
        passwordInput = findViewById(R.id.passwordInput);
        verifyButton = findViewById(R.id.verifyButton);

        // Initially hide password input and verify button
        passwordInput.setVisibility(View.GONE);
        verifyButton.setVisibility(View.GONE);

        // View Data button listener
        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordInput.setVisibility(View.VISIBLE);
                verifyButton.setVisibility(View.VISIBLE);
            }
        });

        // Verify button listener
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyPassword();
            }
        });

        // Add button listener
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private void verifyPassword() {

        String enteredPassword = passwordInput.getText().toString();
        if (enteredPassword.equals("your")) { // Replace with your actual password
            Toast.makeText(this, "Access Granted", Toast.LENGTH_SHORT).show();
            passwordInput.setText("");
            passwordInput.setVisibility(View.GONE);
            verifyButton.setVisibility(View.GONE);
            // Launch MainActivity2 to view the data
            String data1 = inputText1.getText().toString().trim();
            String data2 = inputText2.getText().toString().trim();
            String combinedData = data1 + " " + data2;
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("userInput", combinedData);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            passwordInput.setText("");
        }
    }

    //private void addData() {
        //String data1 = inputText1.getText().toString().trim();
       // String data2 = inputText2.getText().toString().trim();



           /* if (!data1.isEmpty() || !data2.isEmpty()) {
                // Combine both inputs into one sentence
                String combinedData = data1 + " " + data2;  // Adds a space between the two inputs

                String key = databaseReference.push().getKey(); // Use a single key for the combined data

                databaseReference.child(key).setValue(combinedData)
                        .addOnSuccessListener(aVoid -> {
                            inputText1.setText("");
                            inputText2.setText("");  // Clear both inputs
                            Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(MainActivity.this, "Failed to add Data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
            } else {
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_SHORT).show();
            }
        }}
*/
        private void addData() {
            String data1 = inputText1.getText().toString().trim();
            String data2 = inputText2.getText().toString().trim();



            if (!data1.isEmpty() || !data2.isEmpty()) {
                // Combine both inputs into one sentence
                String combinedData = data1 + " " + data2;  // Adds a space between the two inputs

                String key = databaseReference.push().getKey(); // Use a single key for the combined data

                databaseReference.child(key).setValue(combinedData)
                        .addOnSuccessListener(aVoid -> {
                            inputText1.setText("");
                            inputText2.setText("");  // Clear both inputs
                            Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                        })

                        .addOnFailureListener(e -> {
                            Toast.makeText(MainActivity.this, "Failed to add Data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                Toast.makeText(MainActivity.this, "Data added (offline mode)", Toast.LENGTH_SHORT).show();
                inputText1.setText("");
                inputText2.setText("");
            } else {
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_SHORT).show();
            }
        }}
