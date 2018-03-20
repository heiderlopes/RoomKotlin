package br.com.heiderlopes.roomkotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_new_word.*

class NewWordActivity : AppCompatActivity() {

    private var mEditWordView: EditText? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        mEditWordView = findViewById(R.id.edit_word)

        button_save.setOnClickListener({
            val replyIntent = Intent()
            if (TextUtils.isEmpty(mEditWordView!!.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = mEditWordView!!.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        })
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}

