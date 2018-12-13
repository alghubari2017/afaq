package com.alghubari.afaq;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import com.alghubari.afaq.SQdbHlper;
import com.alghubari.afaq.StoreContract.CustomereEntry;

public class MainActivity extends AppCompatActivity {

    TextInputLayout mNameTextInputLayout;

    private SQdbHlper mDbHelper;
    Button btadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new SQdbHlper(this);
        btadd = (Button) findViewById(R.id.button_add);
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPet();
            }

            private void insertPet() {

                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                // Create a ContentValues object where column names are the keys,
                // and Toto's pet attributes are the values.
                ContentValues values = new ContentValues();
                values.put(CustomereEntry.COLUMN_NAME_CUSTOMER, "ali");
                values.put(CustomereEntry.COLUMN_PHONE_NUM, "738301848");
                values.put(CustomereEntry.COLUMN_PRICE, "7000");
                values.put(CustomereEntry.COLUMN_REMIND_VALUE, "2000");
                values.put(CustomereEntry.COLUMN_PAYED_VALUE, "5000");
                values.put(CustomereEntry.COLUMN_RECIVE_DATE, "5000");
                values.put(CustomereEntry.COLUMN_ADRESS_COUNT, "1");
                values.put(CustomereEntry.COLUMN_ADRESS_LENGHT, "50");
                values.put(CustomereEntry.COLUMN_SHOULDER_LENGHT, "2");
                values.put(CustomereEntry.COLUMN_KUM_LENGHT, "2");

                values.put(CustomereEntry.COLUMN_CHEST_WEDIGHT, "10");
                values.put(CustomereEntry.COLUMN_NIKE_SIZE, "4");

                values.put(CustomereEntry.COLUMN_HAND_LENGHT, "5");
                values.put(CustomereEntry.COLUMN_CABACK_LENGHT, "10");
                values.put(CustomereEntry.COLUMN_FROM_DAWON, "7");
                values.put(CustomereEntry.COLUMN_GABSOR_TYPE, CustomereEntry.WITH_HASHOWH);
                values.put(CustomereEntry.COLUMN_GEEB_TYPE, CustomereEntry.WITH_GEEB);
                values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.WITH_HASHOWH);
                values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_ROYAL_KALAB);



                // Insert a new row for Toto in the database, returning the ID of that new row.
                // The first argument for db.insert() is the pets table name.
                // The second argument provides the name of a column in which the framework
                // can insert NULL in the event that the ContentValues is empty (if
                // this is set to "null", then the framework will not insert a row when
                // there are no values).
                // The third argument is the ContentValues object containing the info for Toto.
                long newRowId = db.insert(CustomereEntry.TABLE_NAME, null, values);
                if(newRowId != -1)
                    Toast.makeText(MainActivity.this, "New row added, row id: " + newRowId, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();

            }
        });
        // TextInputEditText tab1=(TextInputEditText)findViewById(R.id.te);
        // tab1.setHint("customername");

        // TextInputLayout tname=(TextInputLayout)findViewById(R.id.textlayout_name);
        final Spinner sp1, sp2;
        final EditText editname, editphone, editadresscount, editValuPay, editValuRecive, editValuRemind, addressLenght, shoulderLenght, armLenght;
        ArrayList<String> nicklist = new ArrayList<>();
        ArrayList<String> cabacklist = new ArrayList<>();


        //name of customer
        editname = (EditText) findViewById(R.id.edittext_name);
        //phone number of customer
        editphone = (EditText) findViewById(R.id.editext_phone);
        //the number of address for custommer
        editadresscount = (EditText) findViewById(R.id.editext_adress_count);
        //the address price
        editValuPay = (EditText) findViewById(R.id.edittext_address_price);
        //the value wich the customer pay
        editValuRecive = (EditText) findViewById(R.id.editext_value_pay);
        //the value wich remind
        editValuRemind = (EditText) findViewById(R.id.editext_remained_value);

        sp1 = (Spinner) findViewById(R.id.spinner_nick);

        sp2 = (Spinner) findViewById(R.id.spinner_cabk);
        addressLenght = (EditText) findViewById(R.id.editext_adress_lenght);

        shoulderLenght = (EditText) findViewById(R.id.editext_shoulder_lenght);


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

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nicklist);
        sp1.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cabacklist);
        sp2.setAdapter(adapter2);







        /*...................................

       */

    }
}

