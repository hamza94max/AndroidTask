package com.hamza.madar.data.repoImpl

import com.hamza.madar.data.local.UserDao
import com.hamza.madar.domain.models.User
import com.hamza.madar.domain.repo.UserRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepo {

    override suspend fun addUserToDB(user: User) {
        userDao.insertUser(user)
    }

    override fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()


}