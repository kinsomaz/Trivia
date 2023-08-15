@file:Suppress("DEPRECATION")

package com.samad.trivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.samad.trivia.R.*
import com.samad.trivia.databinding.ActivityMainBinding
import com.samad.trivia.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, layout.fragment_title, container, false)
        val view = binding.root

        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            //Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }
        drawerLayout = (activity as MainActivity).findViewById<DrawerLayout>(R.id.drawerLayout)
        navView = (activity as MainActivity).findViewById<NavigationView>(R.id.navView)
        val navController = (activity as MainActivity).findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(activity as MainActivity,navController,drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}
