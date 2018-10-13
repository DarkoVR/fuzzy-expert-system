package models

data class LVRegister(
        val name: String,
        val label: ArrayList<Label>,
        val position: Long //Not part of the register
)