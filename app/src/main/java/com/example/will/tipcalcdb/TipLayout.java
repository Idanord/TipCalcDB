package com.example.will.tipcalcdb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Will on 5/24/2018.
 */

public class TipLayout extends RelativeLayout implements View.OnClickListener {

    private TextView billDateTextView;
    private TextView billAmountTextVeiw;
    private TextView tipPercentTextVeiw;
    private Button deleteButton;

    private Context context;
    private TipDB db;
    private Tip tip;

    public TipLayout(Context context){
        super(context);
    }

    public TipLayout(Context context, Tip tip){
        super(context);
        //get db object
        db = new TipDB(context);

        //inflate the layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_tip, this, true);

        //ref to widgets
        billDateTextView = (TextView) findViewById(R.id.billDateTextView);
        billAmountTextVeiw = (TextView) findViewById(R.id.billAmountLabel);
        tipPercentTextVeiw = (TextView) findViewById(R.id.tipPercentLabel);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        
        deleteButton.setOnClickListener(this);
        
        //set task data on widget
        setTip(tip);
    }//end constructor

    @Override
    public void onClick(View v) {
        db.deleteTip(tip.getId());
        context.startActivity(new Intent(context, TipHistoryActivity.class));
    }//end onClick

    public void setTip(Tip tip) {
        this.tip = tip;

        billDateTextView.setText(tip.getDateStringFormatted());
        billAmountTextVeiw.setText(tip.getBillAmountFormatted());
        tipPercentTextVeiw.setText(tip.getTipPercentFormatted());
    }//end setTip
}
