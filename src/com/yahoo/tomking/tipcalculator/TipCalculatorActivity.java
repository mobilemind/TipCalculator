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
    public void tipBtnClicked(View v) {
    	// determine percentage based on btnId
    	double tipPercent = 0.10d;
    	switch (v.getId()) {
		case R.id.btnTipMax:
			tipPercent = 0.20d;
			break;
		case R.id.btnTipMed:
			tipPercent = 0.15d;
			break;
		case R.id.btnTipMin:
			tipPercent = 0.10d;
			break;
		default:
			tipPercent = 0.10d;
			break;
		}
    	// get bill amount and refromat
    	String billString = etBillAmount.getText().toString();
    	double billValue = Double.parseDouble(billString);
    	billString = df.format(billValue);
    	// calculate tip & total, then format
    	double tipValue= billValue * tipPercent ;
    	double totalValue = billValue + tipValue ;
    	String tipString = df.format(tipValue);
    	String totalString = df.format(totalValue);   	
    	// slam results into fields
    	etBillAmount.setText(billString.toCharArray(), 0, billString.length());
    	etTipAmount.setText(tipString.toCharArray(), 0, tipString.length());
    	etTotalAmount.setText(totalString.toCharArray(), 0, totalString.length());
    }
}
