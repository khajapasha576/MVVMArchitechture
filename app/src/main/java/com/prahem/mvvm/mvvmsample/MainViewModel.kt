package com.prahem.mvvm.mvvmsample

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var lst = MutableLiveData<ArrayList<Blog>>()
    var newlist = arrayListOf<Blog>()

    fun add(blog: Blog) {
        newlist.add(blog)
        lst.value = newlist
    }

    fun remove(blog: Blog) {
        newlist.remove(blog)
        lst.value = newlist
    }

    fun displayMessage(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}