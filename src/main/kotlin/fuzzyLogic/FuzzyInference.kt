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
        val famFileHandler = FAMFileHandler()
        //Assigns the minus and output variable to every entry in the FAM
        Constants.famList.forEach {
            var minus = 1.0
            it.antecedents.forEach {
                if (it.inputMembership < minus)
                    minus = it.inputMembership
            }
            it.outputMembership = minus
            it.outputName = "Insuficiente pero con ganas de mejorar"
        }
        Constants.famList.forEach {
            famFileHandler.write(it)
        }
    }
}