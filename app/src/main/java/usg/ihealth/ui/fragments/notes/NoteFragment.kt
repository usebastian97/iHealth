package usg.ihealth.ui.fragments.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import usg.ihealth.R
import usg.ihealth.databinding.FragmentNoteBinding
import usg.ihealth.ui.adapters.NotesAdapter

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val viewModel by viewModels<NoteViewModel>()
    private lateinit var notesAdapter: NotesAdapter

    private val binding get() = _binding!!

    companion object {
        @JvmStatic
        fun newInstance() =
            NoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)

        return binding.root
    }

}