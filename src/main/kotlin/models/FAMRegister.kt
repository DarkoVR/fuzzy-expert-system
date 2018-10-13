package models

data class FAMRegister (
        val outputName: String,
        val outputMembership: Double,
        val antecedents: ArrayList<Background>,
        val position: Long //Not part of the register
)