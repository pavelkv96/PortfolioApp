package com.github.pavelkv96.portfolioapp.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.pavelkv96.portfolioapp.R

class TeamFragment : Fragment() {
    var teamList: RecyclerView? = null
    var teamAdapter: TeamAdapter? = null
    var teamData: MutableList<TeamItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamData = mutableListOf()
        teamData?.apply {
            add(TeamItem("Jhon Doe", getString(R.string.lorem_text2), R.drawable.user))
            add(TeamItem("Ahmed Ali", getString(R.string.lorem_text2), R.drawable.uservoyager))
            add(TeamItem("Islam Ahmed", getString(R.string.lorem_text2), R.drawable.userspace))
            teamAdapter = TeamAdapter(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamList = view.findViewById(R.id.rv_team)

        teamList?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): TeamFragment = TeamFragment().also { it.arguments = Bundle().apply {  } }
    }
}