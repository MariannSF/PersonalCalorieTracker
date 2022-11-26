/*
 * The exercise class maps excercise type to the calories they burn per hour and to how
 * many hours the person performed these excercised.
 */
class Exercise {

    // a dictionary that maps a type of exercise to the number of calories they burn per hour
    // (Maggie)
    val exerciseToCaloriesPerHour: Map<String, Int> = mapOf<String, Int>  (
        "Push ups" to 420,
        "Running" to 606,
        "Walking" to 314,
        "Hiking" to 438,
        "Swimming" to 423,
        "Aerobics" to 365,
        "Water aerobics" to 402,
        "Bicycling" to 292,
        "Elliptical Trainer" to 365,
        "Skiing" to 314,
        "Golfing" to 314,
    )

    // a dictionary that maps exercise type to # of hours exercised (Maggie)
    val exerciseToHours: Map<String, Int> = mapOf<String, Int>  (
        "Walking" to 3, "Running" to 1, "Push Ups" to 1, "Hiking" to 2
    )
}
