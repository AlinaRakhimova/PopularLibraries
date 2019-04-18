package com.example.myapplication.moxy.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.moxy.model.WordModel;
import com.example.myapplication.moxy.view.MoxyMainView;

@InjectViewState
public class MoxyMainPresenter extends MvpPresenter<MoxyMainView> {

    private WordModel wordModel;
    private String newWord;

    public MoxyMainPresenter() {
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
        getViewState().updateWords(newWord);
    }

}
