package usg.ihealth.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import usg.ihealth.databinding.FragmentTracingBinding
import usg.ihealth.ui.viewModels.TracingViewModel

class TracingFragment : Fragment() {

    private var _binding: FragmentTracingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val tracingViewModel =
            ViewModelProvider(this)[TracingViewModel::class.java]

        _binding = FragmentTracingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTracing
        tracingViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


}