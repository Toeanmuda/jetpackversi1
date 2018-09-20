package com.example.user.jetpackversi1.ui.SKU;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.Datasku;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.ItemDataBinding;
import com.example.user.jetpackversi1.databinding.Checkin_HatcheryDataDetailBinding;
import com.example.user.jetpackversi1.ui.Login.handler;

import java.util.ArrayList;
import java.util.List;

public class SKUAdapter extends RecyclerView.Adapter<SKUAdapter.ViewHolder> {

    SKUAdapter2 skuAdapter2;
    public void setmUsers(List<Datasku> mUsers2) {
        this.mUsers2 = mUsers2;
        notifyDataSetChanged();
    }

    private List<Datasku> mUsers2;
  //  private List<Modelitem> mUsers;
    Context mContext;
   private AppDatabase appDatabase;


    public SKUAdapter(Context context, AppDatabase appDatabase) {
        this.mContext=context;
        this.appDatabase=appDatabase;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Checkin_HatcheryDataDetailBinding binding = DataBindingUtil.inflate(inflater,R.layout.item_checkin_hatchery_data_detail, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Datasku user = mUsers2.get(position);
        //List<Datasku> e= new ArrayList<>();
        //e.add()
        holder.bind(mUsers2);


        //final Login2Adapter login2Adapter= new Login2Adapter(mContext);
       // List<userdata> user1= new ArrayList<>();
        //userdata user2= new userdata(user.userUID,user.userName);
        //user1.add(user2);
       // login2Adapter.setmUsers(user1);
       // holder.mBinding.recycle1.setAdapter(login2Adapter);
       // holder.mBinding.recycle1.setLayoutManager(new LinearLayoutManager(mContext));

       // Modelitem modelitem = new Modelitem(user.userUID, user.userName,false);

       // holder.mBinding.checkBox.setTag(R.id.tag_position,position);

       //
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


    public class ViewHolder extends RecyclerView.ViewHolder {
        private Checkin_HatcheryDataDetailBinding mBinding;
        public ViewHolder(Checkin_HatcheryDataDetailBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
          // binding.setEventListener(SKUAdapter.this);

        }

        public void bind(List<Datasku> data) {
            skuAdapter2=new SKUAdapter2(mContext,appDatabase);
            mBinding.recycle.setLayoutManager(new LinearLayoutManager(mContext));
            mBinding.recycle.setAdapter(skuAdapter2);
            skuAdapter2.setmUsers(data);
            //mBinding.textView.setText(user.getUserName());
            mBinding.executePendingBindings();
        }



    }
}