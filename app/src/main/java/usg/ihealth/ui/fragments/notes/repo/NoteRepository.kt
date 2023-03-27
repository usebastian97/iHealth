package usg.ihealth.ui.fragments.notes.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import usg.ihealth.ui.fragments.notes.dao.NoteDao
import usg.ihealth.ui.fragments.notes.entity.NoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(private val notesDao: NoteDao) {
    val notes = notesDao.getAllNotes()

    suspend fun getNote(id: Int) = withContext(Dispatchers.IO) {
        notesDao.getSpecificNote(id)
    }

    suspend fun insertNote(note: NoteEntity) = withContext(Dispatchers.IO) {
        notesDao.insertNotes(note)
    }

    suspend fun deleteNote(note: NoteEntity) = withContext(Dispatchers.IO) {
        notesDao.deleteNotes(note)
    }

    suspend fun deleteNoteById(id: Int) = withContext(Dispatchers.IO) {
        notesDao.deleteSpecificNote(id)
    }

    suspend fun updateNotes(note: NoteEntity) = withContext(Dispatchers.IO) {
        notesDao.updateNotes(note)
    }
}