package com.example.currency.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.currency.R
import com.example.currency.clicker.OnCurrencyClickListener
import com.example.currency.currency_extention.stringRes
import com.example.currency.currency_cod.CurrencyCod
import com.example.currency.view_model.SelectCurrencyViewModel

class CurrencyViewHolder(private val listener: OnCurrencyClickListener, itemView: View) : RecyclerView.ViewHolder(itemView) {


    var flagImageView: ImageView = itemView.findViewById(R.id.currency_flag)
    private val nameTextView: TextView = itemView.findViewById(R.id.currency_name)
    private val codTextView: TextView = itemView.findViewById(R.id.currency_cod)


    fun bind(currency: CurrencyCod) {

        val stringResId = currency.stringRes()


        flagImageView.load(currency.flagUrl)
        nameTextView.setText(stringResId)
        codTextView.text = currency.name

        itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View) {
                listener.onCurrencyClick(currency)
            }
        })

    }
}


