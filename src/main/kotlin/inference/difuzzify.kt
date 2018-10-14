package inference

import models.*

class difuzzify
{
    fun dufuss(x : Double, linguisticVariable : LVRegister) : ArrayList<Coordinate>
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
        return y
    }
}