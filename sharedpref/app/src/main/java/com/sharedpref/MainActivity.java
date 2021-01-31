package com.sharedpref;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends Activity {


    private static final String NAME = "mysharedpref";
    private static final String KEY_NAME = "keyname";

    EditText NAMES;
    TextView RESULT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        NAMES = findViewById(R.id.name);
        RESULT = findViewById(R.id.result);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					saveName();
					displayName();
				}
			});
    }

    private void saveName() {
        String name = NAMES.getText().toString();

        if (name.isEmpty()) {
            NAMES.setError("Name required");
            NAMES.requestFocus();
            return;
        }
			

        SharedPreferences username = getSharedPreferences(NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = username.edit();

        editor.putString(KEY_NAME, name);
        editor.apply();
        NAMES.setText("");
		Toast.makeText(getApplicationContext(), "Insert Successfully", Toast.LENGTH_SHORT).show();    
		}

    private void displayName() {
        SharedPreferences username = getSharedPreferences(NAME, MODE_PRIVATE);
        String name = username.getString(KEY_NAME, null);

        if (name != null) {
            RESULT.setText(name);
        }
    }

}
