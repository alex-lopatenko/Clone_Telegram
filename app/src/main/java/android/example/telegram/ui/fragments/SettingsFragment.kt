package android.example.telegram.ui.fragments

import android.example.telegram.MainActivity
import android.example.telegram.R
import android.example.telegram.activities.RegisterActivity
import android.example.telegram.utilits.AUTH
import android.example.telegram.utilits.replaceActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }
}