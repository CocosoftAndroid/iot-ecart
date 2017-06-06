package com.example.coco.coconfctag.loginmodule;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coco.coconfctag.R;
import com.example.coco.coconfctag.common.MonthYearPickerDialog;
import com.example.coco.coconfctag.database.DatabaseHandler;

/**
 * Created by cocoadmin on 3/16/2017.
 */

public class SignupFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private EditText mUserNameEdtTxt;
    private EditText mPwdEdtTxt;
    private EditText mConfirmPwdEdtTxt,mEmailEdtText;
    private TextView mSignupTxt, mWarnTxt, mDOBTxt;
    private DatabaseHandler mDB;

    private TextView mCountTxtView;
    private TextView mTitleTxtView;
    private ImageView mCartImg;
    private RelativeLayout mSearchLayout;
    private String mUserType="user";
    private RadioGroup mRadioGroup1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        init(v);
        setListeners();
        return v;
    }

    private void setListeners() {
        mSignupTxt.setOnClickListener(this);
        mDOBTxt.setOnClickListener(this);
        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.user_radio_btn)
                {
                    mUserType="user";
                }
                else if(checkedId==R.id.admin_radio_btn)
                {
                    mUserType="admin";
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mTitleTxtView.setText("SignUp");
    }
    private void init(View v) {
        mUserNameEdtTxt = (EditText) v.findViewById(R.id.username_etxt);
        mPwdEdtTxt = (EditText) v.findViewById(R.id.pwd_etxt);
        mEmailEdtText = (EditText) v.findViewById(R.id.email_txt);
        mConfirmPwdEdtTxt = (EditText) v.findViewById(R.id.confirm_pwd_etxt);
        mSignupTxt = (TextView) v.findViewById(R.id.finish_signup_txt);
        mWarnTxt = (TextView) v.findViewById(R.id.warning_txt);
        mDOBTxt = (TextView) v.findViewById(R.id.dob_txt);
        mDB = new DatabaseHandler(getContext());
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        mCountTxtView = (TextView) toolbar.findViewById(R.id.total_count);
        mTitleTxtView = (TextView) toolbar.findViewById(R.id.title_txt);
        mCartImg = (ImageView) toolbar.findViewById(R.id.cart_img);
        mCountTxtView.setVisibility(View.GONE);
        mCartImg.setVisibility(View.GONE);
        mSearchLayout = (RelativeLayout) getActivity().findViewById(R.id.search_layout);
        mSearchLayout.setVisibility(View.GONE);
        mRadioGroup1=(RadioGroup)v.findViewById(R.id.radioGroup1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish_signup_txt:
                doSignup();
                break;
            case R.id.dob_txt:
                MonthYearPickerDialog pd = new MonthYearPickerDialog();
                pd.setListener(this);
                pd.show(getFragmentManager(), "MonthYearPickerDialog");
                break;
        }
    }

    private void doSignup() {
        if (mUserNameEdtTxt.getText().toString().trim().length() == 0) {
            mWarnTxt.setVisibility(View.VISIBLE);
            mWarnTxt.setText("Please enter a valid Username");
        } else if (mDB.getUserItem(mUserNameEdtTxt.getText().toString().trim()) != null) {
            mWarnTxt.setVisibility(View.VISIBLE);
            mWarnTxt.setText("This username not available");
        } else if (mPwdEdtTxt.getText().toString().trim().length() == 0 || mConfirmPwdEdtTxt.getText().toString().trim().length() == 0) {
            mWarnTxt.setVisibility(View.VISIBLE);
            mWarnTxt.setText("Please enter a valid Password");
        } else if (!(mPwdEdtTxt.getText().toString().trim().equals(mConfirmPwdEdtTxt.getText().toString().trim()))) {
            mWarnTxt.setVisibility(View.VISIBLE);
            mWarnTxt.setText("Passwords do not match ");
        }else if (isValidEmail(mEmailEdtText.getText().toString())) {
            mWarnTxt.setVisibility(View.VISIBLE);
            mWarnTxt.setText("Passwords do not match ");
        }
        else {
            mDB.addUser(new UserItem("", mUserNameEdtTxt.getText().toString().trim(), mConfirmPwdEdtTxt.getText().toString().trim(),mUserType));
            Toast.makeText(getContext(), "Account Created", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mDOBTxt.setText("" + month + "-" + year);
    }


    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
