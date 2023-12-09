package com.example.currency.adapret

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.currency.R
import com.example.currency.currency_extention.stringRes
import com.example.currency.currency_flag_list.CurrencyFlagList
import com.example.currency.view_holder.CurrencyViewHolder

class CurrencyAdapter: RecyclerView.Adapter<CurrencyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item,parent,false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return CurrencyFlagList.asList.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = CurrencyFlagList.asList[position]
        val stringResId = currency.stringRes()

        val flagUrl = "https://raw.githubusercontent.com/Lissy93/currency-flags/master/assets/flags_png_rectangle/${currency.name.lowercase()}.png"

        holder.flagImageView.load(flagUrl)
        holder.nameTextView.setText(stringResId)
        holder.codTextView.text = currency.name
    }
}