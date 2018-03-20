package br.com.heiderlopes.roomkotlin

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class WordRepository

internal constructor(application: Application) {

    private val mWordDao: WordDao
    internal val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        mWordDao = db!!.wordDao()
        allWords = mWordDao.alphabetizedWords
    }

    fun insert(word: Word) {
        insertAsyncTask(mWordDao).execute(word)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: WordDao) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}