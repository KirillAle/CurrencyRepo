package com.example.currency.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.provider.Settings.Global.putString
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.MainActivity
import com.example.currency.R
import com.example.currency.adapter.CurrencyAdapter
import com.example.currency.currency_cod.CurrencyCod
import com.example.currency.enum_classes.InOutCurrencyType
import com.example.currency.view_model.SelectCurrencyViewModel

class CurrencyListFragment(
    private val viewModel: SelectCurrencyViewModel,
    private val sharedPreferences: SharedPreferences
    ): Fragment(R.layout.fragment_currency_list) {

    companion object {
        private const val OUT_KEY = "out key"
        fun create(
            type: InOutCurrencyType,
            viewModel: SelectCurrencyViewModel,
            sharedPreferences: SharedPreferences): Fragment {
            val fragment = CurrencyListFragment(viewModel, sharedPreferences)
            val bundle = Bundle()
            bundle.putString(OUT_KEY, type.name)
            fragment.arguments = bundle
            return fragment
        }
    }

//    private val viewModel: SelectCurrencyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val layoutManager = LinearLayoutManager(context)
    private val adapter: (CurrencyCod) -> Unit = { currencyCod ->
        viewModel.setSelectedCurrency(currencyCod)

        val argument = arguments?.getString(OUT_KEY)
        val inOutCurrencyType = argument?.let { InOutCurrencyType.valueOf(it) }
        if (inOutCurrencyType != null) {
            saveCurrencyInOut(currencyCod, inOutCurrencyType)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.currency_list_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = CurrencyAdapter(adapter)
    }

    private fun handleCurrencyItemClick(currency: CurrencyCod) {
        viewModel.setSelectedCurrency(currency)
    }

    private fun saveCurrencyInOut(
        selectedCurrencyCod: CurrencyCod,
        currencyType: InOutCurrencyType
    ) {

//        val sharedPreferences =
//            activity?.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE) ?: return
        val key = if (currencyType == InOutCurrencyType.IN)
            "selected_currencyIn" else "selected_currencyOut"
        sharedPreferences
            .edit()
            .putString(key, selectedCurrencyCod.name)
            .apply()
    }

}
