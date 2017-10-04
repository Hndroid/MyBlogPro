package com.test.activitytest;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "测试Activity的生命周期";
    private static final String MY_ACTION = "action.my.dialog.action";
    private static final String MY_CATEGORY = "category.my.dialog.category";
    private Button mButton_Fragment;
    private Button mButton_noFragment;
    private Button mButton_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");

        mButton_Fragment = (Button) findViewById(R.id.dialog_fragment);
        mButton_noFragment = (Button) findViewById(R.id.mbt_no_fragment);
        mButton_Activity = (Button) findViewById(R.id.mbt_activity);
        showFragmentDialog();
        showNoFragmentDialog();
        showActivityDialog();
    }

    public void showActivityDialog(){
        mButton_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MainActivity.MY_ACTION);
                intent.addCategory(MainActivity.MY_CATEGORY);
                startActivity(intent);
            }
        });
    }

    public void showNoFragmentDialog() {
        mButton_noFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("这是一个 Dialog");
                builder.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void showFragmentDialog() {

        mButton_Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = FireMissilesDialogFragment.newInstance("Title");
                dialogFragment.show(getFragmentManager(), "dialog");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


}
