package com.example.currency.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.currency.R
import com.example.currency.currency_extention.stringRes
import com.example.currency.currencн.CurrencyFlagList

class CurrencyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

   private var flagImageView: ImageView = itemView.findViewById(R.id.currency_flag)
   private val nameTextView: TextView = itemView.findViewById(R.id.currency_name)
   private val codTextView: TextView = itemView.findViewById(R.id.currency_cod)
        fun bind (currency: CurrencyFlagList) {

            val stringResId = currency.stringRes()
            val flagUrl = "https://github.com/Lissy93/currency-flags/blob/master/assets/flags_png_rectangle/${currency.name.lowercase()}.png?raw=true"

            flagImageView.load(flagUrl)
            nameTextView.setText(stringResId)
            codTextView.text = currency.name
        }
}