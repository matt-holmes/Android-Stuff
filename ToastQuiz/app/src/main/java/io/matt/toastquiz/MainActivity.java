package io.matt.toastquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitHandler(View view) {
        EditText nameFieldText = (EditText) findViewById(R.id.nameInput);
        Toast.makeText(MainActivity.this, "Hello " + nameFieldText.getText().toString() + "!", Toast.LENGTH_SHORT).show();
        Log.i("click", nameFieldText.getText().toString());
    }
}
