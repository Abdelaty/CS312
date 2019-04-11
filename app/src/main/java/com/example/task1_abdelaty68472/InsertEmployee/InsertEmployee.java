package com.example.task1_abdelaty68472.InsertEmployee;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.task1_abdelaty68472.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InsertEmployee extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.department_spinner)
    Spinner spinner;

    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
    @BindView(R.id.employee_name_input)
    EditText inputUser;

    @BindView(R.id.employee_password_input)
    EditText inputPass;

    @BindView(R.id.employee_confirm_input)
    EditText inputPassConfirm;

    @BindView(R.id.employee_id_input)
    EditText inputId;

    @BindView(R.id.male_check)
    RadioButton radioMale;

    @BindView(R.id.female_check)
    RadioButton radioFemale;

    @BindView(R.id.insert_button)
    Button insertButton;

    ArrayList<String> departments = new ArrayList<>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_employee);
        ButterKnife.bind(this);
//        Log.v("name", Environment.getExternalStorageDirectory().getAbsolutePath());
        readFromFile(path + "dep.txt");
        adapter = new ArrayAdapter(getApplicationContext(), R.layout.row_layout, departments);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.v("hello", path);

//        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        insertButton.setOnClickListener(view -> {

            String gender = "";
            if (radioMale.isChecked())
                gender = "Male";
            else if (radioFemale.isChecked())
                gender = "Female";
            else {
                Toast.makeText(getApplicationContext(), "select the gender", Toast.LENGTH_LONG).show();
                return;
            }

            String studentText = inputId.getText().toString() + "$" + inputPass.getText().toString() + "$" + inputPassConfirm.getText().toString() + "$" + inputUser.getText().toString() +
                    "$" + spinner.getSelectedItem().toString() + "$" + gender;
            appendFile(path + "students.txt", studentText);
            Toast.makeText(getApplicationContext(), "Student Inserted", Toast.LENGTH_LONG).show();
        });
        ;
    }

    private void readFromFile(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                departments.add(line);
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void appendFile(String fileName, String content) {
        File file = new File(fileName);
        try {
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write((content + System.getProperty("line.separator")).getBytes());
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
