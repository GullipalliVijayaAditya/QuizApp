package com.example.android.quizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private String userNameForDisplaying;
    private int amountOfCorrectAnswers = 0;
    private boolean submitted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Here is loaded user name which is getting from MainActivity screen and saving into String variable
        userNameForDisplaying = getIntent().getStringExtra("USER_NAME");

        /**
         * This method supports the SUBMIT button
         */
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuizAndShowResult();
                submitted = true;
            }
        });
    }

    /**
     * This method checks all the answers of the quiz and show Toast message with amounts of achieved points
     */
    public void checkQuizAndShowResult() {

        if (!submitted) {
            if (this.checkQuestionOne()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionTwo()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionThree()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionFour()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionFive()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionSix()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionSeven()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionEight()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionNine()) {
                amountOfCorrectAnswers++;
            }
            if (this.checkQuestionTen()) {
                amountOfCorrectAnswers++;
            }
            this.showToastResult(amountOfCorrectAnswers);
        } else {
            this.showToastResult(amountOfCorrectAnswers);
        }
    }


    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionOne() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q1_rb_2);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return correctAnswer.isChecked();
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionTwo() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q2_checkbox_2);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q2_checkbox_4);
        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));
        return (!((CheckBox) findViewById(R.id.q2_checkbox_1)).isChecked() && correctAnswer1.isChecked() && !((CheckBox) findViewById(R.id.q2_checkbox_3)).isChecked() && correctAnswer2.isChecked());
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionThree() {
        EditText answer = ((EditText) findViewById(R.id.q3_editTextField));

        String answerValue = answer.getText().toString().toLowerCase();
        if (answerValue.equals("scrollview")) {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.startButtonColor), PorterDuff.Mode.SRC_ATOP);
        } else {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.wrongAnswerColor), PorterDuff.Mode.SRC_ATOP);
        }
        return answerValue.contains("scrollview");
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect.
     */
    public boolean checkQuestionFour() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q4_checkbox_1);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q4_checkbox_2);

        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));


        return (((CheckBox) findViewById(R.id.q4_checkbox_1)).isChecked() && ((CheckBox) findViewById(R.id.q4_checkbox_2)).isChecked() && !((CheckBox) findViewById(R.id.q4_checkbox_3)).isChecked() && !((CheckBox) findViewById(R.id.q4_checkbox_4)).isChecked());
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionFive() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q5_rb_2);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return ((RadioButton) findViewById(R.id.q5_rb_2)).isChecked();
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionSix() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q6_rb_3);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return correctAnswer.isChecked();
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionSeven() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q7_checkbox_2);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q7_checkbox_3);
        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));
        return (!((CheckBox) findViewById(R.id.q7_checkbox_2)).isChecked() && correctAnswer2.isChecked() && !((CheckBox) findViewById(R.id.q7_checkbox_3)).isChecked() && correctAnswer1.isChecked());
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionEight() {
        EditText answer = ((EditText) findViewById(R.id.q8_editTextField));

        String answerValue = answer.getText().toString().toLowerCase();
        if (answerValue.equals("inflate()")) {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.startButtonColor), PorterDuff.Mode.SRC_ATOP);
        } else {
            answer.getBackground().setColorFilter(getResources().getColor(R.color.wrongAnswerColor), PorterDuff.Mode.SRC_ATOP);
        }
        return answerValue.contains("inflate()");
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect.
     */
    public boolean checkQuestionNine() {
        CheckBox correctAnswer1 = (CheckBox) findViewById(R.id.q9_checkbox_1);
        CheckBox correctAnswer2 = (CheckBox) findViewById(R.id.q9_checkbox_3);
        correctAnswer1.setTextColor(Color.parseColor("green"));
        correctAnswer2.setTextColor(Color.parseColor("green"));
        return (!((CheckBox) findViewById(R.id.q9_checkbox_1)).isChecked() && correctAnswer2.isChecked() && !((CheckBox) findViewById(R.id.q9_checkbox_3)).isChecked() && correctAnswer1.isChecked());
    }

    /**
     * Checks if answer is correct, highlight correct answer
     *
     * @return true for correct answer, false for incorrect
     */
    public boolean checkQuestionTen() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.q10_rb_4);
        correctAnswer.setTextColor(Color.parseColor("green"));
        return ((RadioButton) findViewById(R.id.q10_rb_4)).isChecked();
    }

    /**
     * Displays the TOAST with final message
     *
     * @param amountOfCorrectAnswers the number of correct answers
     */
    public void showToastResult(int amountOfCorrectAnswers) {

        String specialMessage = "";

        if (amountOfCorrectAnswers == 10) {
            specialMessage = "Congratulations!";
        } else if (amountOfCorrectAnswers == 0) {
            specialMessage = "All Answers are Wrong! Try Again";
        } else if (amountOfCorrectAnswers < 10) {
            specialMessage = "Your score can be better! Next time";
        }

        // This method shows Toast message with amount of achieved points and an extra message
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.customtoast_two, (ViewGroup) findViewById(R.id.toast_layout_root_two));

        ImageView image = (ImageView) layout.findViewById(R.id.custom_toast_image_two);
        image.setImageResource(R.drawable.logoquiz);
        TextView text = (TextView) layout.findViewById(R.id.custom_toast_message_two);
        text.setText("Hii " + userNameForDisplaying + ", you got " + amountOfCorrectAnswers + "/10! " + specialMessage);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.warning).setTitle("Exit Quiz").setMessage("You will loose all the Answers. Did you want to exit?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent BackpressedIntent = new Intent();
                BackpressedIntent.setClass(getApplicationContext(), MainActivity.class);
                BackpressedIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(BackpressedIntent);
                finish();
            }
        }).setNegativeButton("No", null).show();
    }
}