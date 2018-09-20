package com.example.user.jetpackversi1.ui.Login;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.Item2DataBinding;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class Login2Adapter extends RecyclerView.Adapter<Login2Adapter.ViewHolder> {

    public void setmUsers(List<userdata> mUsers) {
        this.mUsers = mUsers;
        notifyDataSetChanged();
    }

    private List<userdata> mUsers;
    Context mContext;


    public Login2Adapter(Context context) {
        this.mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        Item2DataBinding binding = DataBindingUtil.inflate(inflater,R.layout.item2, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final userdata user = mUsers.get(position);

        holder.mBinding.textView.setText(user.userName);
        holder.mBinding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(mContext, user.userName, Toast.LENGTH_SHORT).show();
            }
        });
        holder.mBinding.textView1.setText(user.userUID);
        holder.mBinding.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(mContext, user.userUID, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mUsers != null)
            return mUsers.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Item2DataBinding mBinding;
        public ViewHolder(Item2DataBinding binding) {
            super(binding.getRoot());
            mBinding = binding;

        }

        public void bind(@NonNull userdata user) {

            //mBinding.textView.setText(user.getUserName());
            mBinding.executePendingBindings();
        }
    }
}