package com.example.fashionapp.ui.fashion.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.fashionapp.R
import com.example.fashionapp.databinding.FragmentShopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment: Fragment() {
    lateinit var databinding: FragmentShopBinding
    val viewmodel by viewModels<ShopViewmodel> ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = FragmentShopBinding.inflate(inflater, container, false)
        return databinding.root
    }


}