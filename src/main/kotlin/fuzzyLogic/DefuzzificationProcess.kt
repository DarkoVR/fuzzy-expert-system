package fuzzyLogic

import models.Coordinate
import models.Defuzzification
import models.LVRegister
import java.text.DecimalFormat

class DefuzzificationProcess {
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
                            if (resultX1 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            if (resultX2 != Double.NEGATIVE_INFINITY)
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
                            if (resultX1 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX1,input))
                            if (resultX2 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX2,input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                }
            }
            println("Grafico de variable de salida: ")
            println(register.name)
            register.label.forEach {
                print("etiqueta: ${it.labelName}")
                print(" { ")
                it.Coordinate.forEach {
                    print("(x:${it.x}, y:${it.y}),")
                }
                print(" }")
                println()
            }
            calculateCentroid(register,0.1)
        }
        return defuzzification
    }

    private fun calculateCentroid(lvRegister: LVRegister, steps: Double): Double{
        var forwarding = 0.0
        var result = 0.0
        var div = 0.0
        var centroid: Double
        lvRegister.let { register ->
            while (forwarding <= 100){
                val currentLabel = //finds if is a graphic to evaluate over if not ignores it and increases forward
                        register.label.find {
                            it.Coordinate.first().x <= forwarding && it.Coordinate.last().x >= forwarding
                        }
                if (currentLabel != null){
                    for (i in 0 until currentLabel.Coordinate.size){
                        if (currentLabel.Coordinate.size > i+1){
                            if (currentLabel.Coordinate[i].x <= forwarding && currentLabel.Coordinate[i+1].x >= forwarding){
                                val x1 =currentLabel.Coordinate[i].x
                                val x2 = currentLabel.Coordinate[i+1].x
                                val y1 = currentLabel.Coordinate[i].y
                                val y2 = currentLabel.Coordinate[i+1].y
                                val numberFormat = DecimalFormat("#.00")
                                val upEvaluation =
                                        if ((((forwarding-x1)/(x2-x1))*(y2-y1)+y1)*forwarding > 0)
                                            numberFormat.format((((forwarding-x1)/(x2-x1))*(y2-y1)+y1)*forwarding).toDouble()
                                        else
                                            0.0
                                val downEvaluation =
                                        if (((forwarding-x1)/(x2-x1))*(y2-y1)+y1 > 0)
                                            numberFormat.format(((forwarding-x1)/(x2-x1))*(y2-y1)+y1).toDouble()
                                        else
                                            0.0
                                result += upEvaluation
                                div += downEvaluation
                            }
                        }
                    }
                }
                forwarding += steps
            }
            centroid = result/div
            println("Centroide: $centroid")
            return centroid
        }
    }
}