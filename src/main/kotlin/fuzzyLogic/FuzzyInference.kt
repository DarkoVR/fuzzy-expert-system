package fuzzyLogic

import Constants
import files.FAMFileHandler
import models.Background
import models.FAMRegister
import models.Node

class FuzzyInference {

    private var parentList: ArrayList<Node>? = ArrayList()
    private var childList: ArrayList<Node>? = ArrayList()

    fun init (){
        var parentNode = Node("parentNode","",0.0, null)
        parentList?.add(parentNode)
        for (i in 0 until Constants.fuzzificationList.size){
            for (j in 0 until parentList?.size!!){
                var childNode: Node?
                parentNode = parentList!![j]
                Constants.fuzzificationList[i].fuzzyOutput.forEach {
                    childNode = Node(
                            Constants.fuzzificationList[i].inputVariable!!,
                            it.inputName,
                            it.inputMembership,
                            parentNode
                    )
                    parentNode.addChild(childNode!!)
                    childList?.add(childNode!!)
                    //This represents a tree leaf and also a combination
                    if (i == Constants.fuzzificationList.size-1){
                        //Puts avery antecedent included the leaf one into a new array
                        val antecedents: ArrayList<Background> = getAntecedents(parentNode)
                        antecedents.add(Background(it.inputName,it.inputMembership))
                        Constants.famList.add(FAMRegister(
                                "lv",
                                0.0,
                                antecedents
                        ))
                    }
                }
            }
            parentList = childList?.clone() as ArrayList<Node>
            childList!!.clear()
        }
    }

    private fun getAntecedents(parentNode: Node): ArrayList<Background>{
        val data: ArrayList<Background> = ArrayList()
        var tmp = parentNode
        while (tmp.parent != null){
            data.add(Background(
                    tmp.label,
                    tmp.value
            ))
            tmp = tmp.parent!!
        }
        return data
    }

    fun createFamFile(){
        //Assigns the minus and output variable to every entry in the FAM
        val assignedVariable: Int = Constants.famList.size/Constants.LINGUISTIC_VARIABLE_NUMBER

        var combination = 0
        Constants.famList.forEach {
            var minus = 1.0
            it.antecedents.forEach {
                if (it.inputMembership < minus)
                    minus = it.inputMembership
            }
            it.outputMembership = minus
            when {
                combination < (assignedVariable) -> it.outputName = Constants.OUTPUT_VAR_1
                combination in (assignedVariable)..(assignedVariable*2-1) -> it.outputName = Constants.OUTPUT_VAR_2
                combination in (assignedVariable*2)..(assignedVariable*3-1) -> it.outputName = Constants.OUTPUT_VAR_3
                combination >= (assignedVariable*3) -> it.outputName = Constants.OUTPUT_VAR_4
            }
            combination++
        }
    }

    fun writeFAMInToFile(){
        val famFileHandler = FAMFileHandler()
        Constants.famList.forEach {
            famFileHandler.write(it)
        }
    }

    fun getFuzzyOutput(): ArrayList<Double>{
        val outputs: ArrayList<Double> = ArrayList()
        var output1 = 0.0
        var output2 = 0.0
        var output3 = 0.0
        var output4 = 0.0
        Constants.famList.forEach {
            when {
                it.outputName == Constants.OUTPUT_VAR_1 ->
                    if (it.outputMembership > output1) output1 = it.outputMembership
                it.outputName == Constants.OUTPUT_VAR_2 ->
                    if (it.outputMembership > output2) output2 = it.outputMembership
                it.outputName == Constants.OUTPUT_VAR_3 ->
                    if (it.outputMembership > output3) output3= it.outputMembership
                it.outputName == Constants.OUTPUT_VAR_4 ->
                    if (it.outputMembership > output4) output4 = it.outputMembership
            }
        }
        //val numberFormat = DecimalFormat("#.00")
        outputs.add(output1)
        outputs.add(output2)
        outputs.add(output3)
        outputs.add(output4)

        println(" salidas difusas  $outputs")

        return outputs
    }
}