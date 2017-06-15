package com.example.coco.coconfctag.adminmodule;
/**
 * Created by cocoadmin on 3/20/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coco.coconfctag.R;
import com.example.coco.coconfctag.cartmodule.CartItem;
import com.example.coco.coconfctag.database.DatabaseHandler;
import com.example.coco.coconfctag.listeners.CheckboxListener;
import com.example.coco.coconfctag.listeners.IndividualItemListener;
import com.example.coco.coconfctag.listeners.QuantityListener;
import com.example.coco.coconfctag.listeners.WishlistListener;
import com.example.coco.coconfctag.loginmodule.User;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.MyViewHolders> {


    private ArrayList<User> productList;
    private Context context;

    public class MyViewHolders extends RecyclerView.ViewHolder {
        public TextView userName;
        public TextView userEmail;
        public MyViewHolders(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.name_txt);
            userEmail = (TextView) view.findViewById(R.id.email_txt);
        }
    }


    public AllUsersAdapter(Context c, ArrayList<User> list) {
        this.productList = list;
        this.context = c;

    }


    @Override
    public MyViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_allusers_item, parent, false);

        return new MyViewHolders(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolders holder, final int position) {

        holder.userName.setText(productList.get(position).getFirstName()+" "+productList.get(position).getLastName());
        holder.userEmail.setText(productList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}