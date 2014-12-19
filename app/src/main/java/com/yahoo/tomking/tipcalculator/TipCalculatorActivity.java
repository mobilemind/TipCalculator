package com.yahoo.tomking.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class TipCalculatorActivity extends Activity {
	
	private EditText etBillAmount;
	private EditText etTipAmount;
	private EditText etTotalAmount;
	private DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        etTipAmount = (EditText) findViewById(R.id.etTipAmount);
        etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
    }
    
    /** Called when the user touches a button */
    public void tipBtnClicked(View v) {
    	// determine percentage based on android:tag value of Button view
    	double tipPercent = Double.parseDouble(v.getTag().toString());
    	// get bill amount and reformat
    	double billValue = Double.parseDouble(etBillAmount.getText().toString());
    	etBillAmount.setText(df.format(billValue));
    	// calculate & reformat the tip & the total
    	double tipValue = billValue * tipPercent;
    	etTipAmount.setText(df.format(tipValue));
    	double totalValue = billValue + tipValue;
    	etTotalAmount.setText(df.format(totalValue));
    }
}
