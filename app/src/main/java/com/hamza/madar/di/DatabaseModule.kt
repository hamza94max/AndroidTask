package com.hamza.madar.di

import android.content.Context
import androidx.room.Room
import com.hamza.madar.data.local.UserDao
import com.hamza.madar.data.local.UserDataBase
import com.hamza.madar.data.repoImpl.UserRepoImpl
import com.hamza.madar.domain.repo.UserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Provides
    @Singleton
    fun provideUsersDatabase(@ApplicationContext context: Context): UserDataBase {
        return Room.databaseBuilder(
            context,
            UserDataBase::class.java,
            "users_db"
        ).build()
    }

    @Provides
    fun provideUserDao(db: UserDataBase): UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideUsersRepository(userDao: UserDao): UserRepo {
        return UserRepoImpl(userDao)
    }


}