package sg.edu.rp.c346.id20027025.demosimpleclick;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonDisplay;
    TextView tvDisplay;
    EditText etInput;
    ToggleButton tbtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDisplay = findViewById(R.id.buttonDisplay);
        tvDisplay = findViewById(R.id.textViewDisplay);
        etInput = findViewById(R.id.editTextInput);
        tbtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.radioGroupGender);

        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = etInput.getText().toString();
                if (i.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered.");
                    Toast.makeText(MainActivity.this,
                            "Please input something",
                            Toast.LENGTH_SHORT).show();

                } else {
                    tvDisplay.setText(i);
                }
            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your code for the action
                if (tbtn.isChecked()) {
                    etInput.setEnabled(true);
                } else {
                    etInput.setEnabled(false);
                }
            }
        });

        tvDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etInput.getText().toString();
                if (stringResponse.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered.");
                    Toast.makeText(MainActivity.this,
                            "Please input something",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int checkedRadioId = rgGender.getCheckedRadioButtonId();
                    if (checkedRadioId == R.id.radioButtonGenderMale) {
                        tvDisplay.setText("He said " + etInput);
                    } else {
                        tvDisplay.setText("She said " + etInput);
                    }
                }
            }
        });
    }

}

