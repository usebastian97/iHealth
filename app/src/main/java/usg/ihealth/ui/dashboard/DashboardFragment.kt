package usg.ihealth.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import usg.ihealth.R
import usg.ihealth.databinding.DashboardSectionsBinding
import usg.ihealth.databinding.FragmentDashboardBinding
import usg.ihealth.ui.dashboard.adapter.DashboardAdapter

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
        val cardSupport =
            DashboardAdapter.DashboardSection(getString(R.string.suport), R.drawable.phone_call_24)
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
            cardSupport,
            cardSettings,
            cardLogout
        )
        dashboardAdapter = DashboardAdapter(dashboardList, requireContext())
        binding.dashboardGridView.adapter = dashboardAdapter

        dashboardAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}