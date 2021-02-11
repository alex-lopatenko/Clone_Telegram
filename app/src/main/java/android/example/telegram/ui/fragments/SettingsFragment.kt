package android.example.telegram.ui.fragments

import android.example.telegram.MainActivity
import android.example.telegram.R
import android.example.telegram.activities.RegisterActivity
import android.example.telegram.utilits.AUTH
import android.example.telegram.utilits.replaceActivity
import android.example.telegram.utilits.replaceFragment
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
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}