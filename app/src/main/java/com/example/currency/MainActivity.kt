package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.adapret.CurrencyAdapter
import com.example.currency.currencн.CurrencyFlagList


class MainActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currency_item_list)

        val recyclerView: RecyclerView = findViewById(R.id.currency_list_view)
        val currencyList: List<CurrencyFlagList> = CurrencyFlagList.asList

        val layoutManager = LinearLayoutManager(this)
        val adapter = CurrencyAdapter()

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter


    }
}

