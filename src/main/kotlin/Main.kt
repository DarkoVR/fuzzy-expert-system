import files.LVFileHandler
import models.Coordinate
import models.LVRegister
import models.Label

fun main(args: Array<String>) {
    val data: ArrayList<LVRegister> = ArrayList()
    data.add(LVRegister("trabajo_en_equipo", arrayListOf(
            Label("malo",
                    arrayListOf(
                            Coordinate(2.0,4.0),
                            Coordinate(3.0,6.0),
                            Coordinate(26.0,45.0),
                            Coordinate(62.0,84.0)
                    )
            ),
            Label("regular",
                    arrayListOf(
                            Coordinate(2.0,4.0),
                            Coordinate(3.0,6.0),
                            Coordinate(26.0,45.0),
                            Coordinate(62.0,84.0)
                    )
            ),
            Label("bueno",
                    arrayListOf(
                            Coordinate(2.0,4.0),
                            Coordinate(3.0,6.0),
                            Coordinate(26.0,45.0),
                            Coordinate(62.0,84.0)
                    )
            )
    ), 0))

    val fileHandler = LVFileHandler()
    data.forEach {
        fileHandler.write(it)
    }
    fileHandler.read(0)
}