package br.com.heiderlopes.roomkotlin

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

/**
 * Created by heider on 20/03/18.
 */
class WordViewModel(application: Application) : AndroidViewModel(application) {

    val mRepository: WordRepository = WordRepository(application)
    val allWords: LiveData<List<Word>>

    init {
        allWords = mRepository.allWords
    }

    fun insert(word: Word) {
        mRepository.insert(word)
    }
}