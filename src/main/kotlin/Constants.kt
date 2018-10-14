import models.Fuzzification
import models.LVRegister
import java.io.File
import java.util.ArrayList



object Constants {
    val STRING_LENGTH = 40
    //LVFileHandler
    val COORDINATES_LENGTH = 8
    val LABELS_LENGTH = 8
    val LV_REGISTER_SIZE = 1744
    //FAMFileHandler
    val ANTECEDENTS_LENGTH = 12
    val FAM_REGISTER_SIZE = 936
    //Files
    val LV_FILE = File("linguistic_variable_master")
    val FAM_FILE = File("fuzzy_access_matrix_master")

    @JvmStatic
    val lvList: ArrayList<LVRegister> = ArrayList()
    @JvmStatic
    val fuzzificationList: ArrayList<Fuzzification> = ArrayList()
    @JvmStatic
    val listOfLists = ArrayList<List<Fuzzification>>()
}