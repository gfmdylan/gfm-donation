package com.gfmdonation.main.campaign

class Campaign constructor(
    campaigns: MutableList<String>
){

    var campaigns = campaigns

    fun campaignPrint () {
        println("Campaigns:")
        for (i in 0 until campaigns.size step 2) {
            println((campaigns[i] + " Total: $" + campaigns[i+1]))
        }
    }

    fun addCampaign (name: String) {
        campaigns.add(name)
        campaigns.add("0")
    }

    fun checkCampaign (name: String, amount: String) {
        var campaignName = campaigns.find { it == name }
        if (campaignName != null) {
            var campaignAndAmount: MutableList<String> =
                campaigns.subList(campaigns.indexOf(name),(campaigns.indexOf(name) + 2))
            campaignAndAmount[1] = (campaigns[campaigns.indexOf(name) + 1].toInt() + amount.toInt()).toString()
        } else {
            println("No campaign with that name was found.")
        }
    }
}