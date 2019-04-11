package com.example.task1_abdelaty68472.Welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

import com.example.task1_abdelaty68472.EditEmployee.EditDepartment;
import com.example.task1_abdelaty68472.InsertEmployee.InsertEmployee;
import com.example.task1_abdelaty68472.R;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.view)
    Button viewButton;
    @BindView(R.id.insert)
    Button insertButton;
    @BindView(R.id.edit)
    Button editButton;
    Intent intent;
    String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";

    final File depFile = new File(path + "dep.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        insertButton.setOnClickListener(v -> {
            if (depFile.exists()) {
                intent = new Intent(this, InsertEmployee.class);
                startActivity(intent);
            }
            else {

                Toasty.warning(this,"Missing dep file");
            }
        });
//        viewButton.setOnClickListener(v -> {
//            intent = new Intent(this, ViewEmployees.class);
//            startActivity(intent);
//        });
        editButton.setOnClickListener(v -> {
            intent = new Intent(this, EditDepartment.class);
            startActivity(intent);
        });
    }
}
