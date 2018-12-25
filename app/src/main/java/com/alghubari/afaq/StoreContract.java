package com.alghubari.afaq;

import android.provider.BaseColumns;

public final class StoreContract {

    public static abstract class CustomereEntry implements BaseColumns {



        /** Name of database table for custommers */
        public static final String TABLE_NAME = "customer";

        /**
         * Unique ID number for the custommer (only for use in the database table).
         *
         * Type: INTEGER
         */

        public final static String _ID = BaseColumns._ID;


        /**
         * Name of the custommer.
         *
         * Type: TEXT
         */
        public static final String COLUMN_NAME_CUSTOMER = "name";

        /**
         * the phone of customer
         * Type:Number
         * /

         */

        public static final String COLUMN_PHONE_NUM = "phone";
        public static final String COLUMN_DAY_OF_DATE = "dayofdate";
        public static final String COLUMN_PRICE = "price";

        public static final String COLUMN_PAYED_VALUE = "payed";

        public static final String COLUMN_REMIND_VALUE = "remind";
        public static final String COLUMN_ADRESS_COUNT = "count";
        public static final String COLUMN_RECIVE_DATE = "date";
        public static final String COLUMN_SHOULDER_LENGHT = "shoulder";
        public static final String COLUMN_ADRESS_LENGHT = "lenght";
        public static final String COLUMN_KUM_LENGHT = "kum";
        public static final String COLUMN_CHEST_WEDIGHT = "chest";
        public static final String COLUMN_NIKE_SIZE = "nike";
        public static final String COLUMN_HAND_LENGHT = "hand";
        public static final String COLUMN_CABACK_LENGHT = "cacklenght";
        public static final String COLUMN_FROM_DAWON = "dawon";
        public static final String COLUMN_GEEB_TYPE = "gheeb";
        public static final String COLUMN_GABSOR_TYPE = "gabsor";
        public static final String COLUMN_CABACK_TYPE = "cack";
        public static final String COLUMN_NIKE_TYPE = "typenike";
        public static final String COLUMN_PAGE_NUM = "pagenum";
        public static final String COLUMN_IS_READY="isready";
        public static final String COLUMN_IS_BEGIN_WORK="isbeginwork";

        /**
         * Possible values for gabsor.
         */
        public static final int WITH_GEEB = 1;
        public static final int WITH_OUT_GEEB = 0;
        public static final int WITH_HASHOWH = 0;
        public static final int WITH_OUT_HASHOWH = 1;
        public static final int DABBLE = 2;



        /**
         * type of nik
         */

        public static final int NIKE_TYPE_SADAH =0;
        public static final int NIKE_TYPE_CHINA_KALAB =1;
        public static final int NIKE_TYPE_CHINA_KALAB_TWO_DGREE =2;
        public static final int NIKE_TYPE_CHINA_THREE_DGREE =3;
        public static final int NIKE_TYPE_CHINA_TWO_DGREE=4;
        public static final int NIKE_TYPE_SADAH_KLAB=5;
        public static final int NIKE_TYPE_KALAB_OPEN=6;
        public static final int NIKE_TYPE_ROYAL_KALAB=7;

        public static final int IS_READY=1;
        public static final int IS_NOT_READY=0;

        public static final int IS_BEGIN_WORK=1;
        public static final int IS_NOT_BEGIN_WORK=0;





    }

}