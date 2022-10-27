/* The food class maps food items to the calories they contain and to the number of 
 * servings the person consumed of it
 */
class food() {

    // A dictionary that maps food items to the calories they contain (Maggie)
    var foodItemToCalories: Map<String, Int> = mapOf<String, Int>  (
        "Eggs (Serving Size: 1)" to 78,
        "White Bread (Serving Size: 30 g)" to 80,
        "Milk (Serving Size: 1 cup)" to 103
    )


    // a dictionary that maps food items to the number of servings the person ate
    // (Maggie)
    var foodItemToServings: Map<String, Int> = mapOf<String, Int>  (
        "Apple" to 3, "White Bread" to 1, "Milk" to 2
    )
}
