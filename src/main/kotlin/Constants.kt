import java.io.File

object Constants {
    val STRING_LENGTH = 32
    //LVFileHandler
    val COORDINATES_LENGTH = 8
    val LABELS_LENGTH = 8
    val LV_REGISTER_SIZE = 1600
    //FAMFileHandler
    val ANTECEDENTS_LENGTH = 12
    val FAM_REGISTER_SIZE = 936
    val LV_FILE = File("linguistic_variable_master")
    val FAM_FILE = File("fuzzy_access_matrix_master")
}