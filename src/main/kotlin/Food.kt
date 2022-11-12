/* The food class maps food items to the calories they contain and to the number of 
 * servings the person consumed of it
 */
class Food{

    // A dictionary that maps food items to the calories they contain (Maggie)
    //Changed to mutable types since want to expand map (Mariann)
    val foodItemToCalories: MutableMap<String, Int> = mutableMapOf<String, Int>  (
        "Eggs" to 78,
        "White Bread" to 80,
        "Milk" to 103
    )


    // a dictionary that maps food items to the number of servings the person ate
    // (Maggie)
    var foodItemToServings: Map<String, Int> = mapOf<String, Int>  (
        "Apple" to 3, "White Bread" to 1, "Milk" to 2
    )
}
