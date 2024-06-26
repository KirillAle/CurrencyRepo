package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.currency.enum_classes.InOutCurrencyType
import com.example.currency.fragment.CurrencyListFragment

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        val currencyListFragment = CurrencyListFragment.create(InOutCurrencyType.OUT)

        fragmentTransition
            .replace(R.id.currency_list_view_fragment_container, currencyListFragment)
            .commit()
    }
}

