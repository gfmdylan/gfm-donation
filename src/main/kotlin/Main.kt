package com.gfmdonation.main
import com.gfmdonation.main.campaign.Campaign
import com.gfmdonation.main.donation.Donation
import java.util.*
import kotlin.jvm.Throws

val scanner = Scanner(System.`in`)
var gatheredInput = mutableListOf(listOf<String>())
var donors = mutableListOf<String>()
var campaigns = mutableListOf<String>()
var donation = Donation(donors)
var campaign = Campaign(campaigns)

fun main(args: Array<String>) {
    runApp()
    scanner.close()
}

fun scan() {
    while (scanner.hasNextLine()) {
        var input = scanner.nextLine().split(" ")
        gatheredInput.add(input)
    }
}

@Throws(IllegalArgumentException::class)
fun gather(gatheredInput: MutableList<List<String>>) {
    for (i in 1 until gatheredInput.size) {

        var getIndex = gatheredInput[i]
        var action = getIndex[0]
        var target = getIndex[1]
        var name = getIndex[2]

        when (action) {
            "Add" -> {
                when (target) {
                    "Campaign" -> campaign.addCampaign(name)
                    else -> throw IllegalArgumentException("No campaign with that name was found.")
                }
            }
            "Donate" -> {
                var amount = try {
                    getIndex[3].replace("$","")
                } catch (e: IndexOutOfBoundsException) {
                    null
                }
                when (target.isNotEmpty()) {
                    true -> donation.donateCampaign(target, name, amount)
                    false -> throw IllegalArgumentException("Please add a donation and a campaign title to complete a donation.")
                }
            }
            else -> throw IllegalArgumentException("Please use Add Campaign or Donate to create a campaign or donation, respectively.")
        }
    }
}

fun runApp() {
    scan()
    gather(gatheredInput)
    donation.donorPrint()
    campaign.campaignPrint()
}
