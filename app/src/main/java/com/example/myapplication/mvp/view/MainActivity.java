package com.example.myapplication.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.mvp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.send)
    Button send;

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.editText)
    EditText editText;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createPresenter();
        initUI();
    }

    private void initUI() {
        send.setOnClickListener((v) -> presenter.sendWord(String.valueOf(editText.getText())));
    }

    private void createPresenter() {
        presenter = new MainPresenter(this);
    }

    @Override
    public void updateWords(String word) {
        textView.setText(word);
        editText.setText("");
    }

}
