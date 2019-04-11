package com.example.task1_abdelaty68472;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.task1_abdelaty68472.Welcome.WelcomeActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import butterknife.BindView;

public class FileHelper {

    private final String employeeFileName = "employee.txt";
    private final String depFileName = "dep.txt";
    @BindView(R.id.department_spinner)
    Spinner spinner;
    private WelcomeActivity welcomeActivity;
    private final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/example/task1_abdelaty68472/";
    private final static String TAG = FileHelper.class.getName();

    public String readEmployeeFile(Context context) {
        String line = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path + employeeFileName));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + System.getProperty("line.separator"));
            }
            fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return line;
    }

    public boolean saveToFile(String data) {
        try {
            new File(path).mkdir();
            File file = new File(path + employeeFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write((data + System.getProperty("line.separator")).getBytes());

            return true;
        } catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        } catch (IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return false;


    }

    public void readDepFile() throws IOException {
        Vector<String> str = new Vector<String>();
        BufferedReader in = new BufferedReader(new InputStreamReader(welcomeActivity.getAssets().open(depFileName)));

        String line = in.readLine();
        int index = 0;
        while (line != null) {

            str.add(line);
            line = in.readLine();
        }

        ArrayAdapter adapter = new ArrayAdapter(welcomeActivity.getApplicationContext(), android.R.layout.simple_spinner_item, str);

        spinner.setAdapter(adapter);
    }
}
