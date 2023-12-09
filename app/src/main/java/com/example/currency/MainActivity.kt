package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import com.example.currency.adapret.CurrencyAdapter
import com.example.currency.currency_flag_list.CurrencyFlagList
import com.example.currency.fragment.CurrencyListFragment


class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

