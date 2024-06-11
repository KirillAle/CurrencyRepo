package com.example.currency.dependency_provider

import android.content.Context
import android.content.SharedPreferences
import com.example.currency.view_model.SelectCurrencyViewModel

object CurrencyListFragmentDependencyProvider {

    fun provideSelectCurrencyViewModel(): SelectCurrencyViewModel{
        return SelectCurrencyViewModel()
    }
    fun provideSharedPreferences(context: Context): SharedPreferences =
    context.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE)
}