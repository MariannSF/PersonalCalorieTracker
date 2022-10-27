fun main() {
    // variable for calories consumed (Maggie)
    var caloriesConsumed = 0
    // variable for calories burned (Maggie)
    var caloriesBurned = 0
    // variable for user's calorie burning goal (Maggie)
    var goal = 0
    // variable for calories still to be burned (Maggie)
    var caloriesToGo = 0
    // variable for BMI (Maggie)
    var bMI = 0.0

    // Getting the user's name
    println("Enter your Name: ")
    var userInputName = readLine() // a variable that hold's the user's name

    // input validation (Maggie)
    while (userInputName == "") {
        println("Invalid input: Enter name again")
        userInputName = readLine()
    }


    // Calculate Calories Consumed Using the Food Class (STILL NEEDED!)

    // Calculate Calories Burned Using the Excercise Class (STILL NEEDED!)

    // Calculate BMI Using the as of now, non-existant BMI Class (STILL NEEDED!)

    // Allows users to set calorie goals (Maggie)
    println("Enter your calorie goal: ")
    // Setting user's calorie goal to their input (Maggie)
    goal = (readLine()?.toDoubleOrNull()?: error("enter a number")).toInt()
    // Printing the user's calorie goal, so they can see it went through (Maggie)
    println("Your goal is " + goal + "!")

    // Calculating Calories To Go
    caloriesToGo = goal - caloriesBurned


    // printing user's name (Maggie)
    println(userInputName + "'s Report: ")
    // printing calories consumed (Maggie)
    println("Calories Consumed: " + caloriesConsumed)
    // printing calories burned (Maggie)
    println("Calories Burned " + caloriesBurned)

    // printing appropriate messages to the user depending on whether they met their
    // calorie burning goals or not (Maggie)
    if (caloriesBurned == goal) {
        println("Congratulations! You Met Your Calorie Burning Goal!!!")
    } else {
        println("You Have Not Met Your Calorie Burning Goal Yet.")
        println("You Must Burn " + caloriesToGo + " Calories To Meet Your Goal!!!")
    }


}
