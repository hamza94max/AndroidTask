package com.hamza.madar.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hamza.madar.domain.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): Flow<List<User>>
}
