package com.example.currency.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.currency_flag_list.CurrencyFlagList

class CurrencyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var flagImageView: ImageView = itemView.findViewById(R.id.currency_flag)
    val nameTextView: TextView = itemView.findViewById(R.id.currency_name)
    val codTextView: TextView = itemView.findViewById(R.id.currency_cod)

}