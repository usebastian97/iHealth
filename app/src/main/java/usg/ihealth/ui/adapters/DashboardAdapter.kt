package usg.ihealth.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import usg.ihealth.R


class DashboardAdapter(
    private val dashboardList: List<DashboardSection>,
    private val context: Context
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var title: TextView
    private lateinit var iv: ImageView

    override fun getCount(): Int {
        return dashboardList.size
    }

    override fun getItem(position: Int): DashboardSection {
        return dashboardList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        var itemView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (itemView == null) {
            itemView = layoutInflater!!.inflate(R.layout.dashboard_sections, null)
        }

        title = itemView!!.findViewById(R.id.tv_dashboard)
        iv = itemView.findViewById(R.id.iv_dashboard)

        title.text = dashboardList[position].title
        iv.setImageResource(dashboardList[position].img)

        return itemView
    }

    data class DashboardSection(val title: String, val img: Int)
}


