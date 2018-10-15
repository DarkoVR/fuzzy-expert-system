import models.*
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
    val FAM_REGISTER_SIZE = 1144
    //Files
    val LV_FILE = File("linguistic_variable_master")
    val FAM_FILE = File("fuzzy_access_matrix_master")
    //Output variables
    val OUTPUT_VAR_1 = "Insuficiente con malos resultados"
    val OUTPUT_VAR_2 = "Casi suficiente de buenos resultados"
    val OUTPUT_VAR_3 = "Suficiente con resultados aceptables"
    val OUTPUT_VAR_4 = "Excelentes resultados"
    //Static arrayLists
    @JvmStatic
    val lvList: ArrayList<LVRegister> = ArrayList()
    @JvmStatic
    val fuzzificationList: ArrayList<Fuzzification> = ArrayList()
    @JvmStatic
    val famList: ArrayList<FAMRegister> = ArrayList()
    //Result linguistic variable
    val RESULT_LV = LVRegister("Calificacion", arrayListOf(
            Label("Insuficiente", arrayListOf(Coordinate(0.0,0.0), Coordinate(30.0,1.0), Coordinate(60.0,0.0))),
            Label("Casi suficiente", arrayListOf(Coordinate(37.0,0.0), Coordinate(55.0,1.0), Coordinate(73.0,0.0))),
            Label("Suficiente", arrayListOf(Coordinate(69.2,0.0), Coordinate(80.0,1.0), Coordinate(90.8,0.0))),
            Label("Excelente", arrayListOf(Coordinate(88.52,0.0), Coordinate(95.0,1.0), Coordinate(100.0,1.0)))
    ))
}