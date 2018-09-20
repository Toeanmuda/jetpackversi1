package com.example.user.jetpackversi1.ui.Login;

import android.content.ClipData;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.ItemDataBinding;

import com.example.user.jetpackversi1.data.model.User;
import com.example.user.jetpackversi1.R;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.ViewHolder> implements handler {

    public void setmUsers(List<userdata> mUsers2) {
        this.mUsers2 = mUsers2;
        notifyDataSetChanged();
    }

    private List<userdata> mUsers2;
  //  private List<Modelitem> mUsers;
    Context mContext;
   private AppDatabase appDatabase;


    public LoginAdapter(Context context, AppDatabase appDatabase) {
        this.mContext=context;
        this.appDatabase=appDatabase;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDataBinding binding = DataBindingUtil.inflate(inflater,R.layout.item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final userdata user = mUsers2.get(position);
        //final Login2Adapter login2Adapter= new Login2Adapter(mContext);
       // List<userdata> user1= new ArrayList<>();
        //userdata user2= new userdata(user.userUID,user.userName);
        //user1.add(user2);
       // login2Adapter.setmUsers(user1);
       // holder.mBinding.recycle1.setAdapter(login2Adapter);
       // holder.mBinding.recycle1.setLayoutManager(new LinearLayoutManager(mContext));

       // Modelitem modelitem = new Modelitem(user.userUID, user.userName,false);
            holder.bind(user);

        holder.mBinding.checkBox.setTag(R.id.tag_position,position);

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

    @Override
    public void clickCheckbox(View view) {
            int position = (int)view.getTag(R.id.tag_position);
            userdata item = mUsers2.get(position);
            item.checked = !item.checked;
            if (item.checked==true){
                Log.i("MainAdapter","Before click,checkbox checked is true :"+item.userUID+item.userName+item.checked);
                userdata word = new userdata(item.userUID,item.userName,item.checked);
                appDatabase.userDao().updatelagi(word);
            }
            else{
                Log.i("MainAdapter","Before click,checkbox checked is false :"+item.checked);
                userdata word = new userdata(item.userUID,item.userName,item.checked);
                appDatabase.userDao().updatelagi(word);
            }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDataBinding mBinding;
        public ViewHolder(ItemDataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            binding.setEventListener(LoginAdapter.this);

        }

        public void bind(@NonNull userdata user) {
           mBinding.setViewModel(user);
            //mBinding.textView.setText(user.getUserName());
            mBinding.executePendingBindings();
        }



    }
}