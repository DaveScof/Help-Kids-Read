package com.qenetech.charitywithbooks.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qenetech.charitywithbooks.R;
import com.qenetech.charitywithbooks.base.BaseActivity;
import com.qenetech.charitywithbooks.database.Database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by davescof on 3/15/17.
 */

public class RegisterActivity extends BaseActivity {


    private static final String DIALOG_CONFIRM_PHONE = "Confirm Phone Dialog";
    private EditText mFullNameInput;
    private EditText mEmailInput;
    private EditText mPasswordInput;

    private Button mRegisterButton;
    private Database.DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Create an instance of the DatabaseHelper class
        mHelper = Database.getInstance();

        mFullNameInput = (EditText) findViewById(R.id.register_full_name_input);
        mEmailInput = (EditText) findViewById(R.id.register_email_input);
        mPasswordInput = getEd(R.id.register_password_input);

        mRegisterButton = (Button) findViewById(R.id.button_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Register when user clicks Go on PhoneNumber keyboard
        mPasswordInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                mRegisterButton.callOnClick();
                return false;
            }
        });
    }

    private void login (){
        // Retrieve all inputs
        String firstName = mFullNameInput.getText().toString().trim();
        String email = mEmailInput.getText().toString().trim();
        String password = mPasswordInput.getText().toString().trim();


        // Validate Full Name
        if (TextUtils.isEmpty(firstName)) {
            mFullNameInput.setError("Please enter your full name");
            mFullNameInput.requestFocus();
            return;
        }

        // Validate Email or Phone
        if (TextUtils.isEmpty(email)) {
            mEmailInput.setError("Please enter your email or phone");
            mEmailInput.requestFocus();
            return;
        }

        // Validate Phone Number
        if (TextUtils.isEmpty(password)) {
            mPasswordInput.setError("Please enter your phone number");
            mPasswordInput.requestFocus();
            return;
        }
        
//        boolean inserted = mHelper.createUser(firstName, lastName ,email, phoneNumber);
//        if (inserted) {
//            toast("Registered");
//            confirmRegistration();
//        } else {
//            toast("Registration failed!");
//        }
        toast("Registered");
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

//    private void confirmRegistration (){
//        ConfirmDialog confirmDialog = ConfirmDialog.newInstance(mPhoneNumberInput.getText().toString());
//        confirmDialog.show(getSupportFragmentManager(), DIALOG_CONFIRM_PHONE);
//    }

}
