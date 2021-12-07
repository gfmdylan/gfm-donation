package main

import com.gfmdonation.main.scan
import com.gfmdonation.main.campaign.Campaign
import com.gfmdonation.main.donation.Donation
import com.gfmdonation.main.gather
import com.gfmdonation.main.gatheredInput
import com.gfmdonation.main.runApp
import com.gfmdonation.main.scan
import com.gfmdonation.main.scanner
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.Scanner
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

internal class MainTest {

    private var donors = mutableListOf("")
    private var campaigns = mutableListOf("")
    private val testDonation = Donation(donors)
    private val testCampaign = Campaign(campaigns)
    private var testGatheredInput = mutableListOf<List<String>>(
        listOf("Add", "Campaign", "HelpTheKids"),
        listOf("Add", "Campaign", "SaveTheDogs"),
        listOf("Donate", "Dylan", "HelpTheKids", "$100"),
        listOf("Donate", "Kendle", "SaveTheDogs", "$200"),
    )
    private val testGather = gather(testGatheredInput)

    // I am not sure how to test from this point in the app.
    // I think I would need to make the main.kt a class instead of a function to initiate it as a test?
}
