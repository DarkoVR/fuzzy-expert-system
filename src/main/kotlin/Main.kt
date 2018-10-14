import files.LVFileHandler
import models.*
import java.io.RandomAccessFile
import  Chart.Chart
import inference.difuzzify

fun main(args: Array<String>) {
    /*val fileHandler = LVFileHandler()
    fileHandler.read()*/

    /*data.forEach {
        fileHandler.update(it,1)
    }
    fileHandler.delete(1)
    fileHandler.read()*/

   /* val xData = doubleArrayOf(0.0, 1.0, 2.0)
    val yData = doubleArrayOf(2.0, 1.0, 0.0)

    val chart = Chart()
    chart.graphiChart("variable",xData,yData)*/


    val data: ArrayList<LVRegister> = ArrayList()
    data.add(LVRegister("trabajo_en_equipo", arrayListOf(
            Label("malo",
                    arrayListOf(
                            Coordinate(80.0,0.0),
                            Coordinate(90.0,1.0),
                            Coordinate(100.0,0.0)
                    )
            ),
            Label("regular",
                    arrayListOf(
                            Coordinate(80.0,0.0),
                            Coordinate(90.0,1.0),
                            Coordinate(100.0,1.0)
                    )
            )
    )))


    //println(data)

    val diffus = difuzzify()
    println(diffus.dufuss(83.0, data[0]))
}