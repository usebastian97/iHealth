package usg.ihealth.ui.fragments.notes

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import usg.ihealth.ui.fragments.notes.database.NotesDataBase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): NotesDataBase =
        Room.databaseBuilder(context, NotesDataBase::class.java, "notes.db").build()

    @Provides
    fun providesNotesDao(dataBase: NotesDataBase) = dataBase.noteDao()
}