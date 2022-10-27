/*
 * The exercise class maps excercise type to the calories they burn per hour and to how
 * many hours the person performed these excercised.
 */
class Exercise {

    // a dictionary that maps a type of exercise to the number of calories they burn per hour
    // (Maggie)
    val exerciseToCaloriesPerHour: Map<String, Int> = mapOf<String, Int>  (
        "Push ups" to 420,
        "Running (5 mph)" to 606,
        "Walking (3.5 mph)" to 314,
        "Hiking" to 438,
        "Swimming laps, light to moderate" to 423,
        "Low-impact aerobics" to 365,
        "Water aerobics" to 402,
        "Bicycling < 10 mph" to 292,
        "Elliptical Trainer (moderate effort)" to 365,
        "Downhill Skiing" to 314,
        "Golfing/Carrying Clubs" to 314,
    )

    // a dictionary that maps exercise type to # of hours exercised (Maggie)
    val exerciseToHours: Map<String, Int> = mapOf<String, Int>  (
        "Walking" to 3, "Running" to 1, "Push Ups" to 1, "Hiking" to 2
    )
}
