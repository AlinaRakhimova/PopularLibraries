package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvp.model.WordModel;
import com.example.myapplication.mvp.view.MainView;

public class MainPresenter {

    private MainView mainView;
    private WordModel wordModel;
    private String newWord;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        wordModel = new WordModel();
    }

    public void sendWord(String word) {
        String oldWord = wordModel.getWord();
        if (oldWord != null) {
            newWord = oldWord + word;
        } else newWord = word;
        wordModel.setWord(newWord);
        updateWords();
    }

    private void updateWords() {
        mainView.updateWords(newWord);
    }

}
