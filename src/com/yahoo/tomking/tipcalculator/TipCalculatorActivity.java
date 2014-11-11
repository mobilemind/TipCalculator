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
        // "@+id/etBillAmount", "@+id/etTipAmount" , "@+id/etTotalAmount"
        setContentView(R.layout.activity_tip_calculator);
        etBillAmount = (EditText) findViewById(R.id.etBillAmount);
        etTipAmount = (EditText) findViewById(R.id.etTipAmount);
        etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
    }
    
    /** Called when the user touches a button */
    public void tipBtnMinClicked(View v) {
    	// get bill amount and initialize doubles
    	String billString = etBillAmount.getText().toString();
    	double tipValue = Double.parseDouble(billString);
    	double totalValue = tipValue;
    	// reformat billAmount to 0.00 format
    	billString = df.format(tipValue);
    	// calculate tip value & total amounts
    	tipValue= tipValue * 0.1d ;
    	totalValue = totalValue + tipValue ;
    	String tipString = df.format(tipValue);
    	String totalString = df.format(totalValue);   	
    	// slam results into fields
    	etBillAmount.setText(billString.toCharArray(), 0, billString.length());
    	etTipAmount.setText(tipString.toCharArray(), 0, tipString.length());
    	etTotalAmount.setText(totalString.toCharArray(), 0, totalString.length());
    }
    public void tipBtnMedClicked(View v) {
     	String billString = etBillAmount.getText().toString();
    	double tipValue = Double.parseDouble(billString);
    	double totalValue = tipValue;
     	billString = df.format(tipValue);    	// calculate tip value & total amounts
    	tipValue= tipValue * 0.15d ;
    	totalValue = totalValue + tipValue ;
    	String tipString = df.format(tipValue);
    	String totalString = df.format(totalValue);   	    	// slam results into fields
    	etBillAmount.setText(billString.toCharArray(), 0, billString.length());
    	etTipAmount.setText(tipString.toCharArray(), 0, tipString.length());
    	etTotalAmount.setText(totalString.toCharArray(), 0, totalString.length());
    }
    public void tipBtnMaxClicked(View v) {
    	String billString = etBillAmount.getText().toString();
    	double tipValue = Double.parseDouble(billString);
    	double totalValue = tipValue;    	// reformat billAmount to 0.00 format
    	billString = df.format(tipValue);
     	tipValue= tipValue * 0.2d ;
    	totalValue = totalValue + tipValue ;
    	String tipString = df.format(tipValue);
    	String totalString = df.format(totalValue);   	
     	etBillAmount.setText(billString.toCharArray(), 0, billString.length());
    	etTipAmount.setText(tipString.toCharArray(), 0, tipString.length());
    	etTotalAmount.setText(totalString.toCharArray(), 0, totalString.length());
    }
}
