package com.example.milkdairy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button minus, plus;
    Button order;
    TextView liter, rupee;
    TextView showaddress, showname, price, num, showhd;
    CheckBox homeDelivery;


    EditText name, address;
    int result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        liter = findViewById(R.id.liter);
        rupee = findViewById(R.id.rupee);
        order = findViewById(R.id.order);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        showaddress = findViewById(R.id.showaddress);
        showname = findViewById(R.id.showname);
        price = findViewById(R.id.price);
        num = findViewById(R.id.num);
        homeDelivery = findViewById(R.id.homeDelivery);
        showhd = findViewById(R.id.showhd);


        result = Integer.parseInt(liter.getText().toString().trim());
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result += 1;
                liter.setText(String.valueOf(result));
                rupee.setText(String.valueOf(result * 70));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result > 1) {
                    result -= 1;
                    liter.setText(String.valueOf(result));
                    rupee.setText(String.valueOf(result * 70));

                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredName = name.getText().toString().trim();
                String enteredAddress = address.getText().toString().trim();


                showname.setText(enteredName);
                showaddress.setText(enteredAddress);
                name.setText("");
                address.setText("");
                num.setText(String.valueOf(result));
                price.setText(String.valueOf(result * 70));
                liter.setText("1");
                rupee.setText("70");
                if (homeDelivery.isChecked()) {
                    showhd.setText("Yes");
                } else {
                    showhd.setText("No");
                }
                homeDelivery.setChecked(false);

            }
        });

    }

}