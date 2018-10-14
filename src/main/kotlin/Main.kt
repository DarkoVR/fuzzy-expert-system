import files.LVFileHandler
import fuzzyLogic.FuzzificationProcess
import fuzzyLogic.FuzzyInference
import models.Coordinate
import models.LVRegister
import models.Label
import java.util.ArrayList



fun main(args: Array<String>) {
    val fileHandler = LVFileHandler()
    fileHandler.read()
    val fuzzificationProcess = FuzzificationProcess()
    fuzzificationProcess.init()

    Constants.lvList.forEach {
        Constants.fuzzificationList.add(fuzzificationProcess.fuzzificationProcess(it,90.0))
    }

    /*Constants.fuzzificationList.forEach {
        println(it)
    }*/

    val fuzzyInference = FuzzyInference()
    fuzzyInference.init()
}