import files.FAMFileHandler
import files.LVFileHandler
import models.*

fun main(args: Array<String>) {
    /*val data: ArrayList<LVRegister> = ArrayList()
    data.add(LVRegister("trabajo_en_equipo", arrayListOf(
            Label("malo",
                    arrayListOf(
                            Coordinate(1.0,1.0),
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
    )))

    val fileHandler = LVFileHandler()
    data.forEach {
        fileHandler.write(it)
        fileHandler.write(it)
        fileHandler.write(it)
    }
    fileHandler.read()
    data.forEach {
        fileHandler.update(it,2)
    }
    fileHandler.delete(2)
    fileHandler.read()*/

    val fileHandler = FAMFileHandler()
    val data: ArrayList<FAMRegister> = ArrayList()
    data.add(FAMRegister("suficiente",0.4, arrayListOf(
            Background("malo",0.5),
            Background("malo",0.7),
            Background("malo",0.9),
            Background("malo",1.0)
    )))
    data.forEach {
        fileHandler.write(it)
    }
    fileHandler.read()
    /*data.forEach {
        fileHandler.update(it,1)
    }
    fileHandler.delete(1)
    fileHandler.read()*/
}