package fuzzyLogic

import models.Fuzzification
import java.util.ArrayList

class FuzzyInference {
    fun init (){
        Constants.fuzzificationList.forEach {
            val list = ArrayList<Fuzzification>()
            list.add(it)
            Constants.listOfLists.add(list)
        }
    }
}