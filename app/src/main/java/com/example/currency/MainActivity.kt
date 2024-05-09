package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.currency.fragment.CurrencyListFragment


class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        val currencyListFragment = CurrencyListFragment()

        currencyListFragment.setArgument(currencyListFragment.OUT_KEY)


        fragmentTransition.replace(R.id.currency_list_view_fragment_container, currencyListFragment)
        fragmentTransition.commit()
    }




}

