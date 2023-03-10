package usg.ihealth.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import usg.ihealth.databinding.FragmentCovidBinding
import usg.ihealth.ui.viewModels.CovidViewModel

class CovidFragment : Fragment() {

    private var _binding: FragmentCovidBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val covidViewModel =
            ViewModelProvider(this)[CovidViewModel::class.java]

        _binding = FragmentCovidBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCovid
        covidViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}