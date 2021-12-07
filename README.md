## Dylan Armstead's TakeHome Mock

This program is set up to accept an input.txt file with designated commands.
The commands are "Add Campaign" followed by a campaign title and "Donate"
followed by a donor name, campaign title, and donation amount starting with $.
ex. "Add Campaign FirstCampaign" or "Donate Dylan FirstCampaign $100"

This would lead to an output of a list of campaigns and donors added along with
amounts tied to those donors and campaigns.

To run this program, you must have at least Kotlin, Java, and JDK 8.

Make sure you are in the gfm-donation directory.

Then, compile the program with this command:

        kotlinc src/main -include-runtime -d Main.jar

Once the program is compiled, you can run the program against your input.txt file with:

        cat input.txt | java -jar Main.jar

Or, you can run the program by entering:

        java -jar Main.jar

Followed by individual commands, then ending with Ctrl + D:

ex.
Add Campaign FirstCampaign
Donate Dylan FirstCampaign $100
Ctrl + D

### Testing

To run the tests and see results, from gfm-donation directory, run:

        gradle clean test --info

To test this program, we would be checking the main areas of function:

    -Adding campaigns

        -If I use the correct command, a campaign is added with the title used.

        -If I use an incorrect command, I receive the correct error message.

        -If I use the correct command, but without a campaign title, I receive the correct error message.

    -Adding donors

        -If I use the correct command, a donor with a donation should be added.

        -If I use an incorrect command, I receive the correct error message.

        -If I use the correct command, but without a donor name, I receive the correct error message.

        -If I use the correct command, but without a campaign title, I receive the correct error message.

        -If I use the correct command, but without a donation amount, I receive the correct error message.

    -Adding donations under the correct campaign and donors.

        -If donors and campaigns are added correctly, the total amount of donations should calculate correctly.

### Approach

I broke up the main functions of this app into 3 places; a main app, and classes for Donations and Campaigns.
I went about setting up functions that can take and organize input into lists of lists. Once we have the input,
I created functions that check for the appropriate command by checking the action at the beginning of the command.
From there, we dig deeper into each individual lists to check for new campaign titles or new donors. Then we take all
new donation amounts and add them to the donor and campaign totals, outputting the final results.
