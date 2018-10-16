package fuzzyLogic

import models.*
import Charts.SimpleChart
import java.text.DecimalFormat

class DefuzzificationProcess {
    fun alterGraphic(lvRegister: LVRegister, fuzzyOuputs: ArrayList<Double>): Defuzzification {
        val defuzzification = Defuzzification()
        lvRegister.let { register ->
            defuzzification.inputVariable = register.name
            defuzzification.inputValue = fuzzyOuputs
            for (i in 0 until register.label.size) {
                val first = register.label[i].Coordinate.first()
                val last = register.label[i].Coordinate.last()
                when (i) {
                    0 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0) {
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                        } else {
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].y
                            val resultX2 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            if (resultX1 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX1, input))
                            if (resultX2 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX2, input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    1 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0) {
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                        } else {
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].y
                            val resultX2 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            register.label[i].Coordinate.add(Coordinate(resultX1, input))
                            register.label[i].Coordinate.add(Coordinate(resultX2, input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    2 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0) {
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                        } else {
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].y
                            val resultX2 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            register.label[i].Coordinate.add(Coordinate(resultX1, input))
                            register.label[i].Coordinate.add(Coordinate(resultX2, input))
                            register.label[i].Coordinate.add(last)
                        }
                    }
                    3 -> {
                        val input = fuzzyOuputs[i]
                        if (input == 0.0) {
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                            register.label[i].Coordinate.add(Coordinate(0.0, 0.0))
                        } else {
                            var x1 = register.label[i].Coordinate[0].x
                            var x2 = register.label[i].Coordinate[1].x
                            var y1 = register.label[i].Coordinate[0].y
                            var y2 = register.label[i].Coordinate[1].y
                            val resultX1 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            x1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].x
                            x2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].x
                            y1 = register.label[i].Coordinate[register.label[i].Coordinate.size - 2].y
                            y2 = register.label[i].Coordinate[register.label[i].Coordinate.size - 1].y
                            val resultX2 = ((input - y1) / (y2 - y1)) * (x2 - x1) + x1
                            register.label[i].Coordinate.clear()
                            register.label[i].Coordinate.add(first)
                            if (resultX1 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX1, input))
                            if (resultX2 != Double.NEGATIVE_INFINITY)
                                register.label[i].Coordinate.add(Coordinate(resultX2, input))
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
            calculateCentroids(register, 0.1)
        }
        return defuzzification
    }
    private fun getIntersectionPoints(membershipGrade: LVRegister, outputVariable: ArrayList<Double>): ArrayList<Coordinate> {
        val membershipCoordenates: ArrayList<Coordinate> = getCoordenates(membershipGrade.label)
        val centroidCoordenates: ArrayList<Coordinate> = ArrayList()
        val outputVariable = outputVariable
        val chart = SimpleChart()

        var x = 0.0
        var i = 0
        var j = 0
        var n = 0

        centroidCoordenates.add(Coordinate(membershipCoordenates[i].x, membershipCoordenates[i].y))
        while (membershipCoordenates[i].x != 100.0) {
            if (j >= 2) {
                j = 0
                n++

                if (membershipCoordenates[i].x != 100.0) {
                    if(outputVariable[n]!=0.0) {
                        centroidCoordenates.add(calcIntersection(i, membershipCoordenates))
                    }
                        i++
                }
            }

            if ((membershipCoordenates[i].y == membershipCoordenates[i + 1].y)) {
                j--
            } else {

                    x = (((outputVariable[n] - membershipCoordenates[i].y) / (membershipCoordenates[i + 1].y - membershipCoordenates[i].y)) * (membershipCoordenates[i + 1].x - membershipCoordenates[i].x)) + membershipCoordenates[i].x
                    centroidCoordenates.add(Coordinate(x, outputVariable[n]))
            }
            j++
            i++
        }

        if(outputVariable[n]!=0.0)
            centroidCoordenates.add(Coordinate(membershipCoordenates[membershipCoordenates.size - 1].x, membershipCoordenates[membershipCoordenates.size - 1].y))
        else
            centroidCoordenates.add(Coordinate(100.0,0.0))

        val xData : ArrayList<Double> = ArrayList()
        val yData : ArrayList<Double> = ArrayList()

        centroidCoordenates.forEach { point ->
               xData.add(point.x)
               yData.add(point.y)
        }

        println(centroidCoordenates)

        chart.graphiChart("CALIFICACION",xData.toDoubleArray(),yData.toDoubleArray())
        return centroidCoordenates
    }

    private fun getCoordenates(labels: ArrayList<Label>): ArrayList<Coordinate> {
        var coordenates: ArrayList<Coordinate> = ArrayList()

        labels.forEach { label ->
            label.Coordinate.forEach { coordinate ->
                coordenates.add(coordinate)
            }
        }
        return coordenates
    }

    private fun calcIntersection(i: Int, membershipCoordenates: ArrayList<Coordinate>): Coordinate {
        val intersectionCoordenate: Coordinate
        val x: Double
        val y: Double

        val m1: Double = (membershipCoordenates[i].y - membershipCoordenates[i - 1].y) / (membershipCoordenates[i].x - membershipCoordenates[i - 1].x)
        val m2: Double = (membershipCoordenates[i + 2].y - membershipCoordenates[i + 1].y) / (membershipCoordenates[i + 2].x - membershipCoordenates[i + 1].x)

        x = ((m1 * (membershipCoordenates[i - 1].x)) - (m2 * (membershipCoordenates[i + 1].x)) + (membershipCoordenates[i + 1].y) - (membershipCoordenates[i - 1].y)) / (m1 - m2)
        y = (m1 * (x - membershipCoordenates[i - 1].x)) + membershipCoordenates[i - 1].y

        intersectionCoordenate = (Coordinate(x, y))



        return intersectionCoordenate
    }

    fun calculateCentroid(membershipGrade : LVRegister, outputVariable : ArrayList<Double>) : Coordinate
    {
        val intersecrionCoordenates = getIntersectionPoints(membershipGrade,outputVariable)

        var x  = 0.0
        var x1 = 0.0
        var x2 = 0.0
        var y  = 0.0
        var y1 = 0.0
        var y2 = 0.0
        var i  = 0.0
        var DFV : Double
        var maxValue  : Double = 0.0
        var auxMaxValue :  Double

        while(i<=100)
        {
            DFV = difuzzy((i),intersecrionCoordenates)
            x1=((i)*(DFV))+x1
            x2=x2+DFV
            i += 0.001
        }

        intersecrionCoordenates.forEach { coordenate ->
            auxMaxValue = coordenate.y
            if(auxMaxValue > maxValue)
            {
                maxValue = auxMaxValue
            } }


        while(i<=100)
        {
            DFV = difuzzx((80+i),intersecrionCoordenates)
            y1=((80.0+i)*(DFV))+y1
            y2=y2+DFV
            i += 0.001
        }

        x = x1/x2
        y = y1/y2

        return Coordinate(x,y)
    }

    private fun difuzzy(x : Double, coordenates : ArrayList<Coordinate>) : Double
    {
        var y = 0.0
        for (i in 0 until coordenates.size-1)
        {
            if(x<=coordenates[coordenates.size-1].x && x>=coordenates[0].x )
            {
                if(x>=coordenates[i].x && x<=coordenates[i+1].x)
                {
                    y=((((coordenates[i+1].y - coordenates[i].y) / (coordenates[i+1].x - coordenates[i].x)) * (x - coordenates[i].x)) + coordenates[i].y)
                }
            }
            else{
                y=0.0
            }
        }
        return y
    }

    private fun difuzzx(x : Double, coordenates : ArrayList<Coordinate>) : Double
    {
        var y = 0.0
        for (i in 0 until coordenates.size-1)
        {
            if(x<=coordenates[coordenates.size-1].x && x>=coordenates[0].x )
            {
                if(x>=coordenates[i].x && x<=coordenates[i+1].x)
                {
                    y=((((x - coordenates[i].y) / (coordenates[i+1].y - coordenates[i].y)) * (coordenates[i+1].x - coordenates[i].x)) + coordenates[i].x)
                }
            }
            else{
                y=0.0
            }
        }
        return y
    }

    private fun calculateCentroids(lvRegister: LVRegister, steps: Double): Double{
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