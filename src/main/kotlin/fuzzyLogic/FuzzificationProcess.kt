package fuzzyLogic

import Constants
import models.*

class FuzzificationProcess {
    fun init(){
        val variableList: ArrayList<LVRegister> = ArrayList()
        Constants.lvList.forEach { variable ->
            if (variable.name.isNotBlank()){
                val labelList: ArrayList<Label> = ArrayList()
                variable.label.forEach { label ->
                    if (label.labelName.isNotBlank()){
                        val coordinateList: ArrayList<Coordinate> = ArrayList()
                        label.Coordinate.forEach { coordinate ->
                            if (coordinate.x >= 0 || coordinate.y >= 0){
                                coordinateList.add(Coordinate(coordinate.x,coordinate.y))
                            }
                        }
                        labelList.add(Label(label.labelName,coordinateList))
                    }
                }
                variableList.add(LVRegister(variable.name, labelList))
            }
        }
        Constants.lvList.clear()
        variableList.forEach {
            Constants.lvList.add(it)
        }
    }

    fun fuzzificationProcess(lvRegister: LVRegister,inputValue: Double): Fuzzification{
        val fuzzification = Fuzzification()
        lvRegister.let { register ->
            fuzzification.inputVariable = register.name
            fuzzification.inputValue = inputValue
            register.label.forEach { label ->
                var result = 0.0
                if (label.Coordinate.first().x <= inputValue && label.Coordinate.last().x >= inputValue) { //domain restriction
                    for (i in 0 until label.Coordinate.size){
                        if (label.Coordinate.size > i+1){
                            if (label.Coordinate[i].x <= inputValue && label.Coordinate[i+1].x >= inputValue){
                                result = ((inputValue-label.Coordinate[i].x)/(label.Coordinate[i+1].x-label.Coordinate[i].x))*
                                        (label.Coordinate[i+1].y-label.Coordinate[i].y)+label.Coordinate[i].y
                                if (fuzzification.fuzzyOutput.find { it.inputName == label.labelName } == null)
                                    fuzzification.fuzzyOutput.add(Background(label.labelName,result))
                            }
                        }
                    }
                }else {
                    fuzzification.fuzzyOutput.add(Background(label.labelName, 0.0))
                }
            }
        }
        return fuzzification
    }
}