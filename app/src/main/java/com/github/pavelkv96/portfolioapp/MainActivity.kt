package com.github.pavelkv96.portfolioapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.cv.CVFragment
import com.github.pavelkv96.portfolioapp.home.HomeFragment
import com.github.pavelkv96.portfolioapp.portfolio.PortfolioFragment
import com.github.pavelkv96.portfolioapp.sidemenu.MenuAdapter
import com.github.pavelkv96.portfolioapp.sidemenu.MenuItem
import com.github.pavelkv96.portfolioapp.sidemenu.MenuUtil
import com.github.pavelkv96.portfolioapp.sidemenu.MenuUtil.getMenuList
import com.github.pavelkv96.portfolioapp.team.TeamFragment

class MainActivity : AppCompatActivity(), (Int) -> Unit {
    var menuRv: RecyclerView? = null
    var menuItems: List<MenuItem>? = null
    var menuAdapter: MenuAdapter? = null
    var selectedMenuPos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        menuRv = findViewById(R.id.rv_side_menu)
        menuItems = getMenuList()
        menuAdapter = MenuAdapter(menuItems!!, this)

        menuRv?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = menuAdapter
        }

        invoke(selectedMenuPos)
    }

    override fun invoke(i: Int) {
        val fragment = when (menuItems!![i].code) {
            MenuUtil.HOME_FRAGMENT_CODE -> HomeFragment.newInstance()
            MenuUtil.CV_FRAGMENT_CODE -> CVFragment.newInstance()
            MenuUtil.TEAM_FRAGMENT_CODE -> TeamFragment.newInstance()
            MenuUtil.PORTFOLIO_FRAGMENT_CODE -> PortfolioFragment.newInstance()
            else -> HomeFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()

        menuItems!![selectedMenuPos].isSelected = false
        menuItems!![i].isSelected = true
        selectedMenuPos = i
        menuAdapter!!.notifyDataSetChanged()
    }
}