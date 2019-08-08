package com.example.celebritylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView tvSharedPrefDisplay;
    EditText etUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("mySharedPref", MODE_PRIVATE);
        tvSharedPrefDisplay = findViewById(R.id.tvSharedPrefDisplay);

        etUserInput = findViewById(R.id.etUserInput);
        displayValueInSharedPref();

    }

    private void storeToSharedPreferences(String valueToStore){

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", valueToStore);

        editor.apply();
    }

    private void displayValueInSharedPref(){

        final String valueInPref = sharedPreferences.getString("key", "No value stored");
        tvSharedPrefDisplay.setText(valueInPref);
    }

    public void onClick(View view){

        switch (view.getId()){

            case R.id.btnStoreValueToPref:
                final String userInput = etUserInput.getText().toString();
                if(!userInput.isEmpty()){

                    Toast.makeText(this, "No value entered", Toast.LENGTH_SHORT).show();

                }
                break;

            case R.id.btnInsertCelebrity:
                startActivity(new Intent(this, InsertActivity.class));
                break;
            case R.id.btnViewAllCelebrities:
                startActivity(new Intent(this, ListAllActivities.class));
                break;


        }
    }

}
