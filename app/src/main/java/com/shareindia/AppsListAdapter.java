package com.shareindia;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shareindia.Models.AppModel;
import com.shareindia.Models.SendFileModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.MyViewHolder> {
    private List<AppModel> mApplicationList;
    Context mContext;
    List<SendFileModel> senFileList;

    public AppsListAdapter(ArrayList<AppModel> data, Context context) {
        this.mContext = context;
        this.mApplicationList = data;
        this.senFileList = ((MainActivity2) mContext).fileSendList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_installed_app, parent, false);

        // view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        ImageView imageView = holder.imageViewIcon;
        final TextView appName = holder.appName;
        final AppModel model = mApplicationList.get(position);
        holder.viewHolder.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
        holder.viewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setSelected(!model.isSelected());
                holder.viewHolder.setBackgroundColor(model.isSelected() ? Color.CYAN : Color.WHITE);
                SendFileModel sendFileModel = new SendFileModel();
                sendFileModel.setFileName(model.getAppName());
                sendFileModel.setFileSrc(model.getSrcLocation());
                sendFileModel.setFileType(model.getFileType());
                if (model.isSelected()) {
                    //Log.i("SELECTED","TRUE");
                    senFileList.add(sendFileModel);
                } else {
                    //Log.i("SELECTED","FALSE");
                    for (Iterator<SendFileModel> it = senFileList.iterator(); it.hasNext();) {
                        SendFileModel model1 = it.next();
                        Log.i("FILES",model1.toString()+" "+sendFileModel.toString());
                        if (model1.toString().equals(sendFileModel.toString())) {
                            it.remove();
                            //Log.i("REMOVED","TRUE");
                        }
                    }
                }
            }
        });
        try {
            String packageName = model.getPackageName();
            Drawable icon = mContext.getPackageManager().getApplicationIcon(packageName);
            imageView.setImageDrawable(icon);
            appName.setText(model.getAppName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mApplicationList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        TextView appName;
        View viewHolder;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.imageViewIcon = itemView.findViewById(R.id.img_ins_app);
            this.appName = itemView.findViewById(R.id.text_ins_app);
            this.viewHolder = itemView.findViewById(R.id.list_view_holder);
        }
    }
}
