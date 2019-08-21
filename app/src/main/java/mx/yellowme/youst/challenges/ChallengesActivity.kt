package mx.yellowme.youst.challenges

import mx.yellowme.youst.R
import mx.yellowme.youst.challenges.BaseChallengeActivity.Companion.TOOLBAR_TITLE
import mx.yellowme.youst.challenges.navigation.NavigationActivity
import mx.yellowme.youst.core.extensions.launch
import mx.yellowme.youst.core.extensions.toast
import mx.yellowme.youst.core.templates.showcase.GenericShowcaseActivity
import mx.yellowme.youst.core.templates.showcase.GenericShowcasedOption

class ChallengesActivity : GenericShowcaseActivity() {

    override val titleResId: Int = R.string.challenges_title

    override val subtitleResId: Int = R.string.challenges_subtitle

    override val optionsJsonName: String = "challenges.json"

    //TODO: Improve item handle
    override fun onItemClick(item: GenericShowcasedOption?) {
        item?.id?.let {
            if (it == "4") {
                toast(getString(R.string.work_in_progress))
                return
            }

            val nextActivity: Class<*> = when (it) {
                "2" -> {
                    ListenToMeChallengeActivity::class.java
                }
                "1",
                "3" -> {
                    CrazyListsChallengeActivity::class.java
                }
                "5" -> NavigationActivity::class.java
                else -> throw RuntimeException("Invalid challenge identifier")
            }

            launch(nextActivity) {
                putExtra(TOOLBAR_TITLE, item.title)
            }
        }
    }

}
