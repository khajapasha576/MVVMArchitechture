package com.prahem.mvvm.mvvmsample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.prahem.mvvm.mvvmsample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var activity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activity.viewModel = LoginViewModel()
        activity.executePendingBindings()

    }


}

@BindingAdapter("toastMessage")
fun runMe(view: View, message: String?) {
    if (message != null) Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show()
}