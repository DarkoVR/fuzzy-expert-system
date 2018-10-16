package Charts
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.QuickChart

class SimpleChart
{
    fun graphiChart(linguisticVariable : String, xData: DoubleArray, yData : DoubleArray) {
        val chart = QuickChart.getChart(linguisticVariable, "X", "Y", "y(x)", xData, yData)

        SwingWrapper(chart).displayChart()
    }
}