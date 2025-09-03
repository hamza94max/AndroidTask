package com.hamza.madar.domain.repo

import com.hamza.madar.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepo {

    suspend fun addUserToDB(user: User)

    fun getAllUsers(): Flow<List<User>>




}