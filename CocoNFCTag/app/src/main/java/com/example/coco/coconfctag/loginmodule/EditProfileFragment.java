package com.example.coco.coconfctag.loginmodule;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coco.coconfctag.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by cocoadmin on 4/13/2017.
 */

public class EditProfileFragment extends Fragment implements View.OnClickListener {

    private TextView mCountTxtView;
    private TextView mTitleTxtView, mSaveTxt;
    private ImageView mCartImg;
    private RelativeLayout mSearchLayout;
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEditor;
    private Gson gson;
    private AppCompatCheckBox mCheckBox;
    private ArrayList<AddressItem> mAddressArray = new ArrayList<>();
    private EditText mNameTxt, mAddress1Txt, mAddress2Txt, mCityTxt, mStateTxt, mZipTxt, mPhoneNoTxt, mCNameTxt, mCAddress1Txt, mCAddress2Txt, mCCityTxt, mCStateTxt, mCZipTxt, mCPhoneNoTxt;

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
        mSaveTxt.setOnClickListener(this);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                     switch (buttonView.getId()) {
                                                         case R.id.checkbox:
                                                             mNameTxt.setText(mCNameTxt.getText().toString().trim());
                                                             mAddress1Txt.setText(mCAddress1Txt.getText().toString().trim());
                                                             mAddress2Txt.setText(mCAddress2Txt.getText().toString().trim());
                                                             mCityTxt.setText(mCCityTxt.getText().toString().trim());
                                                             mZipTxt.setText(mCZipTxt.getText().toString().trim());
                                                             mStateTxt.setText(mCStateTxt.getText().toString().trim());
                                                             mPhoneNoTxt.setText(mCPhoneNoTxt.getText().toString().trim());
                                                             break;
                                                     }
                                                 }
                                             }
        );
    }

    private void init(View view) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mCountTxtView = (TextView) toolbar.findViewById(R.id.total_count);
        mTitleTxtView = (TextView) toolbar.findViewById(R.id.title_txt);
        mSaveTxt = (TextView) view.findViewById(R.id.save_txt);
        mCheckBox = (AppCompatCheckBox) view.findViewById(R.id.checkbox);
        mNameTxt = (EditText) view.findViewById(R.id.ship_adr_name);
        mAddress1Txt = (EditText) view.findViewById(R.id.ship_adr_address1);
        mAddress2Txt = (EditText) view.findViewById(R.id.ship_adr_address2);
        mCityTxt = (EditText) view.findViewById(R.id.ship_adr_city);
        mStateTxt = (EditText) view.findViewById(R.id.ship_adr_state);
        mZipTxt = (EditText) view.findViewById(R.id.ship_adr_zip);
        mPhoneNoTxt = (EditText) view.findViewById(R.id.ship_adr_phoneno);
        mCNameTxt = (EditText) view.findViewById(R.id.cname_txt);
        mCAddress1Txt = (EditText) view.findViewById(R.id.caddr1_txt);
        mCAddress2Txt = (EditText) view.findViewById(R.id.caddr2_txt);
        mCCityTxt = (EditText) view.findViewById(R.id.ccity_txt);
        mCStateTxt = (EditText) view.findViewById(R.id.cstate_txt);
        mCZipTxt = (EditText) view.findViewById(R.id.czip_txt);
        mCPhoneNoTxt = (EditText) view.findViewById(R.id.cphno_txt);
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
        mAddressArray.add(new AddressItem(mNameTxt.getText().toString().trim(), mAddress1Txt.getText().toString().trim() + " " + mAddress2Txt.getText().toString().trim(), "Chennai", mCityTxt.getText().toString().trim(), mStateTxt.getText().toString().trim(), mZipTxt.getText().toString().trim(), "India", mPhoneNoTxt.getText().toString().trim()));
        String json = gson.toJson(mAddressArray);
        prefsEditor.putString("profiledataof"+username, json);
        prefsEditor.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save_txt:
                saveProfileData();
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class AddressItem {
        private String name = "";
        private String address1 = "";
        private String address2 = "";
        private String city = "";
        private String state = "";
        private String zip = "";
        private String country = "";
        private String phonenumber = "";

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        @Override
        public String toString() {
            return "" + name +
                    "," + address1 +
                    "," + address2 +
                    "," + city +
                    "," + state +
                    "," + zip +
                    "," + country +
                    ", " + phonenumber;
        }
    }
}
