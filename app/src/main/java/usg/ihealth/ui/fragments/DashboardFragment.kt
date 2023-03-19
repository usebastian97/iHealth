package usg.ihealth.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import usg.ihealth.R
import usg.ihealth.databinding.FragmentDashboardBinding
import usg.ihealth.ui.adapters.DashboardAdapter
import usg.ihealth.ui.viewModels.DashboardViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var dashboardAdapter: DashboardAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        setupGridView()

        return binding.root
    }

    private fun setupGridView() {
        val cardProfile =
            DashboardAdapter.DashboardSection(getString(R.string.profile), R.drawable.user_24)
        val cardNote =
            DashboardAdapter.DashboardSection(getString(R.string.note), R.drawable.edit_24)
        val cardBMI =
            DashboardAdapter.DashboardSection(getString(R.string.bmi), R.drawable.calculator_24)
        val cardCertificate =
            DashboardAdapter.DashboardSection(getString(R.string.covid), R.drawable.qrcode_24)
        val cardLogout = DashboardAdapter.DashboardSection(
            getString(R.string.logout),
            R.drawable.sign_out_alt_24
        )
        val cardSettings =
            DashboardAdapter.DashboardSection(getString(R.string.setari), R.drawable.settings_24)

        val dashboardList = mutableListOf(
            cardProfile,
            cardBMI,
            cardCertificate,
            cardNote,
            cardSettings,
            cardLogout
        )
        dashboardAdapter = DashboardAdapter(dashboardList, requireContext())
        binding.dashboardGridView.adapter = dashboardAdapter
        binding.dashboardGridView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                when (dashboardAdapter.getItem(position).title) {

                    cardProfile.title -> navigateToProfile()
                    cardBMI.title -> navigateToBmi()
                    cardCertificate.title -> navigateToCertificate()
                    cardNote.title -> navigateToNote()
                    cardSettings.title -> navigateToSettings()
                    cardLogout.title -> navigateToLogout()
                }

            }
        dashboardAdapter.notifyDataSetChanged()
    }

    private fun navigateToLogout() {
        TODO("Not yet implemented")
    }

    private fun navigateToSettings() {

        val action =
            DashboardFragmentDirections.navigationDashboardToSettings()
        findNavController().navigate(action)
    }

    private fun navigateToNote() {
        val action =
            DashboardFragmentDirections.navToNotes()
        findNavController().navigate(action)
    }

    private fun navigateToCertificate() {
        val action =
            DashboardFragmentDirections.navToCertificate()
        findNavController().navigate(action)
    }

    private fun navigateToBmi() {
        val action =
            DashboardFragmentDirections.navigationToBmi()
        findNavController().navigate(action)
    }

    private fun navigateToProfile() {
        val action =
            DashboardFragmentDirections.navigationDashboardToProfile()
        findNavController().navigate(action)
    }

}