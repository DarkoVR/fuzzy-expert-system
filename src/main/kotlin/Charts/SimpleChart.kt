package Charts
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.QuickChart
import org.knowm.xchart.*
import org.knowm.xchart.style.Styler.LegendPosition
import javax.swing.Spring.width
import javax.swing.Spring.height
import Constants



class SimpleChart
{
    fun graphiChart(linguisticVariable : String, xData: DoubleArray, yData : DoubleArray) {

        val xDataResult_Lv : ArrayList<Double> = ArrayList()
        val yDataResult_Lv : ArrayList<Double> = ArrayList()

        val chart = QuickChart.getChart(linguisticVariable, "X", "Y", "y(x)", xData, yData)

        Constants.RESULT_LV.label.forEach { label ->
            label.Coordinate.forEach { point ->
                xDataResult_Lv.add(point.x)
                yDataResult_Lv.add(point.y)
            }
            chart.addSeries(label.labelName, xDataResult_Lv.toDoubleArray(), yDataResult_Lv.toDoubleArray())
            xDataResult_Lv!!.clear()
            yDataResult_Lv!!.clear()
        }
        SwingWrapper(chart).displayChart()
    }




}