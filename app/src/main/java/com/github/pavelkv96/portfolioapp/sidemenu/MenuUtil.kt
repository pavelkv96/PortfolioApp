package com.github.pavelkv96.portfolioapp.sidemenu

import com.github.pavelkv96.portfolioapp.R

object MenuUtil {
    const val HOME_FRAGMENT_CODE = 0
    const val CV_FRAGMENT_CODE = 1
    const val PORTFOLIO_FRAGMENT_CODE = 2
    const val TEAM_FRAGMENT_CODE = 3

    // first menu item is selected
    @JvmStatic
    fun getMenuList(): List<MenuItem> {
        return mutableListOf<MenuItem>().apply {
            add(MenuItem(R.drawable.ic_baseline_home_24, HOME_FRAGMENT_CODE, true))
            add(MenuItem(R.drawable.ic_baseline_school_24, CV_FRAGMENT_CODE, false))
            add(MenuItem(R.drawable.ic_baseline_group_24, TEAM_FRAGMENT_CODE, false))
            add(MenuItem(R.drawable.ic_baseline_dashboard_24, PORTFOLIO_FRAGMENT_CODE, false))
        }
    }
}