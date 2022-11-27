import java.lang.NumberFormatException
import kotlin.math.roundToInt
import javax.swing.*;

fun main() {
    val user1 = User("");
    var input = "";

    //User login(James)
    while(user1.password.isBlank()) {   //Run as long as a correct password isn't entered
        print("Please enter your username: ");
        user1.username = readln();

        while (user1.username.isBlank()) {  //Runs until a non-blank string is input
            print("Invalid input, please try entering you username again:");
            user1.username = readln();
        }
        if (user1.loadFile()) {             //Checks if userdata exists
            print("User \"" + user1.username + "\" found! Would you like to login?(Y/N): ");
            input = readln()
            if (input.uppercase() == "Y") {     //User wants to log in
                print("Please enter your password: ");
                if (readln() == user1.password) //Successful login
                    break;
                else {                          //Unsuccessful login
                    println("Password incorrect! Please try again...");
                    user1.password = "";
                }
            } else if (input.uppercase() == "N") {  //User does not want to log in
                println("Returning to username entry...");
                user1.password = "";
            } else                                  //Invalid input
                println("Invalid input detected! Defaulting to N");
        } else {                                    //User data not found
            print("User \"" + user1.username + "\" not found...\n" +
                    "Would you like to create an account with this username?(Y/N): ");
            input = readln()

            if (input.uppercase() == "Y") { //Account creation
                while(user1.password.isBlank()) {
                    print("Please enter your password: ");
                    user1.password = readln();
                }
                while(user1.name.isBlank()) {
                    print("Please enter your name: ");
                    user1.name = readln();
                }
                while(user1.userHeight == 0.0) {
                    print("Please enter your height in inches: ");
                    try {
                        user1.userHeight = readLine()!!.toDouble();
                    } catch (e: NumberFormatException) {
                        println("Invalid input! Please try again");
                    }
                }
                while(user1.userWeight == 0.0) {
                    print("Please enter your weight in pounds: ");
                    try {
                        user1.userWeight = readLine()!!.toDouble();
                    } catch (e: NumberFormatException) {
                        println("Invalid input! Please try again");
                    }
                }

            } else if (input.uppercase() == "N")
                println("Returning to username entry...");
            else
                println("Invalid input detected! Defaulting to N");
        }
    }
    /*
    // variable for calories consumed (Maggie)
    var caloriesConsumed = 0
    // variable for calories burned (Maggie)
    var caloriesBurned = 0
    // variable for user's calorie burning goal (Maggie)
    // variable for calories still to be burned (Maggie)
    val caloriesToGo: Int
    // variable for BMI (Maggie)
    var bMI = 0.0

    // Getting the user's name
    println("Enter your Name: ")
    var userInputName = readLine() // a variable that hold's the user's name

    // input validation (Maggie)
    while (userInputName.isNullOrEmpty()) {
        println("Invalid input: Enter name again")
        userInputName = readLine()
    }
    */
    while (true) {
        println(
            "What would you like to do?\n" +
                    "[1] Enter consumed calories\n" +
                    "[2] Enter exercise\n" +
                    "[3] Generate report\n" +
                    "[4] Close program"
        )
        print("Select an option: ")
        input = readln();
        when (input) {
            "1" -> { // Calculate Calories Consumed Using the Food Class
                do {


                    val FD = Food()

                    //Here I'm going to give the user a list of foods that they can choose. -Michael J
                    println("List of Food:\n")
                    var foodMap = FD.foodItemToCalories
                    var foodList = foodMap.keys


                    //Initialize an iterator to traverse the key values of foodItemToCalories map, and traverse list. -Michael J
                    val foodIterator = foodList.iterator()
                    while (foodIterator.hasNext()) {
                        var nextFood = foodIterator.next()
                        println(nextFood + ", calories per serving " + foodMap[nextFood])
                    }


                    //Accepting user input for food item and serving size.
                    // Displaying  calories consumed based on user input -Mariann F
                    println("\nEnter Food item consumed: ")
                    var fdItemRaw = readLine()
                    var fdItem = fdItemRaw?.uppercase()
                    println("Enter the serving size consumed: ")
                    var servingS = readLine()!!.toInt()

                    //If food item does not exist in Food map adding a new food item specified by user. -Mariann F
                    if (FD.foodItemToCalories.get(fdItem) == null) {
                        println("This food item does not exist yet! Enter the calorie per serving size")
                        val itemCalorie = readLine()!!.toInt()

                        if (fdItem != null) {
                            FD.foodItemToCalories.put(fdItem, itemCalorie)
                        }

                    }

                    println("It is " + FD.foodItemToCalories.get(fdItem) + " calories")

                    var tCalPerFood = FD.foodItemToCalories.get(fdItem)!! * servingS
                    user1.userTotalConsumedCals += tCalPerFood
                    println("Calories Consumed: " + user1.userTotalConsumedCals)
                    println("You ate " + servingS + " servings of " + fdItem + " which adds " + tCalPerFood + " calories to your total daily calories consumed")


                    //Allowing user to enter additional food items consumed
                    println("Do you want to add another item consumed? Y/N")
                    val cont = readLine()
                    var char = cont?.subSequence(0, 1)
                    var it = ""
                    if (char?.count() == 1) {
                        it = char.get(0).toString()
                    }
                } while (it.equals('y'.toString(), true))
            }

            "2" -> { // Calculate Calories Burned Using the Exercise Class (Anas)
                val exercise = Exercise()

                do {
                    println(
                        "What exercise did you do from the following list?:\n" +
                                "   Push ups\n" +
                                "   Running\n" +
                                "   Walking\n" +
                                "   Hiking\n" +
                                "   Swimming\n" +
                                "   Aerobics\n" +
                                "   Water aerobics\n" +
                                "   Bicycling\n" +
                                "   Elliptical Trainer\n" +
                                "   Skiing\n" +
                                "   Golfing"
                    )

                    var userExercise = readLine()

                    while (!exercise.exerciseToCaloriesPerHour.containsKey(userExercise)) {
                        println("This exercise is not in the list. Please try again: ")
                        userExercise = readLine()
                    }

                    var exerciseCal = exercise.exerciseToCaloriesPerHour[userExercise]!!

                    println("How many hours did you spend doing this exercise? ")
                    var hours = readLine()!!.toDouble()

                    user1.userTotalBurnedCals += (exerciseCal * hours).roundToInt()

                    println("Do you want to add another exercise? Y/N")
                    val cont = readLine()
                    var char = cont?.subSequence(0, 1)
                    var it = ""
                    if (char?.count() == 1) {
                        it = char[0].toString()
                    }
                } while (it.equals('y'.toString(), true))

                println("Total calories burned: " + user1.userTotalBurnedCals)
            }
            "3" -> { // Accepting user input and passing to Bmi Class for calculating bmi and return results. -Mariann F
                val bmi = Bmi()
                bmi.height = user1.userHeight
                bmi.weight = user1.userWeight

                println("your BMI " + "%.4f".format(bmi.calculateBMI()) + " " + bmi.result(bmi.calculateBMI()))

                // Allows users to set calorie goals (Maggie)
                println("Enter your calorie goal: ")
                // Setting user's calorie goal to their input (Maggie)
                val goal = (readLine()?.toDoubleOrNull() ?: error("enter a number")).toInt()
                // Printing the user's calorie goal, so they can see it went through (Maggie)
                println("Your goal is " + goal + "!")

                // Calculating Calories To Go
                var caloriesToGo = goal - user1.userTotalBurnedCals


                // printing user's name (Maggie)
                println(user1.name + "'s Report: ")
                // printing calories consumed (Maggie)
                println("Calories Consumed: " + user1.userTotalConsumedCals)
                // printing calories burned (Maggie)
                println("Calories Burned " + user1.userTotalBurnedCals)

                // printing appropriate messages to the user depending on whether they met their
                // calorie burning goals or not (Maggie)
                if (user1.userTotalBurnedCals >= goal) {
                    println("Congratulations! You Met Your Calorie Burning Goal!!!")
                } else {
                    println("You Have Not Met Your Calorie Burning Goal Yet.")
                    println("You Must Burn $caloriesToGo Calories To Meet Your Goal!!!")
                }
            }
            "4" -> break;
            else -> println("Invalid input! Please try again")
        }











        /*


    println("Enter your weight in pounds: ")
    var userInputW = readLine()?.toDoubleOrNull() ?: error("enter a number")

    // input validation
    while (userInputW < 0) {
        println("Invalid input: Enter a Weight that is 0 or Greater")
        userInputW = readLine()?.toDoubleOrNull() ?: error("enter a number")
    }

    println("Enter your height in inches: ")
    var userInputH = readLine()?.toDoubleOrNull() ?: error("enter a number")

    // input validation
    while (userInputH < 0) {
        println("Invalid input: Enter a Height that is 0 or Greater")
        userInputH = readLine()?.toDoubleOrNull() ?: error("enter a number")
    }

     */

        user1.saveToFile()      //Save user data to file

    }
}
