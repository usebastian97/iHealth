package usg.ihealth.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import usg.ihealth.databinding.FragmentBmiBinding
import usg.ihealth.ui.viewModels.BmiViewModel

class BmiFragment : Fragment() {

    private lateinit var viewModel: BmiViewModel

    private var _binding: FragmentBmiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiBinding.inflate(inflater, container, false)

        return binding.root
    }

}