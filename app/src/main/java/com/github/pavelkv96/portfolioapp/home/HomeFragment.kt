package com.github.pavelkv96.portfolioapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.pavelkv96.portfolioapp.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment = HomeFragment().also { it.arguments = Bundle().apply { } }
    }
}