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
import java.sql.Date;
import java.util.ArrayList;
import com.alghubari.afaq.SQdbHlper;
import com.alghubari.afaq.StoreContract.CustomereEntry;

import static com.alghubari.afaq.StoreContract.CustomereEntry.COLUMN_NAME_CUSTOMER;
import static com.alghubari.afaq.StoreContract.CustomereEntry.COLUMN_PHONE_NUM;
import static com.alghubari.afaq.StoreContract.CustomereEntry._ID;

public class MainActivity extends AppCompatActivity {

    TextInputLayout mNameTextInputLayout;

    private SQdbHlper mDbHelper;
    ImageButton btadd1,btnsearch1,btedit11,btsave;
  //ImageButton btadd,btnsearch,btnedit;
    EditText cusName ,cusPhone,addressprice,valuePay,valueRminde,shoulderLenght,adresscount,
    adresslenght,cumLenght,chestLenght,nicksize,handsize,fromdwon,cabacklenght, reciveDate,ednumpage;

    CheckBox geobcheck,gabasorCheck,gahschec,beginworkcheck;
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
      btsave = (ImageButton)findViewById(R.id.imageButton_save);
      btsave.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              insertPet();

          }


          private void insertPet() {
              int iswork,isready;
              String name, phone, pnum, count, addlenght, vprice, vpay, vremind, sholder, dateadd, cum, chest, nick, dwon, hand, caback, geeb, gabsoor, niktype, cabacktype = "";
              niktype = "";
              pnum = "";

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





              SQLiteDatabase db = mDbHelper.getWritableDatabase();
              name = cusName.getText().toString();
              phone = cusPhone.getText().toString();
              pnum = ednumpage.getText().toString();
              count=adresscount.getText().toString();
              addlenght=adresslenght.getText().toString();
              vprice=addressprice.getText().toString();
              vpay=valuePay.getText().toString();
              vremind=valueRminde.getText().toString();
              dateadd=reciveDate.getText().toString();
              cum=cumLenght.getText().toString();
              nick=nicksize.getText().toString();
              chest=chestLenght.getText().toString();
              sholder=shoulderLenght.getText().toString();
              cabacktype=cabacklenght.getText().toString();
              niktype=nikspiner.getSelectedItem().toString();
              cabacktype=cabackspiner.getSelectedItem().toString();
              hand=handsize.getText().toString();
              caback=cabacklenght.getText().toString();
              dwon=fromdwon.getText().toString();
             // boolean gahschec=false;



      //gahschec=(CheckBox)findViewById(R.id.check_gahas) ;
              beginworkcheck=(CheckBox)findViewById(R.id.chec_work) ;
              // Create a ContentValues object where column names are the keys,
              // and Toto's pet attributes are the values.
              ContentValues values = new ContentValues();
              values.put(COLUMN_NAME_CUSTOMER, name);
              values.put(COLUMN_PHONE_NUM, phone);
              values.put(CustomereEntry.COLUMN_DAY_OF_DATE, "2014-4-2");
              values.put(CustomereEntry.COLUMN_PRICE, vprice);
              values.put(CustomereEntry.COLUMN_REMIND_VALUE, vremind);
              values.put(CustomereEntry.COLUMN_PAYED_VALUE, vpay);
              values.put(CustomereEntry.COLUMN_RECIVE_DATE, dateadd);
              values.put(CustomereEntry.COLUMN_ADRESS_COUNT, count);
              values.put(CustomereEntry.COLUMN_ADRESS_LENGHT, addlenght);
              values.put(CustomereEntry.COLUMN_SHOULDER_LENGHT, sholder);
              values.put(CustomereEntry.COLUMN_KUM_LENGHT, cum);

              values.put(CustomereEntry.COLUMN_CHEST_WEDIGHT, chest);
              values.put(CustomereEntry.COLUMN_NIKE_SIZE, nick);

              values.put(CustomereEntry.COLUMN_HAND_LENGHT, hand);
              values.put(CustomereEntry.COLUMN_CABACK_LENGHT, caback);
              values.put(CustomereEntry.COLUMN_FROM_DAWON, dwon);
              if(gabasorCheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_GABSOR_TYPE, CustomereEntry.WITH_HASHOWH);
              }
              else
                  values.put(CustomereEntry.COLUMN_GABSOR_TYPE, CustomereEntry.WITH_OUT_HASHOWH);


              if(geobcheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_GEEB_TYPE, CustomereEntry.WITH_GEEB);
              }
              else
                  values.put(CustomereEntry.COLUMN_GEEB_TYPE, CustomereEntry.WITH_OUT_GEEB);




              if(cabackspiner.getSelectedItemPosition()==0)
              {
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.WITH_HASHOWH);
              }
              else if(cabackspiner.getSelectedItemPosition()==1)
              {
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.WITH_OUT_HASHOWH);
              }

              else
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.DABBLE);



              if(nikspiner.getSelectedItemPosition()==0)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_SADAH);
              }
              else if(nikspiner.getSelectedItemPosition()==1)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_KALAB);
              }
              else if(nikspiner.getSelectedItemPosition()==2)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_KALAB_TWO_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==3)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_THREE_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==4)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_TWO_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==5)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_SADAH_KLAB);
              }
              else if(nikspiner.getSelectedItemPosition()==6)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_KALAB_OPEN);
              }


              else
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_ROYAL_KALAB);


              //values.put(CustomereEntry.COLUMN_CABACK_TYPE, cabacktype);
             // values.put(CustomereEntry.COLUMN_NIKE_TYPE, niktype);
              values.put(CustomereEntry.COLUMN_PAGE_NUM, pnum);

              if(gahschec.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_IS_READY, CustomereEntry.IS_READY);
              }
              else
                  values.put(CustomereEntry.COLUMN_IS_READY, CustomereEntry.IS_NOT_READY);


              if(beginworkcheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_IS_BEGIN_WORK, CustomereEntry.IS_BEGIN_WORK);
              }
              else
                  values.put(CustomereEntry.COLUMN_IS_BEGIN_WORK, CustomereEntry.IS_NOT_BEGIN_WORK);



             // values.put(CustomereEntry.COLUMN_IS_BEGIN_WORK, 1);
             // values.put(CustomereEntry.COLUMN_IS_READY, 1);
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
        btnsearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,dateadd,daydate;
                name="";dateadd="";daydate="";
                int phone,npage,count,addlenght,vprice,vpay,vremind,sholder,cum,chest,nick,dwon,hand,caback,geeb,gabsoor,niktype,cabacktype,iswork,isready ;
                phone=0;npage=0;count=0;addlenght=0;vprice=0;vpay=0;vremind=0;sholder=0;cum=0;chest=0;nick=0;dwon=0;hand=0;caback=0;geeb=0;gabsoor=0;niktype=0;cabacktype =0;
                iswork=0;isready=0;


                SQLiteDatabase db = mDbHelper.getReadableDatabase();
                String searchStr = cusName.getText().toString();

                // Cursor c =  db.rawQuery("SELECT * FROM " + CustomereEntry.TABLE_NAME + " WHERE " +
                //  CustomereEntry.COLUMN_NAME_CUSTOMER + "=?", new String[]{searchStr});
                Cursor cursor = db.query(CustomereEntry.TABLE_NAME,

                        new String[]{CustomereEntry.COLUMN_NAME_CUSTOMER

                                , CustomereEntry.COLUMN_PHONE_NUM
                                , CustomereEntry.COLUMN_DAY_OF_DATE
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
                                , CustomereEntry.COLUMN_PAGE_NUM
                                ,CustomereEntry.COLUMN_IS_READY
                                ,CustomereEntry.COLUMN_IS_BEGIN_WORK},
                        CustomereEntry.COLUMN_NAME_CUSTOMER + "=?",
                        new String[]{String.valueOf(searchStr)}, null, null, null, null);

                if (cursor != null ) {
                    if  (cursor.moveToFirst()) {
                        do {

                            // int idNumber = cursor.getInt(cursor.getColumnIndex("_ID"));
                            name =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_NAME_CUSTOMER));

                            phone =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_PHONE_NUM));
                           daydate=cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_DAY_OF_DATE));
                            dateadd =cursor.getString(cursor.getColumnIndex(CustomereEntry.COLUMN_RECIVE_DATE));
                            vprice =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_PRICE));
                            vpay =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_PAYED_VALUE));
                            vremind =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_REMIND_VALUE));


                            count =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_RECIVE_DATE));


                            sholder =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_SHOULDER_LENGHT));
                            addlenght =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_ADRESS_LENGHT));

                            nick =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_NIKE_SIZE));


                            cum =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_KUM_LENGHT));

                            chest =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_CHEST_WEDIGHT));

                            hand=cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_HAND_LENGHT));

                            dwon =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_FROM_DAWON));

                            caback =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_CABACK_LENGHT));
                            geeb =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_GEEB_TYPE));
                            gabsoor =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_GABSOR_TYPE));
                            niktype =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_NIKE_TYPE));
                            cabacktype =cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_CABACK_TYPE));

                            npage=cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_PAGE_NUM));
                            isready=cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_IS_READY));
                            iswork=cursor.getInt(cursor.getColumnIndex(CustomereEntry.COLUMN_IS_BEGIN_WORK));
                            //valuePay,valueRminde,shoulderLenght,adresscount,
                            //    adresslenght,cumLenght,chestLenght,nicksize,handsize,fromdwon,cabacklenght, reciveDate;
                            Toast.makeText(MainActivity.this, "we find row, row id: " + name, Toast.LENGTH_SHORT).show();
                            //   Log.v("IdNumber",_ID);
                            Log.v("COLUMN_PHONE_NUM",COLUMN_PHONE_NUM);
                            cusName.setText(name);
                            cusPhone.setText(String.valueOf(phone));

                            addressprice.setText(String.valueOf(vprice));
                            valuePay.setText(String.valueOf(vpay));
                            valueRminde.setText(String.valueOf(vremind));
                            nicksize.setText(String.valueOf(nick));
                            adresscount.setText(String.valueOf(count));
                            reciveDate.setText(dateadd);
                            shoulderLenght.setText(String.valueOf(sholder));
                            adresslenght.setText(String.valueOf(addlenght));

                            cumLenght.setText(String.valueOf(cum));

                            chestLenght.setText(String.valueOf(chest));

                            handsize.setText(String.valueOf(hand));

                            fromdwon.setText(String.valueOf(dwon));

                            cabacklenght.setText(String.valueOf(caback));


                            geobcheck.setSelected(true);
                            if(geeb==1) {
                                geobcheck.setChecked(true);
                            }
                            else
                                geobcheck.setChecked(false);

                            if(isready==1) {
                                gahschec.setChecked(true);
                            }
                            else
                                gahschec.setChecked(false);
                            if(iswork==1) {
                                beginworkcheck.setChecked(true);
                            }
                            else
                                beginworkcheck.setChecked(false);

                            // gabasorCheck.setTextKeepState(gabsoor);
                            nikspiner.setSelection(niktype);
                            cabackspiner.setSelection(cabacktype);
                            ednumpage.setText(String.valueOf(npage));

                        }while (cursor.moveToNext());
                    }
                }



            }
        });
btadd1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
cusName.setText("");


    }

    });
      btedit11.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              CustomerModle customerModle2=new CustomerModle();

              updateProfile(customerModle2);

          }
          public boolean updateProfile(CustomerModle customerModle1)
          {
              int iswork,isready;
              String name, phone, pnum, count, addlenght, vprice, vpay, vremind, sholder, dateadd, cum, chest, nick, dwon, hand, caback, geeb, gabsoor, niktype, cabacktype = "";
              niktype = "";
              pnum = "";

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



              CustomerModle customerModle= new CustomerModle();
              SQLiteDatabase db = mDbHelper.getWritableDatabase();

              name = cusName.getText().toString();
              phone = cusPhone.getText().toString();
              pnum = ednumpage.getText().toString();
              count=adresscount.getText().toString();
              addlenght=adresslenght.getText().toString();
              vprice=addressprice.getText().toString();
              vpay=valuePay.getText().toString();
              vremind=valueRminde.getText().toString();
              dateadd=reciveDate.getText().toString();
              cum=cumLenght.getText().toString();
              nick=nicksize.getText().toString();
              chest=chestLenght.getText().toString();
              sholder=shoulderLenght.getText().toString();
              cabacktype=cabacklenght.getText().toString();
              niktype=nikspiner.getSelectedItem().toString();
              cabacktype=cabackspiner.getSelectedItem().toString();
              hand=handsize.getText().toString();
              caback=cabacklenght.getText().toString();
              dwon=fromdwon.getText().toString();
              // boolean gahschec=false;



              //gahschec=(CheckBox)findViewById(R.id.check_gahas) ;
              beginworkcheck=(CheckBox)findViewById(R.id.chec_work) ;
              // Create a ContentValues object where column names are the keys,
              // and Toto's pet attributes are the values.
              ContentValues values = new ContentValues();
              values.put(COLUMN_NAME_CUSTOMER, name);
              values.put(COLUMN_PHONE_NUM, phone);
              values.put(CustomereEntry.COLUMN_DAY_OF_DATE, "2014-4-2");
              values.put(CustomereEntry.COLUMN_PRICE, vprice);
              values.put(CustomereEntry.COLUMN_REMIND_VALUE, vremind);
              values.put(CustomereEntry.COLUMN_PAYED_VALUE, vpay);
              values.put(CustomereEntry.COLUMN_RECIVE_DATE, dateadd);
              values.put(CustomereEntry.COLUMN_ADRESS_COUNT, count);
              values.put(CustomereEntry.COLUMN_ADRESS_LENGHT, addlenght);
              values.put(CustomereEntry.COLUMN_SHOULDER_LENGHT, sholder);
              values.put(CustomereEntry.COLUMN_KUM_LENGHT, cum);

              values.put(CustomereEntry.COLUMN_CHEST_WEDIGHT, chest);
              values.put(CustomereEntry.COLUMN_NIKE_SIZE, nick);

              values.put(CustomereEntry.COLUMN_HAND_LENGHT, hand);
              values.put(CustomereEntry.COLUMN_CABACK_LENGHT, caback);
              values.put(CustomereEntry.COLUMN_FROM_DAWON, dwon);
              if(gabasorCheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_GABSOR_TYPE, CustomereEntry.WITH_HASHOWH);
              }
              else
                  values.put(CustomereEntry.COLUMN_GABSOR_TYPE, CustomereEntry.WITH_OUT_HASHOWH);


              if(geobcheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_GEEB_TYPE, CustomereEntry.WITH_GEEB);
              }
              else
                  values.put(CustomereEntry.COLUMN_GEEB_TYPE, CustomereEntry.WITH_OUT_GEEB);




              if(cabackspiner.getSelectedItemPosition()==0)
              {
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.WITH_HASHOWH);
              }
              else if(cabackspiner.getSelectedItemPosition()==1)
              {
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.WITH_OUT_HASHOWH);
              }

              else
                  values.put(CustomereEntry.COLUMN_CABACK_TYPE, CustomereEntry.DABBLE);



              if(nikspiner.getSelectedItemPosition()==0)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_SADAH);
              }
              else if(nikspiner.getSelectedItemPosition()==1)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_KALAB);
              }
              else if(nikspiner.getSelectedItemPosition()==2)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_KALAB_TWO_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==3)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_THREE_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==4)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_CHINA_TWO_DGREE);
              }
              else if(nikspiner.getSelectedItemPosition()==5)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_SADAH_KLAB);
              }
              else if(nikspiner.getSelectedItemPosition()==6)
              {
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_KALAB_OPEN);
              }


              else
                  values.put(CustomereEntry.COLUMN_NIKE_TYPE, CustomereEntry.NIKE_TYPE_ROYAL_KALAB);


              //values.put(CustomereEntry.COLUMN_CABACK_TYPE, cabacktype);
              // values.put(CustomereEntry.COLUMN_NIKE_TYPE, niktype);
              values.put(CustomereEntry.COLUMN_PAGE_NUM, pnum);

              if(gahschec.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_IS_READY, CustomereEntry.IS_READY);
              }
              else
                  values.put(CustomereEntry.COLUMN_IS_READY, CustomereEntry.IS_NOT_READY);


              if(beginworkcheck.isChecked()==true)
              {
                  values.put(CustomereEntry.COLUMN_IS_BEGIN_WORK, CustomereEntry.IS_BEGIN_WORK);
              }
              else
                  values.put(CustomereEntry.COLUMN_IS_BEGIN_WORK, CustomereEntry.IS_NOT_BEGIN_WORK);




              db.update(CustomereEntry.TABLE_NAME,values,CustomereEntry.COLUMN_NAME_CUSTOMER + "=?",new String[]{name});
              db.close();
              return true;
          }






      });

       // CheckBox geobcheck,gabasorCheck;
      //
        //  Spinner nikspiner, cabackspiner;
        geobcheck=(CheckBox) findViewById(R.id.chec_geuoob);
        gabasorCheck=(CheckBox) findViewById(R.id.check_gabsor);

      gahschec=(CheckBox) findViewById(R.id.check_gahas);

       beginworkcheck=(CheckBox) findViewById(R.id.chec_work);
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
        cabacklist.add("بدون حشوه");

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
        if (id == R.id.taske_activity) {

            startActivity(new Intent(MainActivity.this,TaskeActivity.class));
            return true;
            // Toast.makeText(this, "help page", Toast.LENGTH_LONG).show();
            // return true;
        }
        if (id == R.id.about_app) {

            startActivity(new Intent(MainActivity.this,AboutUs.class));
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

