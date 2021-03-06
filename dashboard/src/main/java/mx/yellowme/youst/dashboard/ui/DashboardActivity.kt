package mx.yellowme.youst.dashboard.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.dashboard.*
import mx.yellowme.youst.core.components.showThemeChooser
import mx.yellowme.youst.core.extensions.launch
import mx.yellowme.youst.core.hooks.BaseActivity
import mx.yellowme.youst.core.hooks.recycler.ItemListener
import mx.yellowme.youst.core.utils.Activities
import mx.yellowme.youst.core.utils.intentTo
import mx.yellowme.youst.dashboard.R
import mx.yellowme.youst.dashboard.data.DashboardLoader
import mx.yellowme.youst.dashboard.domain.DashboardOption
import mx.yellowme.youst.dashboard.domain.DashboardOptionId

class DashboardActivity : BaseActivity(), ItemListener<DashboardOption> {

    //region Attributes

    override val layoutId = R.layout.dashboard

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = DashboardRecyclerView.Builder()
            .with(dashboardOptions)
            .into(this)


        DashboardLoader.loadData(this) {
            titleTextView.text = it.title
            subtitleTextView.text = it.subtitle

            recyclerView.setData(it.options)
        }

        //TODO: Move this button to a Settings Section
        themeModeButton.setOnClickListener() {
            showThemeChooser()
        }
    }

    override fun onItemClick(item: DashboardOption?) {
        when (item!!.optionId) {
            DashboardOptionId.CHALLENGES -> {
                launch(intentTo(Activities.Challenges))
            }
            DashboardOptionId.PLAYGROUND -> {
                launch(intentTo(Activities.Playground))
            }
            DashboardOptionId.MINI_APPS -> {
                launch(intentTo(Activities.MiniApps))
            }
            DashboardOptionId.PORTFOLIO -> {
                launch(intentTo(Activities.Portfolio))
            }
        }
    }

    //endregion
}
