package com.gfmdonation.main
import com.gfmdonation.main.campaign.Campaign
import com.gfmdonation.main.donation.Donation
import java.io.File
import java.util.*
import kotlin.jvm.Throws

val scanner = Scanner(System.`in`)
var gatheredInput = mutableListOf(listOf<String>())
var donors = mutableListOf<String>()
var campaigns = mutableListOf<String>()
var donation = Donation(donors)
var campaign = Campaign(campaigns)

fun main(args: Array<String>) {
    val fileName: String? =
        if (args.isNullOrEmpty()) {
            null
        } else {
            args[0]
    }
    val file =
        if (fileName.isNullOrEmpty()) {
            null
        } else {
            File(fileName)
    }
    runApp(file)
}

fun scan(file: File?) {
    if (file?.exists() == true) {
        while (file.readLines().isNotEmpty()) {
            var input = file.readLines()
            gatheredInput.add(input)
        }
    } else {
        while (scanner.hasNextLine()) {
            var input = scanner.nextLine().split(" ")
            gatheredInput.add(input)
        }
    }
    scanner.close()
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

fun runApp(file: File?) {
    scan(file)
    gather(gatheredInput)
    donation.donorPrint()
    campaign.campaignPrint()
}
