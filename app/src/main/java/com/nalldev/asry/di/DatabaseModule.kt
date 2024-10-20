package com.nalldev.asry.di

import android.content.Context
import androidx.room.Room
import com.nalldev.asry.data.datasource.local.StoryDao
import com.nalldev.asry.data.datasource.local.StoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): StoryDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            StoryDatabase::class.java,
            "story_database"
        ).build()
    }

    @Provides
    fun provideStoryDao(storyDatabase: StoryDatabase): StoryDao {
        return storyDatabase.storyDao()
    }
}