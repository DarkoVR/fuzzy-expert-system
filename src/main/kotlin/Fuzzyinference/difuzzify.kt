package Fuzzyinference

import models.*

class difuzzify
{
    fun fusify(x : Double, linguisticVariable : LVRegister) : ArrayList<Coordinate>
    {
        val y: ArrayList<Coordinate> = ArrayList()

        linguisticVariable.label.forEach { label ->
            label.Coordinate
            for (i in 0 until linguisticVariable.label.size)
            {
                label.Coordinate[i]
                label.Coordinate[i+1]

                if(x<=label.Coordinate[label.Coordinate.size-1].x && x>=label.Coordinate[0].x )
                {
                    if(x>=label.Coordinate[i].x && x<=label.Coordinate[i+1].x)
                    {
                        y.add(Coordinate(x,((((label.Coordinate[i+1].y - label.Coordinate[i].y) / (label.Coordinate[i+1].x - label.Coordinate[i].x)) * (x - label.Coordinate[i].x)) + label.Coordinate[i].y)))
                    }
                }
                else{
                    y.add(Coordinate(x,0.0))
                }
            }
        }
        print(y)
        return y
    }


    fun difuzzy(x : Double, coordenates : ArrayList<Coordinate>) : Double
    {
        var y: Double =0.0
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
        print("valor de y = ")
        println(y)
        print("valor de x = ")
        println(x)
        return y
    }

    fun difuzzx(y : Double, coordenates : ArrayList<Coordinate>) : Double
    {
        var y: Double =0.0
        for (i in 0 until coordenates.size-1)
        {
            if(y<=coordenates[coordenates.size-1].x && y>=coordenates[0].x )
            {
                if(y>=coordenates[i].x && y<=coordenates[i+1].x)
                {
                    y=((((y - coordenates[i].y) / (coordenates[i+1].y - coordenates[i].y)) * (coordenates[i+1].x - coordenates[i].x)) + coordenates[i].x)
                }
            }
            else{
                y=0.0
            }
        }
        print("valor de y = ")
        println(y)
        print("valor de x = ")
        println(y)
        return y
    }
}