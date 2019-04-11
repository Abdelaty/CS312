//package com.example.task1_abdelaty68472.ViewEmployee;
//
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.task1_abdelaty68472.R;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ViewEmployees extends AppCompatActivity {
//
//    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
//    TextView outputID, outputName, outputGPA, outputGender, outputCollege;
//    Button nextButton, backButton;
//    int index = 0;
//    ArrayList<String> studentData = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_employees);
//        readFromFile(path + "students.txt");
//        outputID = (TextView) findViewById(R.id.outputID);
//        outputName = (TextView) findViewById(R.id.outputName);
//        outputGPA = (TextView) findViewById(R.id.outputGPA);
//        outputGender = (TextView) findViewById(R.id.outputGender);
//        outputCollege = (TextView) findViewById(R.id.outputCollege);
//        nextButton = (Button) findViewById(R.id.nextButton);
//        backButton = (Button) findViewById(R.id.backButton);
//        showStudent();
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (index + 1 < studentData.size()) {
//                    index++;
//                    showStudent();
//                }
//
//            }
//        });
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (index - 1 >= 0) {
//                    index--;
//                    showStudent();
//                }
//
//
//            }
//        });
//    }
//
//    private void readFromFile(String fileName) {
//        try {
//            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = "";
//            while ((line = bufferedReader.readLine()) != null) {
//                studentData.add(line);
//            }
//            fileInputStream.close();
//            bufferedReader.close();
//        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private void showStudent() {
//        String student = studentData.get(index);
//        String[] studentFeilds = student.split("\\$");
//        outputID.setText(studentFeilds[0]);
//        outputName.setText(studentFeilds[1]);
//        outputGPA.setText(studentFeilds[2]);
//        outputCollege.setText(studentFeilds[3]);
//        outputGender.setText(studentFeilds[4]);
//    }
//}
//}
