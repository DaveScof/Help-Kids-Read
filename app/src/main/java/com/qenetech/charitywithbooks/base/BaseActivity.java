package com.qenetech.charitywithbooks.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qenetech.charitywithbooks.utils.Utils;

import java.util.Locale;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d("<============================= onCreate(Bundle) =============================>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("<================================= onStop() =================================>");
    }

    public TextView getTv(int id) {
        return (TextView) findViewById(id);
    }

    public TextView getTv(int id, View v) {
        return (TextView) v.findViewById(id);
    }

    public TextView getTv(int id, Typeface font) {
        TextView tv =  (TextView) findViewById(id);
        tv.setTypeface(font);
        return tv;
    }

    public Button getBt(int id) {
        return (Button) findViewById(id);
    }

    public Button getBt(int id, Typeface f){
        Button b = getBt(id);
        b.setTypeface(f);
        return b;
    }

    public EditText getEd(int id) {
        return (EditText) findViewById(id);
    }

    public EditText getEd(int id, Typeface font){
        EditText ed = getEd(id);
        ed.setTypeface(font);
        return ed;
    }

    public ImageView getIm(int id) {
        return (ImageView) findViewById(id);
    }

    public View getView(int id) {
        return findViewById(id);
    }

    public void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void d(String message) {
        Utils.d(this, String.format(Locale.getDefault(), "%s : %s", this, message));
    }

    public void e(String message) {
        Utils.e(this, String.format(Locale.getDefault(), "%s : %s", this, message));
    }

    public int getColorValue(int id) {
        return ContextCompat.getColor(getApplicationContext(), id);
    }
}