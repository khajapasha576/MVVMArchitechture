package com.prahem.mvvm.mvvmsample

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class LoginViewModel : BaseObservable() {
    private val user: User
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    var toastMessage: String? = null
        set(toastMessage) {
            field = toastMessage
            notifyPropertyChanged(BR.toastMessage)
        }

    @get:Bindable
    var userEmail: String?
        get() = user.email
        set(email) {
            user.email = email
            notifyPropertyChanged(BR.userEmail)
        }

    @get:Bindable
    var userPassword: String?
        get() = user.password
        set(password) {
            user.password = password
            notifyPropertyChanged(BR.userPassword)
        }

    fun onLoginClicked() {
        toastMessage = if (isInputDataValid) successMessage else errorMessage
    }

    val isInputDataValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && userPassword!!.length > 5

    init {
        user = User("", "")
    }
}