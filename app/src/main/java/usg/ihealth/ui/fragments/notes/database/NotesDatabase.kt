package usg.ihealth.ui.fragments.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import usg.ihealth.ui.fragments.notes.Notes
import usg.ihealth.ui.fragments.notes.dao.NoteDao

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    companion object {
        private var notesDatabase: NotesDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): NotesDatabase {
            if (notesDatabase == null) {
                notesDatabase = Room.databaseBuilder(
                    context,
                    NotesDatabase::class.java,
                    "notes.db"
                ).build()
            }
            return notesDatabase!!
        }
    }
    abstract fun noteDao(): NoteDao

}