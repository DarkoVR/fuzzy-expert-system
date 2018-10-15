package models

data class Defuzzification(
        var inputVariable: String? = "",
        var inputValue: ArrayList<Double> = ArrayList(),
        var fuzzyOutput: ArrayList<Background> = ArrayList()
)