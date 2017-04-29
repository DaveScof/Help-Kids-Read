package com.qenetech.charitywithbooks.base;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public abstract class BaseScreen extends Fragment {

    public View mRoot;

    public View getView(int id) {
        return mRoot.findViewById(id);
    }

    public BaseActivity getParent() {
        return (BaseActivity) getActivity();
    }

    public void toast(String message) {
        Toast.makeText(getParent(), message, Toast.LENGTH_SHORT).show();
    }

    public void d(String message) {
        Log.d(BaseActivity.TAG, message);
    }

    public void e(String message) {
        Log.e(BaseActivity.TAG, message);
    }

    public TextView getTv(int res_id) {
        return (TextView) mRoot.findViewById(res_id);
    }

    public TextView getTv(int id, Typeface f){
        TextView t = getTv(id);
        t.setTypeface(f);
        return t;
    }

    public View getView(View root, int res_id) {
        return root.findViewById(res_id);
    }

    public EditText getEd(int res_id) {
        return (EditText) mRoot.findViewById(res_id);
    }

    public EditText getEd(int id, Typeface font){
        EditText ed = getEd(id);
        ed.setTypeface(font);
        return ed;
    }

    public ImageView getIm(View root, int res_id) {
        return (ImageView) root.findViewById(res_id);
    }

    public Button getBt(int id) {
        return (Button) mRoot.findViewById(id);
    }

    public Button getBt(int id, Typeface f){
        Button b = getBt(id);
        b.setTypeface(f);
        return b;
    }

    public Spinner getSp (int id){
        return (Spinner) mRoot.findViewById(id);
    }
}
