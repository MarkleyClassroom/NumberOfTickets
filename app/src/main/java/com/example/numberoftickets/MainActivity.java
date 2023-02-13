package com.example.numberoftickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get all the views
        EditText tickets = (EditText) findViewById(R.id.txtTickets); //number of tickets
        Spinner group = (Spinner) findViewById(R.id.txtGroup); //the group
        Button cost = (Button) findViewById(R.id.btnCost); //click the button
        TextView result = (TextView) findViewById(R.id.txtResult);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked the button", Toast.LENGTH_SHORT).show();
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = numberOfTickets * costPerTicket;
                DecimalFormat df = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("cost for " + groupChoice + " is " + df.format(totalCost));
            }
        });
    }
}