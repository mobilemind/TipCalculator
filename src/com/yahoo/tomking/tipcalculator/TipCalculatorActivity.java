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
    	// determine percentage based on btnId
    	double tipPercent = 0.10d;
    	if (v.getId() == R.id.btnTipMed) {
    		tipPercent = 0.15d;
    	}
    	else if (v.getId() == R.id.btnTipMax) {
    		tipPercent = 0.20d;
    	}
    	// get bill amount and reformat
    	String billString = etBillAmount.getText().toString();
    	double billValue = Double.parseDouble(billString);
    	etBillAmount.setText(df.format(billValue));
    	// calculate & reformat the tip & the total
    	double tipValue= billValue * tipPercent;
    	etTipAmount.setText(df.format(tipValue));
    	double totalValue = billValue + tipValue;
    	etTotalAmount.setText(df.format(totalValue));
    }
}
