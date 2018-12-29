package com.alghubari.afaq;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.alghubari.afaq.SQdbHlper;
import com.alghubari.afaq.StoreContract.CustomereEntry;

import java.util.ArrayList;
import java.util.List;

import static com.alghubari.afaq.StoreContract.CustomereEntry.COLUMN_PHONE_NUM;

public class TaskeActivity extends AppCompatActivity {

    List<CustomerModle> data=new ArrayList<>();
    RecyclerView recyler;
    private SQdbHlper mDbHelper;
    private List<CustomerModle>customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taske);

        mDbHelper = new SQdbHlper(this);
        CustomerModle customerModle1=new CustomerModle();
       viewTaske();
       // getAllData_a(customerModle1);
        recyler = (RecyclerView) findViewById(R.id.recyclerview);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapterCustomer adapter = new RecyclerAdapterCustomer(customerList, this);
        recyler.setAdapter(adapter);



    }



    public void viewTaske() {
        int isnotredy=0;
        int isnotbeginwork=0;

        customerList=new ArrayList<CustomerModle>();


        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        int searchStr = 0;
        String[] tablecolumns=new String[]{CustomereEntry.COLUMN_NAME_CUSTOMER

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
                ,CustomereEntry.COLUMN_IS_BEGIN_WORK};

        String whereClause = CustomereEntry.COLUMN_IS_READY + " = ? AND " + CustomereEntry.COLUMN_IS_BEGIN_WORK  + " = ?";
        String[] whereArgs = new String[] {
                String.valueOf(isnotredy),
                String.valueOf(isnotbeginwork)
        };


        // Cursor c =  db.rawQuery("SELECT * FROM " + CustomereEntry.TABLE_NAME + " WHERE " +
        //  CustomereEntry.COLUMN_NAME_CUSTOMER + "=?", new String[]{searchStr});
        Cursor cursor = db.query(CustomereEntry.TABLE_NAME,tablecolumns,whereClause,whereArgs,null,null,CustomereEntry.COLUMN_RECIVE_DATE,null);





        cursor.getCount();
        startManagingCursor(cursor);//the important line

            if (cursor.moveToFirst()) {
                do {
                    CustomerModle customerModle=new CustomerModle();

                    // int idNumber = cursor.getInt(cursor.getColumnIndex("_ID"));
                    customerModle.setCustomerName(cursor.getString(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_NAME_CUSTOMER)));
                    customerModle.setCustomerPhone(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_PHONE_NUM)));
                    customerModle.setRiciveDate(cursor.getString(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_RECIVE_DATE)));

                   // daydate = cursor.getString(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_DAY_OF_DATE));
                    customerModle.setAddressPrice(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_PRICE)));
                    customerModle.setAddressPay(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_PAYED_VALUE)));
                   customerModle.setAddressRiminde(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_REMIND_VALUE)));
                    customerModle.setAddressCount(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_RECIVE_DATE)));

                    customerModle.setShoulderLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_SHOULDER_LENGHT)));

                    customerModle.setAddressLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_ADRESS_LENGHT)));
                    customerModle.setNikeSize(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_NIKE_SIZE)));




                    customerModle.setAlkumLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_KUM_LENGHT)));


                    customerModle.setChessWidth(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_CHEST_WEDIGHT)));

                    customerModle.setHandLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_HAND_LENGHT)));

                    customerModle.setFromDwonLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_FROM_DAWON)));
                    customerModle.setCabackLenght(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_CABACK_LENGHT)));

                    customerModle.setGeebType(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_GEEB_TYPE)));

                    customerModle.setGabsorType(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_GABSOR_TYPE)));
                    customerModle.setTypeOfNike(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_NIKE_TYPE)));
                    customerModle.setTypeOfKaback(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_CABACK_TYPE)));
                    customerModle.setPageNumber(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_PAGE_NUM)));
                    customerModle.setIsReady(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_IS_READY)));
                    customerModle.setIsBeginWork(cursor.getInt(cursor.getColumnIndex(StoreContract.CustomereEntry.COLUMN_IS_BEGIN_WORK)));
                    customerList.add(customerModle);
                    //valuePay,valueRminde,shoulderLenght,adresscount,
                    //    adresslenght,cumLenght,chestLenght,nicksize,handsize,fromdwon,cabacklenght, reciveDate;
                    //  Toast.makeText(MainActivity.this, "we find row, row id: " + name, Toast.LENGTH_SHORT).show();
                    //   Log.v("IdNumber",_ID);
                    Log.v("COLUMN_PHONE_NUM", COLUMN_PHONE_NUM);

                } while (cursor.moveToNext());

            }
        }



}



