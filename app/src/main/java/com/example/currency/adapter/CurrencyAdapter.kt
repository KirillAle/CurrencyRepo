package com.example.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.clicker.OnCurrencyClickListener
import com.example.currency.currency_cod.CurrencyCod
import com.example.currency.view_holder.CurrencyViewHolder

class CurrencyAdapter(private val listener: OnCurrencyClickListener): RecyclerView.Adapter<CurrencyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item,parent,false)
        return CurrencyViewHolder(listener,view)
    }

    override fun getItemCount(): Int {
        return CurrencyCod.asList.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = CurrencyCod.asList[position]
        holder.bind(currency)
    }
}