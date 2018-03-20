package br.com.heiderlopes.roomkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mWords: List<Word>? = null

    class WordViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = mWords!![position]
        holder.wordItemView.text = current.word
    }

    internal fun setWords(words: List<Word>?) {
        mWords = words
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mWords != null)
            mWords!!.size
        else
            0
    }
}
