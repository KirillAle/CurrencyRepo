package com.example.currency.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.adapret.CurrencyAdapter

class CurrencyListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView


    private val layoutManager = LinearLayoutManager(context)
    private val adapter = CurrencyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.currency_list_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
