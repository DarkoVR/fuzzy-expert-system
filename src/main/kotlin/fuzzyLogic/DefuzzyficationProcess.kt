package fuzzyLogic

import models.Coordinate
import models.Defuzzification
import models.LVRegister

class DefuzzyficationProcess {
    fun alterGraphic(lvRegister: LVRegister, fuzzyOuputs: ArrayList<Double>): Defuzzification {
        val defuzzification = Defuzzification()
        lvRegister.let { register ->
            defuzzification.inputVariable = register.name
            defuzzification.inputValue = fuzzyOuputs
            for (i in 0 until register.label.size){
                val first = register.label[i].Coordinate.first()
                val last = register.label[i].Coordinate.last()
                when (i){
                    0 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0){
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                        }else{
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].y
                            val resultX2 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            register.label[i].Coordinate.add(Coordinate(resultX2,input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    1 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0){
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                        }else{
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].y
                            val resultX2 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            register.label[i].Coordinate.add(Coordinate(resultX2,input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    2 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0){
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                        }else{
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].y
                            val resultX2 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            register.label[i].Coordinate.add(Coordinate(resultX2,input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    3 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0){
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0,0.0))
                        }else{
                            println("input = $input")
                            println("i = $i")
                            var x1 = register.label[i].Coordinate[0].x
                            println("x1: $x1")
                            var x2 = register.label[i].Coordinate[1].x
                            println("x2: $x2")
                            var y1 = register.label[i].Coordinate[0].y
                            println("y1: $y1")
                            var y2 = register.label[i].Coordinate[1].y
                            println("y2: $y2")
                            val resultX1 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            println("resultX1: $resultX1")
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].x
                            println("x1: $x1")
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].x
                            println("x2: $x2")
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size-2].y
                            println("y1: $y1")
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size-1].y
                            println("y2: $y2")
                            val resultX2 = ((input-y1)/(y2-y1))*(x2-x1)+x1
                            println("resultX2: $resultX2")
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            if (resultX1 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            if (resultX2 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX2,input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                }
            }
            println("Altered result linguistic variable")
            println(register)
        }
        return defuzzification
    }
}