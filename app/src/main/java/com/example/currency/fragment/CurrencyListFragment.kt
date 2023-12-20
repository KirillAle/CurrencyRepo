package com.example.currency.fragment

import android.os.Bundle
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
    private val adapter = CurrencyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.currency_list_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun handleCurrencyItemClick(currency: CurrencyCod) {
        viewModel.setSelectedCurrency(currency)
    }

}
