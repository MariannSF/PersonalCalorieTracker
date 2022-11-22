//Allowing users to calculate net calories by subtracting
// the product of all exercises calories expenditure per minute
// and users exercise time for the
// exercise from the total of calories consumed from food items.
import java.util.concurrent.TimeUnit

class NetCalories {
//Hayden Callitsis
    var caloriesGainedFood = readLine()!!.toDouble()
    val caloriesLostExercising = readLine()!!.toDouble()
    var timeSpentExercising = readLine()!!.toLong()

    fun grossCalories(): Double {
        val grossCalories = caloriesGainedFood - caloriesLostExercising
        return grossCalories
    }

    fun productOfAllExercises(): Double {
        val milliseconds = 60000.0
        val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds.toLong())
        val productOfAllExercises = grossCalories()/seconds
        return productOfAllExercises
    }

    fun liveTimeOfAllExercises(): Double {
        val productOfAllExercises = productOfAllExercises()
        timeSpentExercising = TimeUnit.MILLISECONDS.toSeconds(timeSpentExercising)
        caloriesGainedFood = caloriesGainedFood - timeSpentExercising
        caloriesGainedFood = caloriesGainedFood - productOfAllExercises
        return caloriesGainedFood
    }
}
