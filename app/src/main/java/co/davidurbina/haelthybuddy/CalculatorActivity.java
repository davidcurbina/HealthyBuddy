package co.davidurbina.haelthybuddy;

/**
 * Created by davidurbina on 4/20/17.
 */


import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity implements OnClickListener {

    EditText ageInput;
    EditText heightInput;
    EditText weightInput;

    Button cutButton;
    Button maintButton;
    Button bulkButton;
    Button back;

    TextView displayValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        // Find elements from the layout and Define them
        ageInput = (EditText) findViewById(R.id.ageInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        weightInput = (EditText) findViewById(R.id.weightInput);

        back = (Button) findViewById(R.id.back);
        cutButton = (Button) findViewById(R.id.cutButton);
        maintButton = (Button) findViewById(R.id.maintButton);
        bulkButton = (Button) findViewById(R.id.bulkButton);

        displayValue = (TextView) findViewById(R.id.displayValue);

        //Set button listeners
        cutButton.setOnClickListener(this);
        maintButton.setOnClickListener(this);
        bulkButton.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int ageNum = 0;
        int weightNum = 0;
        int heightNum = 0;
        double result = 0;
        double calculate = 0;
        double percentAdd = 0;

        // Test to see if fields are empty
        if (TextUtils.isEmpty(ageInput.getText().toString())
                || TextUtils.isEmpty(heightInput.getText().toString())
                || TextUtils.isEmpty(weightInput.getText().toString())) {
            return;
        }

        // This is to read the Edit Text fields from the layout and fill the Variables with Numbers
        ageNum =  Integer.parseInt(ageInput.getText().toString());
        weightNum = Integer.parseInt(weightInput.getText().toString());
        heightNum = Integer.parseInt(heightInput.getText().toString());

        //Defines which button has been clicked and will calculate accordingly
        switch (v.getId()) {
            case R.id.cutButton:
                calculate = (10*weightNum) + (6.25*heightNum*2.54) - (5*ageNum) + 5;
                percentAdd =  (calculate*0.2);
                result = calculate - percentAdd;
                break;
            case R.id.maintButton:
                calculate = (10*weightNum) + (6.25*heightNum*2.54) - (5*ageNum) + 5;
                percentAdd =  (calculate*0);
                result = calculate + percentAdd;
                break;
            case R.id.bulkButton:
                calculate = (10*weightNum) + (6.25*heightNum*2.54) - (5*ageNum) + 5;
                percentAdd = (calculate*0.2);
                result = calculate + percentAdd;
                break;
            default:
                break;
        }

        //Displays the output
        double protein = weightNum * 0.825;
        double fat = result * 0.25 / 9;
        double carbohydrates = (result - (fat*9) - (protein*4))/4;
        displayValue.setText("Protein: " + String.valueOf((int)protein) + "g   Fat: " + String.valueOf((int)fat) +
                "g   Carbohydrates: " + String.valueOf((int)carbohydrates) + "g\nTotal Calories: " + String.valueOf((int)result));
    }
}
