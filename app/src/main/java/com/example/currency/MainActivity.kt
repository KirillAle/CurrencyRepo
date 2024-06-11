package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.currency.dependency_provider.CurrencyListFragmentDependencyProvider
import com.example.currency.enum_classes.InOutCurrencyType
import com.example.currency.fragment.CurrencyListFragment

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = CurrencyListFragmentDependencyProvider.provideSelectCurrencyViewModel()
        val sharedPreferences = CurrencyListFragmentDependencyProvider.provideSharedPreferences(this)

//        val fragmentManager = supportFragmentManager
//        val fragmentTransition = fragmentManager.beginTransaction()
        val currencyListFragment = CurrencyListFragment.create(InOutCurrencyType.IN, viewModel, sharedPreferences)

//        fragmentTransition
//            .replace(R.id.currency_list_view_fragment_container, currencyListFragment)
//            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.currency_list_view_fragment_container, currencyListFragment)
            .commit()
    }
}

