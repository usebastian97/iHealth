package usg.ihealth.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import usg.ihealth.R
import usg.ihealth.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.btnCategorii.setOnClickListener {
            view?.let { it1 -> buttonCategories(it1) }

        }

        return binding.root
    }

    private fun buttonCategories(view: View) {

        Navigation.findNavController(view)
            .navigate(R.id.action_navigation_home_to_categoriesFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}