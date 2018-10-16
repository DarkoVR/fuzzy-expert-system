package views

import Constants
import files.LVFileHandler
import fuzzyLogic.DefuzzificationProcess
import fuzzyLogic.FuzzificationProcess
import fuzzyLogic.FuzzyInference
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.paint.Color
import models.FAMRegister
import models.LVRegister
import tornadofx.*

class Interface: View() {
    override val root = borderpane {

        style { setMinSize(1000.0,500.0) }

        left<VariablesView>()
        right<EntryView>()
        bottom<LogView>()
    }
}

class MyController: Controller(){
    private val logView: LogView by inject()
    val fuzzificationProcess = FuzzificationProcess()
    fun clearLVList(){
        Constants.lvList.clear()
    }
    fun readFromFileLV(){
        //Read the file and fills the lvList with every linguistic variable and add them into lvList
        val lvFileHandler = LVFileHandler()
        lvFileHandler.read()
        //Filter the lvList to only have real information not included empty data
        val fuzzificationProcess = FuzzificationProcess()
        fuzzificationProcess.init()
    }
    fun fuzzifiesData(dataArray: ArrayList<SimpleStringProperty>){
        for (i in 0 until dataArray.size){
            println(dataArray[i].toString())
            Constants.fuzzificationList.add(fuzzificationProcess.fuzzificationProcess(Constants.lvList[i],dataArray[i].value.toString().toDouble()))
        }
        loadFAMList()
    }
    fun loadFAMList(){
        //This fuzzifies the results and creates the FAM into famList
        val fuzzyInference = FuzzyInference()
        fuzzyInference.init()
        fuzzyInference.createFamFile()
        writeFAMFile()
    }
    fun writeFAMFile(){
        val fuzzyInference = FuzzyInference()
        //Due the FAM are created on every run, the file is deleted
        Constants.FAM_FILE.delete()
        fuzzyInference.writeFAMInToFile()
        logView.editorInput.value += "Archivo matriz difusa creado!\n"
        getFuzzyOutputs()
    }
    fun getFuzzyOutputs(){
        val fuzzyInference = FuzzyInference()
        //Number of combination result
        logView.editorInput.value += "Numero de combinaciones totales: ${Constants.famList.size}\n"
        println("Numero de combinaciones totales: ${Constants.famList.size}")
        //Get the real outputs after min-max calculus
        val fuzzyOutput = fuzzyInference.getFuzzyOutput()
        logView.editorInput.value += "salida difusa: $fuzzyOutput\n"
        println("salida difusa: $fuzzyOutput")
        //calculateCentroid()
    }
    fun calculateCentroid(){
        val fuzzyInference = FuzzyInference()
        val fuzzyOutput = fuzzyInference.getFuzzyOutput()
        //Alter the linguistic output variable in order to the fuzzy outputs
        val defuzzification = DefuzzificationProcess()
        defuzzification.alterGraphic(Constants.RESULT_LV,fuzzyOutput)
    }
}

class EntryView : View() {
    private val controller: MyController by inject()
    private val variablesView: VariablesView by inject()
    private val logView: LogView by inject()
    private val input1 = SimpleStringProperty()
    private val input2 = SimpleStringProperty()
    private val input3 = SimpleStringProperty()
    private val input4 = SimpleStringProperty()
    private val input5 = SimpleStringProperty()
    private val input6 = SimpleStringProperty()
    private val input7 = SimpleStringProperty()
    private val input8 = SimpleStringProperty()

    override val root = form {

        fieldset {

            //1. Load the lvList
            label("Points evaluation") {
                textFill = Color.BLUE
            }

            runAsync {
                //controller.clearLVList()
                controller.readFromFileLV()
            } ui {
                val registerList = Constants.lvList.observable()
                variablesView.lvObservables.asyncItems { registerList }
                logView.editorInput.value = ""
                logView.editorInput.value += "Archivo variables linguisticas leído\n"

                field(Constants.lvList[0].name) {
                    textfield(input1)
                }
                field(Constants.lvList[1].name) {
                    textfield(input2)
                }
                field(Constants.lvList[2].name) {
                    textfield(input3)
                }
                field(Constants.lvList[3].name) {
                    textfield(input4)
                }
                field(Constants.lvList[4].name) {
                    textfield(input5)
                }
                field(Constants.lvList[5].name) {
                    textfield(input6)
                }
                field(Constants.lvList[6].name) {
                    textfield(input7)
                }
                field(Constants.lvList[7].name) {
                    textfield(input8)
                }
            }


            button("Listo!") {
                action {
                    runAsync {
                        logView.editorInput.value = ""

                        val dataArray =
                                arrayListOf(input1,input2,input3,input4,input5,input6,input7,input8)
                        //2. Creates fuzzificationList with every entry fuzzified
                        val somethingNull = dataArray.filter { it.value == null }
                        if (somethingNull.isEmpty())
                            controller.fuzzifiesData(dataArray)
                        else
                            logView.editorInput.value = "Falta llenar algun dato!"
                    } ui {
                        val registerList = Constants.famList.observable()
                        variablesView.famObservables.asyncItems { registerList }
                    }
                }
            }
        }
    }
}

class VariablesView: View() {
    val lvObservables = FXCollections.observableArrayList<LVRegister>()!!
    val famObservables = FXCollections.observableArrayList<FAMRegister>()!!
    override val root = form {

        style { setMaxSize(600.0,550.0) }

        label("Linguistic variables") {
            textFill = Color.BLUE
        }
        tableview(lvObservables) {
            readonlyColumn("Name",LVRegister::name).minWidth = 300.0
            readonlyColumn("Label",LVRegister::label).minWidth = 5000.0
        }

        label("Fuzzy Access Matrix") {
            textFill = Color.BLUE
        }
        tableview(famObservables) {
            readonlyColumn("Name",FAMRegister::outputName).minWidth = 300.0
            readonlyColumn("Membership",FAMRegister::outputMembership).minWidth = 300.0
            readonlyColumn("Antecedents",FAMRegister::antecedents).minWidth = 5000.0
        }
    }
}

class LogView: View() {
    val editorInput = SimpleStringProperty()
    override val root = form {
        fieldset {
            label("Log") {
                textFill = Color.RED
            }
            field {
                textarea(editorInput).maxHeight = 100.0
            }
        }
    }
}