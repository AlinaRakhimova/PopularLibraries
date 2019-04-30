package com.example.myapplication.moxy.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.moxy.presenter.MoxyMainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoxyMoxyMainActivity extends MvpAppCompatActivity implements MoxyMainView {

    @BindView(R.id.send)
    Button send;

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.editText)
    EditText editText;

    @InjectPresenter
    MoxyMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        send.setOnClickListener((v) -> presenter.sendWord(String.valueOf(editText.getText())));
    }

    @Override
    public void updateWords(String word) {
        textView.setText(word);
        editText.setText("");
    }

}
