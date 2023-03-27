package usg.ihealth.ui.fragments.notes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import usg.ihealth.ui.fragments.notes.dao.NoteDao
import usg.ihealth.ui.fragments.notes.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}