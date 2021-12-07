package campaign

import org.junit.jupiter.api.Test
import com.gfmdonation.main.campaign.Campaign
import org.junit.jupiter.api.Assertions.*

internal class CampaignTest {

    private var campaigns = mutableListOf("Test", "0")
    private val testCampaign = Campaign(campaigns)

    @Test
    fun addCampaignTest() {
        testCampaign.addCampaign("Second")
        assertEquals(campaigns, listOf("Test", "0", "Second", "0"))
    }

}
