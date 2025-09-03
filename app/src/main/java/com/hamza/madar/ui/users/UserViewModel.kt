package com.hamza.madar.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.madar.domain.models.User
import com.hamza.madar.domain.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepo
) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.addUserToDB(user)
        }
    }

    val users = userRepository.getAllUsers()
}
