package com.alghubari.afaq;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import com.alghubari.afaq.SQdbHlper;
import com.alghubari.afaq.StoreContract.CustomereEntry;

import static com.alghubari.afaq.StoreContract.CustomereEntry.COLUMN_NAME_CUSTOMER;
import static com.alghubari.afaq.StoreContract.CustomereEntry.COLUMN_PHONE_NUM;
import static com.alghubari.afaq.StoreContract.CustomereEntry._ID;

public class MainActivity extends AppCompatActivity {

    TextInputLayout mNameTextInputLayout;

    private SQdbHlper mDbHelper;
    ImageButton btadd1,btnsearch1,btedit11;
  //ImageButton btadd,btnsearch,btnedit;
    EditText cusName ,cusPhone,addressprice,valuePay,valueRminde,shoulderLenght,adresscount,
    adresslenght,cumLenght,chestLenght,nicksize,handsize,fromdwon,cabacklenght, reciveDate,ednumpage;

    CheckBox geobcheck,gabasorCheck;
    Spinner nikspiner, cabackspiner;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ma);
        mDbHelper = new SQdbHlper(this);
        File direct = new File(Environment.getExternalStorageDirectory() + "/Exam Creator");

        if(!direct.exists())
        {
            if(direct.mkdir())
            {
                //directory is created;
            }

        }



        cusName = (EditText) findViewById(R.id.edittext_name);
        ednumpage=(EditText) findViewById(R.id.ed_text_page_number);

        cusPhone = (EditText) findViewById(R.id.editext_phone);
       btadd1= (ImageButton) findViewById(R.id.imageButton_add);
       btnsearch1=(ImageButton) findViewById(R.id.imageButton_search);
       btedit11= (ImageButton)findViewById(R.id.imageButton_update);
        btnsearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,phone,npage,count,addlenght,vprice,vpay,vremind,sholder,dateadd,cum,chest,nick,dwon,hand,caback,geeb,gabsoor,niktype,cabacktype = "";
                niktype="";
                npage="";
                geeb="";
                name="";
                phone="";
                count="";
                addlenght="";
                vprice="";
                vpay="";
                vremind="" ;
                sholder="";
                dateadd="";
                cum="";
                chest="";
                nick="";
                dwon="";
                hand="";
                caback="";
                gabsoor="";


                SQLiteDatabase db = mDbHelper.getReadableDatabase();
                String searchStr = cusName.getText().toString();

                // Cursor c =  db.rawQuery("SELECT * FROM " + CustomereEntry.TABLE_NAME + " WHERE " +
                //  CustomereEntry.COLUMN_NAME_CUSTOMER + "=?", new String[]{searchStr});
                Cursor cursor = db.query(CustomereEntry.TABLE_NAME,

                        new String[]{CustomereEntry.COLUMN_NAME_CUSTOMER

                                , CustomereEntry.COLUMN_PHONE_NUM
                                , CustomereEntry.COLUMN_PRICE
                                , CustomereEntry.COLUMN_PAYED_VALUE
                                , CustomereEntry.COLUMN_REMIND_VALUE
                                , CustomereEntry.COLUMN_RECIVE_DATE
                                ,CustomereEntry.COLUMN_ADRESS_COUNT
                                , CustomereEntry.COLUMN_ADRESS_LENGHT
                                , CustomereEntry.COLUMN_SHOULDER_LENGHT
                                , CustomereEntry.COLUMN_KUM_LENGHT
                                , CustomereEntry.COLUMN_CHEST_WEDIGHT
                                , CustomereEntry.COLUMN_NIKE_SIZE
                                , CustomereEntry.COLUMN_HAND_LENGHT
                                , CustomereEntry.COLUMN_CABACK_LENGHT
                                , CustomereEntry.COLUMN_FROM_DAWON
                                , CustomereEntry.COLUMN_GABSOR_TYPE
                                , CustomereEntry.COLUMN_GEEB_TYPE
                                , CustomereEntry.COLUMN_CABACK_TYPE
                                , CustomereEntry.COLUMN_NIKE_TYPE
                                , CustomereEntry.COLUMN_PAGE_NUM},
                        CustomereEntry.COLUMN_NAME_CUSTOMER + "=?",
                        new String[]{String.valueOf(searchStr)}, null, null, null, null);

                if (cursor != null ) {
                    if  (cursor.moveToFirst()) {
                        do {

                            // int idNumber = cursor.getInt(cursor.getColumnIndex("_ID"));
                            name =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_NAME_CUSTOMER));

                            phone =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_PHONE_NUM));

                            dateadd =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_RECIVE_DATE));
                            vprice =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_PRICE));
                            vpay =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_PAYED_VALUE));
                            vremind =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_REMIND_VALUE));


                            count =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_RECIVE_DATE));


                            sholder =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_SHOULDER_LENGHT));
                            addlenght =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_ADRESS_LENGHT));

                            nick =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_NIKE_SIZE));


                            cum =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_KUM_LENGHT));

                            chest =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_CHEST_WEDIGHT));

                            hand=cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_HAND_LENGHT));

                            dwon =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_FROM_DAWON));

                            caback =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_CABACK_LENGHT));
                            geeb =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_GEEB_TYPE));
                            gabsoor =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_GABSOR_TYPE));
                            niktype =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_NIKE_TYPE));
                            cabacktype =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_CABACK_TYPE));

                            npage=cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_PAGE_NUM));
                            //valuePay,valueRminde,shoulderLenght,adresscount,
                            //    adresslenght,cumLenght,chestLenght,nicksize,handsize,fromdwon,cabacklenght, reciveDate;
                            Toast.makeText(MainActivity.this, "we find row, row id: " + name, Toast.LENGTH_SHORT).show();
                            //   Log.v("IdNumber",_ID);
                            Log.v("COLUMN_PHONE_NUM",COLUMN_PHONE_NUM);
                            cusName.setText(name);
                            cusPhone.setText(phone);

                            addressprice.setText(vprice);
                            valuePay.setText(vpay);
                            valueRminde.setText(vremind);
                            nicksize.setText(nick);
                            adresscount.setText(count);
                            reciveDate.setText(dateadd);
                            shoulderLenght.setText(sholder);
                            adresslenght.setText(addlenght);

                            cumLenght.setText(cum);

                            chestLenght.setText(chest);

                            handsize.setText(hand);

                            fromdwon.setText(dwon);

                            cabacklenght.setText(caback);


                            geobcheck.setSelected(true);
                            if(Integer.parseInt(geeb)==1) {
                                geobcheck.setChecked(true);
                            }
                            else
                                geobcheck.setChecked(false);

                            // gabasorCheck.setTextKeepState(gabsoor);
                            nikspiner.setSelection(Integer.parseInt(niktype));
                            cabackspiner.setSelection(Integer.parseInt(cabacktype));
                            ednumpage.setText(npage);

                        }while (cursor.moveToNext());
                    }
                }



            }
        });
btadd1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        insertPet();

    }
    private void insertPet() {
        String name, phone, pnum, count, addlenght, vprice, vpay, vremind, sholder, dateadd, cum, chest, nick, dwon, hand, caback, geeb, gabsoor, niktype, cabacktype = "";
        niktype = "";
        pnum = "";
        geeb = "";
        name = "";
        phone = "";
        count = "";
        addlenght = "";
        vprice = "";
        vpay = "";
        vremind = "";
        sholder = "";
        dateadd = "";
        cum = "";
        chest = "";
        nick = "";
        dwon = "";
        hand = "";
        caback = "";
        gabsoor = "";

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        name = cusName.getText().toString();
        phone = cusPhone.getText().toString();
        pnum = ednumpage.getText().toString();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_CUSTOMER, name);
        values.put(COLUMN_PHONE_NUM, phone);
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
        values.put(CustomereEntry.COLUMN_PAGE_NUM, "54");


        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        long newRowId = db.insert(CustomereEntry.TABLE_NAME, null, values);
        if (newRowId != -1)
            Toast.makeText(MainActivity.this, "New row added, row id: " + newRowId, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();

    }
    });
      btedit11.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


          }




      });

       // CheckBox geobcheck,gabasorCheck;
      //
        //  Spinner nikspiner, cabackspiner;
        geobcheck=(CheckBox) findViewById(R.id.chec_geuoob);
        gabasorCheck=(CheckBox) findViewById(R.id.check_gabsor);
        nikspiner=(Spinner) findViewById(R.id.spinner_nick);
       cabackspiner=(Spinner) findViewById(R.id.spinner_cabk);

        // TextInputEditText tab1=(TextInputEditText)findViewById(R.id.te);
        // tab1.setHint("customername");

        // TextInputLayout tname=(TextInputLayout)findViewById(R.id.textlayout_name);
        final Spinner sp1, sp2;
       // final EditText editname, editphone, editadresscount, editValuPay, editValuRecive, editValuRemind, addressLenght, shoulderLenght, armLenght;
        ArrayList<String> nicklist = new ArrayList<>();
        ArrayList<String> cabacklist = new ArrayList<>();


        //name of customer
        //phone number of customer
      //  editphone = (EditText) findViewById(R.id.editext_phone);
        //the number of address for custommer
      adresscount = (EditText) findViewById(R.id.editext_adress_count);
        //the address price
        addressprice = (EditText) findViewById(R.id.edittext_address_price);
        //the value wich the customer pay
        valuePay = (EditText) findViewById(R.id.editext_value_pay);
        //the value wich remind
        valueRminde = (EditText) findViewById(R.id.editext_remained_value);

       // sp1 = (Spinner) findViewById(R.id.spinner_nick);

       // sp2 = (Spinner) findViewById(R.id.spinner_cabk);
       adresslenght = (EditText) findViewById(R.id.editext_adress_lenght);

        shoulderLenght = (EditText) findViewById(R.id.editext_shoulder_lenght);
        reciveDate = (EditText) findViewById(R.id.edittext_date);

        cumLenght = (EditText) findViewById(R.id.ed_text_alkm);

        chestLenght = (EditText) findViewById(R.id.ed_text_chest);
        handsize = (EditText) findViewById(R.id.ed_text_hand);

     nicksize = (EditText) findViewById(R.id.ed_text_nick);

        fromdwon = (EditText) findViewById(R.id.ed_text_fromdwon);

        cabacklenght = (EditText) findViewById(R.id.ed_text_caback_lenght);



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
       nikspiner.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, cabacklist);
        cabackspiner.setAdapter(adapter2);







        /*...................................

       */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.men_main, menu);
        return true;

    }
    // This determines the title for each tab




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.export_db) {
        exportDB();

            return true;
        }

        if (id == R.id.import_db) {
            importDB();

            return true;
        }
        if (id == R.id.about_app) {

            return true;
            // Toast.makeText(this, "help page", Toast.LENGTH_LONG).show();
            // return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //importing database
    private void importDB() {
        // TODO Auto-generated method stub

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data  = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "com.alghubari.afaq"
                        + "//databases//" + "afaqadress.db";
                String backupDBPath  = "/Exam Creator/afaqadress.db";
                File  backupDB= new File(data, currentDBPath);
                File currentDB  = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getBaseContext(), backupDB.toString(),
                        Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG)
                    .show();

        }
    }
    //exporting database
    private void exportDB() {
        // TODO Auto-generated method stub

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "com.alghubari.afaq"
                        + "//databases//" + "afaqadress.db";
                String backupDBPath  = "/Exam Creator/afaqadress.db";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getBaseContext(), backupDB.toString(),
                        Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG)
                    .show();

        }
    }

}

