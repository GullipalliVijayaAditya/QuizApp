package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String userName;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom font TypeFace for welcome slogan
        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/android_7.ttf");
        welcomeTextView.setTypeface(custom_font);

        // User Name - edit text field
        EditText nameEditTextView = (EditText) findViewById(R.id.nameEditText);
        userName = nameEditTextView.getText().toString();

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = ((EditText) findViewById(R.id.nameEditText)).getText().toString();

                if (!userName.isEmpty()) {


                    Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
                    myIntent.putExtra("USER_NAME", userName);
                    startActivity(myIntent);
                    startActivityForResult(myIntent, 0);
                } else {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.customtoast_one, (ViewGroup) findViewById(R.id.toast_layout_root_one));
                    ImageView image = (ImageView) layout.findViewById(R.id.custom_toast_image_one);
                    image.setImageResource(R.drawable.error);
                    TextView text = (TextView) layout.findViewById(R.id.custom_toast_message_one);
                    text.setText("Please Enter your Name");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit QuizApp", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}