package android.example.telegram

import android.content.Intent
import android.example.telegram.activities.RegisterActivity
import android.example.telegram.databinding.ActivityMainBinding
import android.example.telegram.ui.fragments.ChatsFragment
import android.example.telegram.ui.objects.AppDrawer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (false) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            supportFragmentManager.beginTransaction()
                .replace(R.id.dataContainer, ChatsFragment()).commit()
        } else {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }



    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }
}