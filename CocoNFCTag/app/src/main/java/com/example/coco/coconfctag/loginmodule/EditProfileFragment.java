package com.example.coco.coconfctag.loginmodule;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.coco.coconfctag.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by cocoadmin on 4/13/2017.
 */

public class EditProfileFragment extends Fragment {

    private TextView mCountTxtView;
    private TextView mTitleTxtView;
    private ImageView mCartImg;
    private RelativeLayout mSearchLayout;
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;
    private Gson gson;
    private ArrayList<AddressItem> mAddressArray=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getContext().getSharedPreferences("cocosoft", MODE_PRIVATE);
        prefsEditor = prefs.edit();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        init(view);
        setListeners();
        return view;
    }

    private void setListeners() {
    }

    private void init(View view) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mCountTxtView = (TextView) toolbar.findViewById(R.id.total_count);
        mTitleTxtView = (TextView) toolbar.findViewById(R.id.title_txt);
        mCartImg = (ImageView) toolbar.findViewById(R.id.cart_img);
        mSearchLayout = (RelativeLayout) getActivity().findViewById(R.id.search_layout);
        mCountTxtView.setVisibility(View.GONE);
        mCartImg.setVisibility(View.GONE);
        mSearchLayout.setVisibility(View.GONE);
        mTitleTxtView.setText("Profile");
        gson=new Gson();
        saveProfileData();

    }

    private void saveProfileData() {
        String username = prefs.getString("username", null);
        mAddressArray.add(new AddressItem("Arun","8,Xavior Street,Teynampet","Chennai","Chennai","TamilNadu","600006","India","917654564646"));
        mAddressArray.add(new AddressItem("Arun","8,Xavior Street,Teynampet","Chennai","Chennai","TamilNadu","600006","India","917654564646"));
        String json = gson.toJson(mAddressArray);
        prefsEditor.putString("profiledataof"+username, json);
        prefsEditor.commit();
    }

    class AddressItem
    {
        private String name="";
        private String address1="";
        private String address2="";
        private String city="";
        private String state="";
        private String zip="";
        private String country="";
        private String phonenumber="";

        public AddressItem(String name, String address1, String address2, String city, String state, String zip, String country, String phonenumber) {
            this.name = name;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.country = country;
            this.phonenumber = phonenumber;
        }
    }
}
