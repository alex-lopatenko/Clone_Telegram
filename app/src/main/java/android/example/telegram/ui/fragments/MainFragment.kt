package android.example.telegram.ui.fragments

import android.example.telegram.R
import android.example.telegram.databinding.FragmentChatsBinding
import android.example.telegram.utilits.APP_ACTIVITY
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Telegram"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
    }
}