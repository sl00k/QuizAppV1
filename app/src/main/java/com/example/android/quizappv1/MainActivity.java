package com.example.android.quizappv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int scoreSummary;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup4;
    RadioGroup radioGroup6;
    RadioGroup radioGroup7;
    RadioGroup radioGroup8;
    RadioGroup radioGroup9;
    EditText text;
    int score = 1;
    // int variables
    private CheckBox checkBoxGold;
    private CheckBox checkBoxIron;
    private CheckBox checkBoxSteel;
    private CheckBox checkBoxCopper;
    private int numberOfQuestions = 9;
    // int correct answers
    private int answer1 = 2;
    private int answer2 = 0;
    private int answer4 = 0;
    private int answer6 = 2;
    private int answer7 = 3;
    private int answer8 = 0;
    private int answer9 = 0;
    private EditText question5_input;
    private boolean hasRated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find views for the variables
        checkBoxGold = (CheckBox) findViewById(R.id.checkbox_gold);
        checkBoxIron = (CheckBox) findViewById(R.id.checkbox_iron);
        checkBoxSteel = (CheckBox) findViewById(R.id.checkbox_steel);
        checkBoxCopper = (CheckBox) findViewById(R.id.checkbox_copper);
        radioGroup1 = (RadioGroup) findViewById(R.id.radio_question_1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radio_question_2);
        radioGroup4 = (RadioGroup) findViewById(R.id.radio_question_4);
        radioGroup6 = (RadioGroup) findViewById(R.id.radio_question_6);
        radioGroup7 = (RadioGroup) findViewById(R.id.radio_question_7);
        radioGroup8 = (RadioGroup) findViewById(R.id.radio_question_8);
        radioGroup9 = (RadioGroup) findViewById(R.id.radio_question_9);
        question5_input = (EditText) findViewById(R.id.question5_input);
    }

    public void getScore(View view) {
        if (hasRated == false) {
            // Question 1
            // find which radio button is selected
            int checkedId = radioGroup1.getCheckedRadioButtonId();
            View selected = radioGroup1.findViewById(checkedId);
            int selectedAnswer = radioGroup1.indexOfChild(selected);
            if (selectedAnswer == answer1) {
                scoreSummary += score;
                disableBtn(radioGroup1);
            } else disableBtn(radioGroup1);
            // Question 2
            // find which radio button is selected
            checkedId = radioGroup2.getCheckedRadioButtonId();
            selected = radioGroup2.findViewById(checkedId);
            selectedAnswer = radioGroup2.indexOfChild(selected);
            if (selectedAnswer == answer2) {
                scoreSummary += score;
                disableBtn(radioGroup2);
            } else disableBtn(radioGroup2);
            // Question 3
            if (checkBoxGold.isChecked() && checkBoxIron.isChecked() && checkBoxCopper.isChecked() && !checkBoxSteel.isChecked()) {
                scoreSummary += score;
                checkBoxSteel.setEnabled(false);
                checkBoxGold.setEnabled(false);
                checkBoxIron.setEnabled(false);
                checkBoxCopper.setEnabled(false);
            } else {
                checkBoxSteel.setEnabled(false);
                checkBoxGold.setEnabled(false);
                checkBoxIron.setEnabled(false);
                checkBoxCopper.setEnabled(false);
            }
            // Question 4
            // find which radio button is selected
            checkedId = radioGroup4.getCheckedRadioButtonId();
            selected = radioGroup4.findViewById(checkedId);
            selectedAnswer = radioGroup4.indexOfChild(selected);
            if (selectedAnswer == answer4) {
                scoreSummary += score;
                disableBtn(radioGroup4);
            } else disableBtn(radioGroup4);
            // Question 5
            // Compare Input string with correct answer
            EditText text = (EditText) findViewById(R.id.question5_input);
            String question5Input = text.getText().toString();
            question5Input = question5Input.trim();
            String correctAnswer5 = getResources().getString(R.string.question_5a);
            if (question5Input.equalsIgnoreCase(correctAnswer5)) {
                scoreSummary += score;
                question5_input.setEnabled(false);
            } else question5_input.setEnabled(false);
            // Question 6
            // find which radio button is selected
            checkedId = radioGroup6.getCheckedRadioButtonId();
            selected = radioGroup6.findViewById(checkedId);
            selectedAnswer = radioGroup6.indexOfChild(selected);
            if (selectedAnswer == answer6) {
                scoreSummary += score;
                disableBtn(radioGroup6);
            } else disableBtn(radioGroup6);
            // Question 7
            // find which radio button is selected
            checkedId = radioGroup7.getCheckedRadioButtonId();
            selected = radioGroup7.findViewById(checkedId);
            selectedAnswer = radioGroup7.indexOfChild(selected);
            if (selectedAnswer == answer7) {
                scoreSummary += score;
                disableBtn(radioGroup7);
            } else disableBtn(radioGroup7);
            // Question 8
            // find which radio button is selected
            checkedId = radioGroup8.getCheckedRadioButtonId();
            selected = radioGroup8.findViewById(checkedId);
            selectedAnswer = radioGroup8.indexOfChild(selected);
            if (selectedAnswer == answer8) {
                scoreSummary += score;
                disableBtn(radioGroup8);
            } else disableBtn(radioGroup8);
            // Question 9
            // find which radio button is selected
            checkedId = radioGroup9.getCheckedRadioButtonId();
            selected = radioGroup9.findViewById(checkedId);
            selectedAnswer = radioGroup9.indexOfChild(selected);
            if (selectedAnswer == answer9) {
                scoreSummary += score;
                disableBtn(radioGroup9);
            } else disableBtn(radioGroup9);
            // Call function to display the score
            hasRated = !hasRated;
            clicked(scoreSummary);
        } else {
            Toast toast = Toast.makeText(this, "You Have To Reset First", Toast.LENGTH_SHORT);
            toast.show();
            Toast toast2 = Toast.makeText(this, "Your score was", Toast.LENGTH_SHORT);
            toast2.show();
            clicked(scoreSummary);
        }
    }

    // Function to disable Btn
    private void disableBtn(RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }
    }

    // Function to activate Btn
    private void activateOnReset(RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(true);
            radioGroup.clearCheck();
        }
    }

    // Function to show the score
    private void clicked(int scoreSummary) {
        float scoreSummaryFloat = scoreSummary;
        float scorePercent = (scoreSummaryFloat / numberOfQuestions) * 100;
        Toast toast = Toast.makeText(this, "" + scoreSummary + " Point(s) or " + scorePercent + "%", Toast.LENGTH_LONG);
        toast.show();

    }

    // Function to reset the app
    public void reset(View view) {
        checkBoxSteel.setEnabled(true);
        checkBoxGold.setEnabled(true);
        checkBoxIron.setEnabled(true);
        checkBoxCopper.setEnabled(true);
        checkBoxSteel.setChecked(false);
        checkBoxGold.setChecked(false);
        checkBoxIron.setChecked(false);
        checkBoxCopper.setChecked(false);
        activateOnReset(radioGroup1);
        activateOnReset(radioGroup2);
        activateOnReset(radioGroup4);
        activateOnReset(radioGroup6);
        activateOnReset(radioGroup7);
        activateOnReset(radioGroup8);
        activateOnReset(radioGroup9);
        scoreSummary = 0;
        question5_input.setEnabled(true);
        question5_input.setText("");
        hasRated = !hasRated;
        Toast toast = Toast.makeText(this, "Progress is reset", Toast.LENGTH_LONG);
        toast.show();
    }
}
