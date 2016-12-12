package com.android.advance.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.advance.R;
import com.android.advance.interfaces.MainActivityView;
import com.android.advance.model.TypeList;
import com.android.advance.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private ProgressBar progressBar;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getIpInformation();
            }
        });

    }

    @Override
    public void showIpInfo(TypeList typeList) {

        // here your data will be arrived
        Log.d("Type", typeList.getStatus()+"");
        for (int i=0;i<typeList.getUserTypeList().size();i++){
            //you have to cast your type
            //for patient
            Log.d("Patient", (String) typeList.getUserTypeList().get(i).get(0));
            //for id
            Log.d("Id", ""+(typeList.getUserTypeList().get(i).get(1)));


        }

    }

    @Override
    public void startLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

}
