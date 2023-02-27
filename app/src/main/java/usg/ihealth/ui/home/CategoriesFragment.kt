package usg.ihealth.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import usg.ihealth.R
import usg.ihealth.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        setupRecyclerViewCategories()

        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun setupRecyclerViewCategories() {

        val cardAndrologie = CategoriesAdapter.CategoriesSection(
            getString(R.string.andrologie),
            R.drawable.angle_small_right_24
        )
        val cardBoli = CategoriesAdapter.CategoriesSection(
            getString(R.string.boli_infectioase),
            R.drawable.angle_small_right_24
        )
        val cardCardologie = CategoriesAdapter.CategoriesSection(
            getString(R.string.cardolgie),
            R.drawable.angle_small_right_24
        )
        val cardChirurgie = CategoriesAdapter.CategoriesSection(
            getString(R.string.chirurgie_crdv),
            R.drawable.angle_small_right_24
        )
        val cardDermato = CategoriesAdapter.CategoriesSection(
            getString(R.string.dermato),
            R.drawable.angle_small_right_24
        )
        val cardDiabet = CategoriesAdapter.CategoriesSection(
            getString(R.string.diabet),
            R.drawable.angle_small_right_24
        )
        val cardEcografie = CategoriesAdapter.CategoriesSection(
            getString(R.string.ecografie),
            R.drawable.angle_small_right_24
        )
        val cardEndo = CategoriesAdapter.CategoriesSection(
            getString(R.string.endocrinologie),
            R.drawable.angle_small_right_24
        )
        val cardEpidemiologie = CategoriesAdapter.CategoriesSection(
            getString(R.string.epidemiologie),
            R.drawable.angle_small_right_24
        )

        val cardListCategories = mutableListOf(
            cardAndrologie,
            cardBoli,
            cardCardologie,
            cardChirurgie,
            cardDermato,
            cardDiabet,
            cardEcografie,
            cardEndo,
            cardEpidemiologie
        )

        val rvCategories = binding.rvCategories
        rvCategories.layoutManager = LinearLayoutManager(this.requireActivity())
        rvCategories.setHasFixedSize(true)
        categoriesAdapter = CategoriesAdapter(cardListCategories, requireContext())
        binding.rvCategories.adapter = categoriesAdapter
        categoriesAdapter.notifyDataSetChanged()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}