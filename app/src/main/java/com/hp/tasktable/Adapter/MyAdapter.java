package com.hp.tasktable.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hp.tasktable.Model.ResponseModel;
import com.hp.tasktable.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ResponseModel responseModel;
    Context context;

    public MyAdapter(ResponseModel responseModel, Context context) {
        this.responseModel = responseModel;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Glide
                .with(context)
                .load(responseModel.getSuccess().get(position).getImage())
                .into(holder.imageView);
        holder.name.setText(responseModel.getSuccess().get(position).getName());
        holder.category.setText(responseModel.getSuccess().get(position).getCategory());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                ViewGroup parent;
                LayoutInflater inflater = LayoutInflater.from( context );
                final View dialogView = inflater.inflate(R.layout.popup, null);
                dialogBuilder.setView(dialogView);

                final EditText namePopup = (EditText) dialogView.findViewById(R.id.popupname);
                final EditText categoryPopup = (EditText) dialogView.findViewById(R.id.popupcategory);
                final EditText descPopup = (EditText) dialogView.findViewById(R.id.popupdesc);
                final EditText contactPopup = (EditText) dialogView.findViewById(R.id.popupcontact);
                final EditText addressPopup = (EditText) dialogView.findViewById(R.id.popupaddress);
                final EditText empcodePopup = (EditText) dialogView.findViewById(R.id.popupempcode);
                final ImageView dp = (ImageView) dialogView.findViewById(R.id.popupimage);

                namePopup.setText(responseModel.getSuccess().get(position).getName());
                categoryPopup.setText(responseModel.getSuccess().get(position).getCategory());
                descPopup.setText(responseModel.getSuccess().get(position).getDescription());
                contactPopup.setText(responseModel.getSuccess().get(position).getContact());
                addressPopup.setText(responseModel.getSuccess().get(position).getAddress());
                empcodePopup.setText(responseModel.getSuccess().get(position).getEmpcode());

                Glide
                        .with(context)
                        .load(responseModel.getSuccess().get(position).getImage())
                        .into(dp);






                dialogBuilder.setTitle("Details");
                dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        responseModel.getSuccess().get(position).setName(namePopup.getText().toString());
                        //do something with edt.getText().toString();
                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //pass
                    }
                });
                AlertDialog b = dialogBuilder.create();
                b.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return responseModel.getSuccess().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView name,category;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(CircleImageView) itemView.findViewById(R.id.profile_image);

            name=(TextView) itemView.findViewById(R.id.name);

            category=(TextView) itemView.findViewById(R.id.category);

        }
    }
}
