package com.gfmdonation.main.donation
import com.gfmdonation.main.campaign.Campaign
import com.gfmdonation.main.campaigns

class Donation constructor(
    donors: MutableList<String>
){
    var donors = donors
    var campaign = Campaign(campaigns)

    fun donateCampaign (target: String, name: String, amount: String?) {
        if (amount != null) {
            checkDonor(target, amount)
        }
        if (amount != null) {
            campaign.checkCampaign(name, amount)
        }
    }

    fun donorPrint() {
        println("Donors:")
        for (i in 0 until donors.size step 2) {
            println((donors[i] + " Total: $" + donors[i + 1]))
        }
    }

    fun addDonor(target: String, amount: String) {
        donors.add(target)
        donors.add(amount)
    }

    fun checkDonor(target: String, amount: String) {
        var repeatDonor = donors.find { it == target }
        if (repeatDonor != null) {
            var donorAndAmount: MutableList<String> =
                donors.subList(donors.indexOf(target), (donors.indexOf(target) + 2))
            donorAndAmount.set(1, (donors.get(donors.indexOf(target) + 1).toInt() + amount.toInt()).toString())
        } else {
            addDonor(target, amount)
        }
    }
}
