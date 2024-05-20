package com.example.lab4;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText editTextUnits, editTextMobile;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUnits = findViewById(R.id.editTextUnits);
        editTextMobile = findViewById(R.id.editTextMobile);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int units = Integer.parseInt(editTextUnits.getText().toString());
                String mobile = editTextMobile.getText().toString();
                double billAmount = calculateBill(units);
                textViewResult.setText("Bill Amount: Rs. " + billAmount);
                sendSMS(mobile, "Your electricity bill amount is Rs. " +
                        billAmount);
            }
        });
    }
    private double calculateBill(int units) {
        double billAmount = 0.0;
        if (units <= 100) {
            billAmount = units * 2.50;
        } else if (units <= 200) {
            billAmount = 100 * 2.50 + (units - 100) * 3.00;
        } else if (units <= 300) {
            billAmount = 100 * 2.50 + 100 * 3.00 + (units - 200) * 3.50;} else if (units > 300) {
            billAmount = 100 * 2.50 + 100 * 3.00 + 100 * 3.50 + (units - 300) *
                    4.00;
        }
        return billAmount;
    }
    private void sendSMS(String mobile, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(mobile, null, message, null, null);
            Toast.makeText(this, "SMS sent to " + mobile,
                    Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "SMS failed to send",
                    Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }
}