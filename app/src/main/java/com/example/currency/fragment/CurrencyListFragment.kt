package com.example.currency.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.MainActivity
import com.example.currency.R
import com.example.currency.adapter.CurrencyAdapter
import com.example.currency.currency_cod.CurrencyCod
import com.example.currency.view_model.SelectCurrencyViewModel

class CurrencyListFragment() : Fragment(R.layout.fragment_currency_list) {

    val OUT_KEY = "out key"
    private val viewModel: SelectCurrencyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val layoutManager = LinearLayoutManager(context)
    private val adapter: (CurrencyCod) -> Unit = { currencyCod ->
        viewModel.setSelectedCurrency(currencyCod)
        saveCurrencyOut()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.currency_list_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = CurrencyAdapter(adapter)


        val argument = arguments?.getString(OUT_KEY)

        when (argument) {
            InOutCurrencyType.OUT.name -> saveCurrencyOut()
            InOutCurrencyType.IN.name -> saveCurrencyIn()
        }
    }

    private fun handleCurrencyItemClick(currency: CurrencyCod) {
        viewModel.setSelectedCurrency(currency)
    }

    fun saveCurrencyIn() {
        val selectedCurrencyIn = viewModel.getSelectedCurrency()
        val sharedPreferencesIn =
            activity?.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE) ?: return
        sharedPreferencesIn
            .edit()
            .putString("selected_currencyIn", selectedCurrencyIn.name)
            .apply()
        println(selectedCurrencyIn)
    }

    fun saveCurrencyOut() {
        val selectedCurrencyOut = viewModel.getSelectedCurrency()
        val sharedPreferencesOut =
            activity?.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE) ?: return
        sharedPreferencesOut
            .edit()
            .putString("selected_currencyOut", selectedCurrencyOut.name)
            .apply()
        println(selectedCurrencyOut)
    }

    fun setArgument(arg: String) {
        val args = Bundle()
        args.putString(OUT_KEY, arg)
        arguments = args
    }

    enum class InOutCurrencyType {
        IN,
        OUT;
    }
}
