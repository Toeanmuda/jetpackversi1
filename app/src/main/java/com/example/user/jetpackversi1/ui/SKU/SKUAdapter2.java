package com.example.user.jetpackversi1.ui.SKU;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.Datasku;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.Checkin_HatcheryDataDetailDetailBinding;

import java.util.List;

public class SKUAdapter2 extends RecyclerView.Adapter<SKUAdapter2.ViewHolder> implements handler {

    public void setmUsers(List<Datasku> mUsers2) {
        this.mUsers2 = mUsers2;

        notifyDataSetChanged();
    }

    private List<Datasku> mUsers2;
  //  private List<Modelitem> mUsers;
    Context mContext;
   private AppDatabase appDatabase;


    public SKUAdapter2(Context context, AppDatabase appDatabase) {
        this.mContext=context;
        this.appDatabase=appDatabase;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Checkin_HatcheryDataDetailDetailBinding binding = DataBindingUtil.inflate(inflater,R.layout.item_checkin_hatchery_data_detail_detail, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Datasku user = mUsers2.get(position);

        holder.bind(user);
        //Datasku state = appDatabase.dataskuDao().getState(user.trcSid);

        //final Login2Adapter login2Adapter= new Login2Adapter(mContext);
       // List<userdata> user1= new ArrayList<>();
        //userdata user2= new userdata(user.userUID,user.userName);
        //user1.add(user2);
       // login2Adapter.setmUsers(user1);
       // holder.mBinding.recycle1.setAdapter(login2Adapter);
       // holder.mBinding.recycle1.setLayoutManager(new LinearLayoutManager(mContext));

       // Modelitem modelitem = new Modelitem(user.userUID, user.userName,false);

        holder.mBinding.checkboxMeat.setTag(R.id.tag_position,position);

       /*
            holder.mBinding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        holder.mBinding.textView1.setBackgroundColor(YELLOW);
                    } else {
                        holder.mBinding.textView1.setBackgroundColor(BLUE);
                    }

                     }

            });

*/
    }

    @Override
    public int getItemCount() {
        if (mUsers2 != null)
            return mUsers2.size();
        else return 0;
    }

    @Override
    public void clickCheckbox(View view) {
        int position = (int) view.getTag(R.id.tag_position);
        Datasku item = mUsers2.get(position);

       /* Datasku word = new Datasku();
        word.trcSid = item.trcSid;
        word.skuSid = "update nih";
        word.checked = true;
        appDatabase.dataskuDao().updatelagi(word);*/
if (item.checked==null) {item.checked=false;}
    item.checked = !item.checked;
    if (item.checked == true) {
        Log.i("MainAdapter", "checkbox checked is :" + item.skuSid + item.checked);

       // Datasku word = new Datasku();
      //  word.trcSid = item.trcSid;
       /// word.skuSid = "update nih";
      //  word.checked = item.checked;
       // appDatabase.dataskuDao().updatelagi(word);
        appDatabase.dataskuDao().update_checked(true, item.trcSid);
    } else {
        Log.i("MainAdapter", ",checkbox unchecked is :" +
                item.checked);
        //Datasku word = new Datasku();
       // word.trcSid = item.trcSid;
       // word.checked = item.checked;
        appDatabase.dataskuDao().update_checked(false, item.trcSid);

    }


        // if(item.checked==null)

        //state.checked=false;

        // else
        //   state.checked=!state.checked;

/*
        if(item.checked==null){
            Log.i("checked", "NULL");
         //   item.checked=false;
        }
        else{
            Log.i("checked", item.checked.toString());
        }
       */
        // Log.i("MainAdapter", item.checked.toString());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Checkin_HatcheryDataDetailDetailBinding mBinding;
        public ViewHolder(Checkin_HatcheryDataDetailDetailBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
          binding.setEventListener(SKUAdapter2.this);

        }

        public void bind(@NonNull Datasku user) {
            //Log.d("tag",user.skuSid);
            if(appDatabase.skuDao().getSkuName(user.skuSid)!=null){
                user.skuSid = appDatabase.skuDao().getSkuName(user.skuSid);
            }

            mBinding.setViewModel(user);
            //mBinding.textView.setText(user.getUserName());
            mBinding.executePendingBindings();
        }



    }
}