package android.example.telegram.ui.fragments

import android.example.telegram.MainActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.example.telegram.R
import android.example.telegram.utilits.APP_ACTIVITY
import android.view.*


open class BaseChangeFragment (layout:Int): Fragment(layout) {

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        (activity as MainActivity).mAppDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        APP_ACTIVITY.hideKeyboard()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_confirm_change -> change()
        }
        return true
    }

    open fun change() {
        TODO("Not yet implemented")
    }
}