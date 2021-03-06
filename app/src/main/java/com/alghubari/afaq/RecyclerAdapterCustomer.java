package com.alghubari.afaq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class RecyclerAdapterCustomer extends RecyclerView.Adapter<RecyclerAdapterCustomer.customerAdapter> {
private  static final String TAG=RecyclerAdapterCustomer.class.getSimpleName().toString();
    private List<CustomerModle>customerModleList=new ArrayList<>();
    private Context context;

    public RecyclerAdapterCustomer(List<CustomerModle> customerModleList, Context context) {
        this.customerModleList = customerModleList;
        this.context = context;
    }

    @NonNull
    @Override
    public customerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rc,parent,false);
        customerAdapter customerAdapterholder=new customerAdapter(row);
        return customerAdapterholder;
    }

    @Override
    public void onBindViewHolder(@NonNull customerAdapter holder, int position) {

        CustomerModle customerModle=customerModleList.get(position);
        holder.customerName.setText(customerModle.getCustomerName());
        holder.customerPhone.setText(String.valueOf(customerModle.getCustomerPhone()));
        holder.addressCount.setText(String.valueOf(customerModle.getAddressCount()));
        holder.addressPrice.setText(String.valueOf(customerModle.getAddressPrice()));
        holder.addressPay.setText(String.valueOf(customerModle.getAddressPay()));
        holder.adressRemind.setText(String.valueOf(customerModle.getAddressRiminde()));
        holder.addressLenght.setText(String.valueOf(customerModle.getAddressLenght()));
        holder.reciveDate.setText(customerModle.getRiciveDate());
        holder.cumLnght.setText(String.valueOf(customerModle.getAlkumLenght()));
        if(customerModle.getTypeOfNike()==0) {
            holder.nikeType.setText(("سادة"));
        }
        else if(customerModle.getTypeOfNike()==1){
            holder.nikeType.setText(("قلاب صيني"));

        }
        else if(customerModle.getTypeOfNike()==2){
            holder.nikeType.setText(("سادة"));

        }
        else if(customerModle.getTypeOfNike()==3){
            holder.nikeType.setText(("ص ق درجتين"));

        }
        else if(customerModle.getTypeOfNike()==4){
            holder.nikeType.setText(("صيني3درج"));


        }
        else if(customerModle.getTypeOfNike()==5){
            holder.nikeType.setText(("سادة قلاب"));

        }
        else if(customerModle.getTypeOfNike()==6){
            holder.nikeType.setText(("قلاب مفتوح "));

        }

        else
            holder.nikeType.setText(("قلاب ملكي"));

        if(customerModle.getTypeOfKaback()==0) {
            holder.cbackType.setText(("بدون حشوه"));
        }
        else if(customerModle.getTypeOfKaback()==1){
            holder.cbackType.setText(("حشوه"));

        }
        else
            holder.cbackType.setText(("دبل"));




        holder.chestLenght.setText(String.valueOf(customerModle.getChessWidth()));
        holder.shoulderLenght.setText(String.valueOf(customerModle.getShoulderLenght()));
        holder.nikeSize.setText(String.valueOf(customerModle.getHandLenght()));
        holder.cabackLenght.setText(String.valueOf(customerModle.getCabackLenght()));
        holder.fromDwon.setText(String.valueOf(customerModle.getFromDwonLenght()));
        if(customerModle.getGeebType()==0) {
            holder.geebType.setText(("لايوجد"));
        }
        else
            holder.geebType.setText(("يوجد"));

        if(customerModle.getGabsorType()==0) {
            holder.gabsorType.setText(("لايوجد"));
        }
        else
            holder.gabsorType.setText(("يوجد"));



        holder.pageNumber.setText(String.valueOf(customerModle.getPageNumber()));
        if(customerModle.getIsReady()==1) {
            holder.isAddressReady.setText(("نعم"));
        }
        else
            holder.isAddressReady.setText(("لا"));


        if(customerModle.getIsBeginWork()==1) {
            holder.isBeginWork.setText(("نعم"));
        }
        else
            holder.isBeginWork.setText(("لا"));



    }

    @Override
    public int getItemCount() {
        return customerModleList.size();
    }


    public class customerAdapter extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView customerName,customerPhone,reciveDate,nikeType,cbackType,pageNumber,isAddressReady,isBeginWork,addressCount,
        addressLenght,cumLnght,chestLenght,nikeSize,cabackLenght,addressPrice,addressPay,adressRemind,shoulderLenght,handLenght,fromDwon,
        gabsorType,geebType;
        private String mItem;

        public customerAdapter(View itemView) {
            super(itemView);
            customerName=(TextView)itemView.findViewById(R.id.textview_cus_name);
            customerPhone=(TextView)itemView.findViewById(R.id.textview_phone_num);
            reciveDate=(TextView)itemView.findViewById(R.id.textview_datee);
            nikeType=(TextView)itemView.findViewById(R.id.textview_nike_type);
            cbackType=(TextView)itemView.findViewById(R.id.textview_caback_type);
            pageNumber=(TextView)itemView.findViewById(R.id.textview_page_num);
            isAddressReady=(TextView)itemView.findViewById(R.id.textview_ready);

            isBeginWork=(TextView)itemView.findViewById(R.id.textview_begin_work);
            addressCount=(TextView)itemView.findViewById(R.id.textview_count);

            addressLenght=(TextView)itemView.findViewById(R.id.textview_address_lenght);
            cumLnght=(TextView)itemView.findViewById(R.id.textview_cum_lenght);

            chestLenght=(TextView)itemView.findViewById(R.id.textview_chest_lenght);
            nikeSize=(TextView)itemView.findViewById(R.id.textview_nik_lenght);

            cabackLenght=(TextView)itemView.findViewById(R.id.textview_caback_lenght);
            addressPrice=(TextView)itemView.findViewById(R.id.text_price);
            addressPay=(TextView)itemView.findViewById(R.id.textview_pay);
            adressRemind=(TextView)itemView.findViewById(R.id.textview_remind);
            shoulderLenght=(TextView)itemView.findViewById(R.id.textview_address_lenght);
            handLenght=(TextView)itemView.findViewById(R.id.textview_hand_lenght);
            fromDwon=(TextView)itemView.findViewById(R.id.textview_dwon_lenght);


            gabsorType=(TextView)itemView.findViewById(R.id.textview_gabsor_type);
           geebType=(TextView)itemView.findViewById(R.id.textview_geeb_type);




        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick " + getPosition() + " " + mItem);

        }
    }

}
