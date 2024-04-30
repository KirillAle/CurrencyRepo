package com.example.currency.fragment

import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.adapter.CurrencyAdapter
import com.example.currency.currency_cod.CurrencyCod
import com.example.currency.view_model.SelectCurrencyViewModel

class CurrencyListFragment : Fragment(R.layout.fragment_currency_list) {


    private val viewModel: SelectCurrencyViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val layoutManager = LinearLayoutManager(context)
    private val adapter: (CurrencyCod) -> Unit = {currencyCod ->
            viewModel.setSelectedCurrency(currencyCod)
    saveData()
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


    private fun saveData() {
        val selectedCurrency = viewModel.getSelectedCurrency()
        val sharedPreferences = activity?.getSharedPreferences("currency_prefs", Context.MODE_PRIVATE) ?: return
        sharedPreferences
            .edit()
            .putString("selected_currency", selectedCurrency.name)
            .apply()

    }


}
