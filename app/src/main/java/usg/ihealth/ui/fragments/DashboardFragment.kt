package usg.ihealth.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        return binding.root
    }

}












//private fun setupGridView() {
//        val cardProfile =
//            DashboardAdapter.DashboardSection(getString(R.string.profile), R.drawable.user_24)
//        val cardNote =
//            DashboardAdapter.DashboardSection(getString(R.string.note), R.drawable.edit_24)
//        val cardBMI =
//            DashboardAdapter.DashboardSection(getString(R.string.bmi), R.drawable.calculator_24)
//        val cardCertificate =
//            DashboardAdapter.DashboardSection(getString(R.string.covid), R.drawable.qrcode_24)
//        val cardLogout = DashboardAdapter.DashboardSection(
//            getString(R.string.logout),
//            R.drawable.sign_out_alt_24
//        )
//        val cardSettings =
//            DashboardAdapter.DashboardSection(getString(R.string.setari), R.drawable.settings_24)
//
//        val dashboardList = mutableListOf(
//            cardProfile,
//            cardBMI,
//            cardCertificate,
//            cardNote,
//            cardSettings,
//            cardLogout
//        )
//        dashboardAdapter = DashboardAdapter(dashboardList, requireContext())
//        binding.dashboardGridView.adapter = dashboardAdapter
//        binding.dashboardGridView.onItemClickListener =
//            AdapterView.OnItemClickListener { _, _, position, _ ->
//                when (dashboardAdapter.getItem(position).title) {
//
//                    cardProfile.title -> navigateToProfile()
//                    cardBMI.title -> navigateToBmi()
//                    cardCertificate.title -> navigateToCertificate()
//                    cardNote.title -> navigateToNote()
//                    cardSettings.title -> navigateToSettings()
//                    cardLogout.title -> navigateToLogout()
//                }
//
//            }
//        dashboardAdapter.notifyDataSetChanged()
//    }