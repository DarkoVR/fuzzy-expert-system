import files.LVFileHandler
import fuzzyLogic.DefuzzificationProcess
import fuzzyLogic.FuzzificationProcess
import fuzzyLogic.FuzzyInference


fun main(args: Array<String>) {
    //Read the file and fills the lvList with every linguistic variable and add them into lvList
    val lvFileHandler = LVFileHandler()
    lvFileHandler.read()

    //Filter the lvList to only have real information not included empty data
    val fuzzificationProcess = FuzzificationProcess()
    fuzzificationProcess.init()

    //Manual input of every linguistic variable, returns result of evaluation and add it into fuzzificationList
    Constants.lvList.forEach {
        Constants.fuzzificationList.add(fuzzificationProcess.fuzzificationProcess(it,90.0))
    }

    //This fuzzifies the results and creates the FAM into famList
    val fuzzyInference = FuzzyInference()
    fuzzyInference.init()

    //Due the FAM are created on every run, the file is deleted
    Constants.FAM_FILE.delete()
    fuzzyInference.createFamFile()
    fuzzyInference.writeFAMInToFile()

    //Number of combination result
    println("Numero de combinaciones totales: ${Constants.famList.size}")
    //Get the real outputs after min-max calculus
    val fuzzyOutput = fuzzyInference.getFuzzyOutput()
    println("salida difusa: $fuzzyOutput")

    //Alter the linguistic output variable in order to the fuzzy outputs
    val defuzzification = DefuzzificationProcess()
    defuzzification.alterGraphic(Constants.RESULT_LV,fuzzyOutput)

    //val famFileHandler = FAMFileHandler()
    //famFileHandler.read(2916)
}