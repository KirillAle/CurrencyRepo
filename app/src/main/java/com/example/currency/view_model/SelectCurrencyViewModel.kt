package com.example.currency.view_model

import androidx.lifecycle.ViewModel
import com.example.currency.currency_cod.CurrencyCod


class SelectCurrencyViewModel() : ViewModel() {
    private var selectedCurrency: String = ""
    fun setSelectedCurrency(currencyCod: CurrencyCod) {
        selectedCurrency = currencyCod.toString()
    }
}
