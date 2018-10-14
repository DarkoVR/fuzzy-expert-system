import files.LVFileHandler
import models.*
import java.io.RandomAccessFile
import  Chart.Chart

fun main(args: Array<String>) {
    val fileHandler = LVFileHandler()
    fileHandler.read()

    /*data.forEach {
        fileHandler.update(it,1)
    }
    fileHandler.delete(1)
    fileHandler.read()*/

    val xData = doubleArrayOf(0.0, 1.0, 2.0)
    val yData = doubleArrayOf(2.0, 1.0, 0.0)

    val chart = Chart()
    chart.graphiChart("variable",xData,yData)
}