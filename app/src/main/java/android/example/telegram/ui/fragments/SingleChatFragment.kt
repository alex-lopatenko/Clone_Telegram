package android.example.telegram.ui.fragments

import android.example.telegram.R
import android.example.telegram.models.CommonModel
import android.example.telegram.utilits.APP_ACTIVITY
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*


class SingleChatFragment(contact: CommonModel) : BaseFragment(R.layout.fragment_single_chat) {


    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.mToolbar.toolbar_info.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
    }
}