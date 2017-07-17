package com.example.alphonso.alphonso2017summer.dialog;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.alphonso.alphonso2017summer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Alphonso on 6/21/2017.
 */

public class CustomDialog extends Dialog{


    private final ICustomDialogListner listner;

    public interface ICustomDialogListner{
        public void onOKClicked(String msg);
    }

    @OnClick(R.id.dialog_custom_bt)
    public void ok(View view){
        listner.onOKClicked("You Clicked OK");
        cancel();
    }

    public CustomDialog(@NonNull Context context, ICustomDialogListner listner) {
        super(context,R.style.dialog);
        setContentView(R.layout.dialogcustom);
        ButterKnife.bind(this);
        this.listner = listner;

    }
}
