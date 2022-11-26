import java.lang.ArithmeticException
// Class for calculating bmi and categorizing bmi results. -Mariann F
class Bmi {


    var height = 0.0
    var weight = 0.0
    private val bmiConstant : Int = 703
    fun weightTimesConstant(): Double {
        val weightTimesConstant = weight * bmiConstant
        return weightTimesConstant
    }

    // 1st method using height
    fun heightSquared(): Double {
        val heightSquared = height * height
        return heightSquared
    }

    fun calculateBMI(): Double {
        var bmi = 1.0
        try {
            bmi= weightTimesConstant() / heightSquared()

        }catch (e: ArithmeticException){
            println("Divide by zero not allowed")
        }

        return bmi

    }
    fun result(bmi: Double): String{

        lateinit var answer: String
        if(bmi<18.5){
            answer="Underweight"
        } else if(calculateBMI() > 18.5 && calculateBMI() < 24.9) {
            answer="Normal"
        } else if(calculateBMI() > 24.9 && calculateBMI() < 30) {
            answer="Overweight"
        } else {
            answer="Obese"
        }
        return answer
    }




}