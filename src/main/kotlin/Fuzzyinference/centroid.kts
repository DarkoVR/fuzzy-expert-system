package Fuzzyinference
import models.Coordinate
import models.Label
import models.LVRegister

class centroidsss
{
    fun calculateCentroid() : Coordinate
    {
        val centroidCoordinate : Coordinate

        var x : Double = 0.0
        val y : Double = 0.0
        val i : Double = 0.0

        while(i<=100)
        {
            //x =x+i*difuzzify(i)
        }

        centroidCoordinate = Coordinate(x,y)

        return centroidCoordinate
    }

    fun getIntersectionPoints(membershipGrade : LVRegister, outputVariable : ArrayList<Double>) : ArrayList<Coordinate>
    {
        val membershipGrade = membershipGrade // grades register
        val membershipCoordenates: ArrayList<Coordinate> = getCoordenates(membershipGrade.label)
        val centroidCoordenates: ArrayList<Coordinate> = ArrayList()
        val outputVariable =outputVariable

        var x :  Double = 0.0
        var i : Int = 0
        var j : Int = 0
        var n : Int = 0

        centroidCoordenates.add(Coordinate(membershipCoordenates[i].x,membershipCoordenates[i].y))

        while (membershipCoordenates[i].x!=100.0)
        {
            if(j>=2) {
                j=0
                n++

                if(membershipCoordenates[i].x!=100.0) {
                    centroidCoordenates.add(calcIntersection(i, membershipCoordenates))
                    i++
                }
            }

            if((membershipCoordenates[i].y == membershipCoordenates[i+1].y)) {
                j--
            } else {
                x = (((outputVariable[n] - membershipCoordenates[i].y)/(membershipCoordenates[i+1].y - membershipCoordenates[i].y))*(membershipCoordenates[i+1].x - membershipCoordenates[i].x)) + membershipCoordenates[i].x
                centroidCoordenates.add(Coordinate(x,outputVariable[n]))
            }
            j++
            i++
        }
        return centroidCoordenates
    }

    fun getCoordenates(labels: ArrayList<Label>): ArrayList<Coordinate>
    {
        var coordenates :ArrayList<Coordinate> = ArrayList()

        labels.forEach { label ->
            label.Coordinate.forEach { coordinate ->
                coordenates.add(coordinate)
            }
        }
        return coordenates
    }

    private fun calcIntersection(i : Int, membershipCoordenates : ArrayList<Coordinate> ) : Coordinate
    {
        val intersectionCoordenate: Coordinate
        val x : Double
        val y : Double

        val m1 : Double = (membershipCoordenates[i].y-membershipCoordenates[i-1].y)/(membershipCoordenates[i].x-membershipCoordenates[i-1].x)
        val m2 : Double = (membershipCoordenates[i+2].y-membershipCoordenates[i+1].y)/(membershipCoordenates[i+2].x-membershipCoordenates[i+1].x)

        x = ((m1*(membershipCoordenates[i-1].x)) - (m2*(membershipCoordenates[i+1].x))+(membershipCoordenates[i+1].y)-(membershipCoordenates[i-1].y))/(m1-m2)
        y = (m1*(x-membershipCoordenates[i-1].x))+membershipCoordenates[i-1].y

        intersectionCoordenate=(Coordinate(x,y))
        return intersectionCoordenate
    }
}