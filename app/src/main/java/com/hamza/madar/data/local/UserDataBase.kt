package com.hamza.madar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamza.madar.domain.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
