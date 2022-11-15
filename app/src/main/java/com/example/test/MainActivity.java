package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
//life
public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private RadioGroup rdGroup;
    private Switch swLastYear;
    private TextView txtResult;
    private Spinner spnDeps;
    //just one at the first of the run
    //call back event when the activite works for the first time (when the activity being loaded , make the views ready load the data--(work behained)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();//to let the run time see the xml file
    }

    //controls the views in the run time
    private void setUpViews() {
        edtName = findViewById(R.id.edtName);
        rdGroup =findViewById(R.id.rdGroup);
        swLastYear= findViewById(R.id.swLastYear);
        txtResult = findViewById(R.id.txtResult);
        spnDeps =findViewById(R.id.spnDeps);
    }

    public void btnSave_Click(View view) {
        String msg = "";
        String name = edtName.getText().toString();
        if(!name.isEmpty()){
            msg = name;
        }
        msg =edtName.getText().toString();
        int id = rdGroup.getCheckedRadioButtonId();
        if(id != -1) {
            RadioButton rd = findViewById(id);
            msg+="," + rd.getText().toString();
        }
        if(swLastYear.isChecked()){
            msg+=",\n" + swLastYear.getText().toString();
        }
        msg+=", \n" + spnDeps.getSelectedItem().toString();
        txtResult.setText(msg);

    }
}