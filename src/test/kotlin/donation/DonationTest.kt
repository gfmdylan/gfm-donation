package donation

import com.gfmdonation.main.campaign.Campaign
import com.gfmdonation.main.donation.Donation
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class DonationTest {

    private var donors = mutableListOf("Dylan", "100", "Kendle", "200")
    private var campaigns = mutableListOf("Test", "0")
    private val testDonation = Donation(donors)
    private val testCampaign = Campaign(campaigns)

    @Test
    fun donateCampaignTest() {
        testDonation.donateCampaign("Dylan", "Test", "100")
        testCampaign.checkCampaign("Test", "100")
        assertEquals(donors, listOf("Dylan", "200", "Kendle", "200"))
        assertEquals(campaigns, listOf("Test", "100"))
    }

    @Test
    fun addDonorTest() {
        testDonation.addDonor("Vincent", "300")
        assertEquals(donors.size, 6)
        assertEquals(donors, listOf("Dylan", "100", "Kendle", "200", "Vincent", "300"))
    }

    @Test
    fun checkDonorNewDonor() {
        testDonation.checkDonor("Teemo", "100")
        assertEquals(donors, listOf("Dylan", "100", "Kendle", "200", "Teemo", "100"))
    }

    @Test
    fun checkDonorRepeatDonor() {
        testDonation.checkDonor("Dylan", "100")
        assertEquals(donors, listOf("Dylan", "200", "Kendle", "200"))
    }
}