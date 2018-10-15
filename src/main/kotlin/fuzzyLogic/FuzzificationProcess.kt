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
                    for (i in 0 until label.Coordinate.size){ //Iteration by coordinate with restriction
                        if (label.Coordinate.size > i+1){ //Due it takes the i+1 value it can't be null values ahead
                            if (label.Coordinate[i].x <= inputValue && label.Coordinate[i+1].x >= inputValue){ //restriction
                                val x1 = label.Coordinate[i].x
                                val x2 = label.Coordinate[i+1].x
                                val y1 = label.Coordinate[i].y
                                val y2 = label.Coordinate[i+1].y
                                result = ((inputValue-x1)/(x2-x1))*(y2-y1)+y1
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