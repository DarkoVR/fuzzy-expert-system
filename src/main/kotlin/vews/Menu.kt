package vews

import files.FAMFileHandler
import files.LVFileHandler
import fuzzyLogic.DefuzzificationProcess
import fuzzyLogic.FuzzificationProcess
import fuzzyLogic.FuzzyInference
import java.util.*
import kotlin.system.exitProcess

class Menu {
    fun init(){
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

    fun loadLVList(){
        //Read the file and fills the lvList with every linguistic variable and add them into lvList
        val lvFileHandler = LVFileHandler()
        lvFileHandler.read()

        //Filter the lvList to only have real information not included empty data
        val fuzzificationProcess = FuzzificationProcess()
        fuzzificationProcess.init()
    }

    fun menu(){
        println("Menu")
        println("1. Módulo de actualización")
        println("2. Lógica difusa")
        println("3. Salir")
        val keyboard = Scanner(System.`in`)
        val entry = keyboard.nextInt()
        firstEntry(entry)
    }

    private fun firstEntry(entry: Int){
        val fuzzificationProcess = FuzzificationProcess()
        when(entry){
            1 -> {
                println("1. Archivo binario de variables lingüísticas")
                println("2. Archivo binario de FAM")
                val keyboard = Scanner(System.`in`)
                val entry = keyboard.nextInt()
                secondEntry(entry)
            }
            2 -> {
                println("Introduzca el punto a evaluar en cada una de las variables linguisticas existentes, decimales")
                loadLVList()
                Constants.lvList.forEach {
                    println(it.name)
                    val keyboard = Scanner(System.`in`)
                    val entry = keyboard.nextDouble()
                    Constants.fuzzificationList.add(fuzzificationProcess.fuzzificationProcess(it,entry))
                }
                magic()
            }
            3 -> {
                println("Bye :D")
                exitProcess(0)
            }
            else -> {
                println("Esa entrada no existe!")
                menu()
            }
        }
    }

    private fun secondEntry(entry: Int){
        when(entry){
            1 -> {
                println("1. Leer todos")
                println("2. Leer uno")
                println("3. Escribir nuevo")
                println("4. Actualizar uno")
                println("5. Eliminar uno")
                val keyboard = Scanner(System.`in`)
                val entry = keyboard.nextInt()
                lvFile(entry)

            }
            1 -> {
                println("1. Leer todos")
                println("2. Leer uno")
                println("3. Escribir nuevo")
                println("4. Actualizar uno")
                println("5. Eliminar uno")
                val keyboard = Scanner(System.`in`)
                val entry = keyboard.nextInt()
                famFile(entry)

            }
            else -> {
                println("Esa entrada no existe!")
                menu()
            }
        }
    }

    private fun lvFile(entry: Int){
        val lvFileHandler = LVFileHandler()
        when(entry){
            1 -> {
                lvFileHandler.read()
            }
            2 -> {
                println("Posicion a leer en el archivo")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                lvFileHandler.read(position.toLong())
            }
            3 -> {
                println("Datos de nuevo registro: ")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                //famFileHandler.write()
            }
            4 -> {
                println("Posicion a actualizar: ")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                //famFileHandler.update()
            }
        }
    }

    private fun famFile(entry: Int){
        val famFileHandler = FAMFileHandler()
        when(entry){
            1 -> {
                famFileHandler.read()
            }
            2 -> {
                println("Posicion a leer en el archivo")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                famFileHandler.read(position.toLong())
            }
            3 -> {
                println("Datos de nuevo registro: ")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                //famFileHandler.write()
            }
            4 -> {
                println("Posicion a actualizar: ")
                val keyboard = Scanner(System.`in`)
                val position = keyboard.nextInt()
                //famFileHandler.update()
            }
        }
    }

    private fun magic(){
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
    }
}