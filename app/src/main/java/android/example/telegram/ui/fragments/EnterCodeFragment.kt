package android.example.telegram.ui.fragments

import android.example.telegram.R
import android.example.telegram.utilits.AppTextWatcher
import android.example.telegram.utilits.showToast
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_code.*


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                verifiCode()
            }
        })
    }

    fun verifiCode() {
        showToast("Ok")
    }
}