package com.alghubari.afaq;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout mNameTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // TextInputEditText tab1=(TextInputEditText)findViewById(R.id.te);
       // tab1.setHint("customername");

       // TextInputLayout tname=(TextInputLayout)findViewById(R.id.textlayout_name);
final Spinner sp1,sp2;
        final EditText editname,editphone,editadresscount,editValuPay ,editValuRecive,editValuRemind,addressLenght
       , shoulderLenght,armLenght;
ArrayList<String>nicklist=new ArrayList<>();
        ArrayList<String>cabacklist=new ArrayList<>();


        //name of customer
        editname=(EditText)findViewById(R.id.edittext_name);
        //phone number of customer
        editphone=(EditText)findViewById(R.id.editext_phone);
        //the number of address for custommer
        editadresscount=(EditText)findViewById(R.id.editext_adress_count);
        //the address price
        editValuPay=(EditText)findViewById(R.id.edittext_address_price);
        //the value wich the customer pay
        editValuRecive=(EditText)findViewById(R.id.editext_value_pay);
        //the value wich remind
        editValuRemind=(EditText)findViewById(R.id.editext_remained_value);

        sp1=(Spinner)findViewById(R.id.spinner_nick) ;

        sp2=(Spinner)findViewById(R.id.spinner_cabk) ;
nicklist.add("سادة");
        nicklist.add("قلاب صيني");
        nicklist.add("صيني قلاب درجتين");
        nicklist.add("صيني ثلاث");
        nicklist.add("صيني درجتين");
        nicklist.add("سادة قلاب");
        nicklist.add("قلاب مفتوح");
        nicklist.add("قلاب ملكي");

        cabacklist.add("حشوه");

        cabacklist.add("دبل");

        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nicklist);
        sp1.setAdapter(adapter1);

        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,cabacklist);
        sp2.setAdapter(adapter2);




        editphone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editphone.setHint("الهاتف");
                }
                else
                    editphone.setHint("");


            }
        });


        editname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editname.setHint("اسم العميل");
                }
                else
                    editname.setHint("");
            }
        });

        editadresscount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editadresscount.setHint("الكميه");
                }
                else
                    editadresscount.setHint("");

            }
        });
        editValuPay.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editValuPay.setHint("القيمه");
                }
                else
                    editValuPay.setHint("");

            }
        });
        editValuRecive.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editValuRecive.setHint("المدفوع");
                }
                else
                    editValuRecive.setHint("");
            }
        });
        editValuRemind.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    editValuRemind.setHint("الباقي");
                }
                else
                    editValuRemind.setHint("");
            }
        });
    }
}
