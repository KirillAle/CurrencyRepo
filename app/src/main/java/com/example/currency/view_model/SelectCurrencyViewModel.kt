package com.example.currency.view_model

import androidx.lifecycle.ViewModel
import com.example.currency.currency_cod.CurrencyCod

class SelectCurrencyViewModel() : ViewModel() {

    private lateinit var currencyCod: CurrencyCod
    fun setSelectedCurrency(currencyCod: CurrencyCod) {
       this.currencyCod = currencyCod
        println(currencyCod)
    }
}
