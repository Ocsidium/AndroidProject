package com.example.foodbuddy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodbuddy.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView itemName;
    private TextView quantity;
    private TextView dateAdded;
    private int groceryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        itemName = (TextView) findViewById(R.id.itemNameDetails);
        quantity = (TextView) findViewById(R.id.itemQtyDetails);
        dateAdded = (TextView) findViewById(R.id.dateAddedDetails);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            itemName.setText(bundle.getString("name"));
            quantity.setText(bundle.getString("quantity"));
            dateAdded.setText(bundle.getString("date"));
            groceryId = bundle.getInt("id");
        }
    }
}
