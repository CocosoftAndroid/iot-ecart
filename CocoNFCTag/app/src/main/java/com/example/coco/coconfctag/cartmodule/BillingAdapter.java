package com.example.coco.coconfctag.cartmodule;
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
import com.example.coco.coconfctag.database.DatabaseHandler;
import com.example.coco.coconfctag.listeners.CheckboxListener;
import com.example.coco.coconfctag.listeners.IndividualItemListener;
import com.example.coco.coconfctag.listeners.QuantityListener;
import com.example.coco.coconfctag.listeners.WishlistListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class BillingAdapter extends RecyclerView.Adapter<BillingAdapter.MyViewHolders> {



    private ArrayList<CartItem> productList;
    private Context context;

    public class MyViewHolders extends RecyclerView.ViewHolder {
        public TextView productName, productPrice, count;



        public MyViewHolders(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.name);
            productPrice = (TextView) view.findViewById(R.id.price);
            count = (TextView) view.findViewById(R.id.quantity);

        }
    }


    public BillingAdapter(Context c, ArrayList<CartItem> list) {
        this.productList = list;
        this.context = c;


    }


    @Override
    public MyViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_billing_item, parent, false);

        return new MyViewHolders(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolders holder, final int position) {

        holder.productName.setText(productList.get(position).getProductId() + " - " + productList.get(position).getProductName());
        holder.count.setText("" + productList.get(position).getCount());
        holder.productPrice.setText("$ " + productList.get(position).getProductPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}