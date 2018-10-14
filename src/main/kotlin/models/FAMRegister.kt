package models

data class FAMRegister (
        var outputName: String,
        var outputMembership: Double,
        val antecedents: ArrayList<Background>
)