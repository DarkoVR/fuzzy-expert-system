package models

data class Fuzzification(
        var inputVariable: String? = "",
        var inputValue: Double? = 0.0,
        var fuzzyOutput: ArrayList<Background> = ArrayList()
)