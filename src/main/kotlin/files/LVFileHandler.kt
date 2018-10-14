package files

import models.Coordinate
import models.LVRegister
import models.Label
import java.io.IOException
import java.io.RandomAccessFile

class LVFileHandler {

    /**
     * Principal function to write over the random access LV_FILE
     */
    @Throws(IOException::class)
    fun write(register: LVRegister) {
        val file = RandomAccessFile(Constants.LV_FILE, "rw")
        file.seek(file.length())

        writeString(register.name,file)
        writeLabels(register.label,file)

        println("Written over linguistic_variable_master, position: ${file.filePointer/Constants.LV_REGISTER_SIZE} " + "name: ${register.name}")

        file.close()
    }

    /**
     * Principal function to read from the random access LV_FILE
     */
    @Throws(IOException::class)
    fun read(){
        val file = RandomAccessFile(Constants.LV_FILE, "rw")
        file.seek(0)
        var position = 1
        while(file.length()>file.filePointer){
            val name = readString(file)
            val labels = readLabels(file)
            println("//-----Some register------//")
            println("name: $name")
            println("Position: $position")
            println("File pointer: ${file.filePointer}")
            labels.forEach { labelName ->
                print("Label: ${labelName.labelName} | ")
                print("Coordinate: ")
                labelName.Coordinate.forEach { coordinate ->
                    print(" ( ${coordinate.x} , ${coordinate.y} )")
                }
                println()
            }
            position++
        }
    }

    /**
     * Overload function to read one from the random access LV_FILE
     */
    @Throws(IOException::class)
    fun read(position: Long){
        val file = RandomAccessFile(Constants.LV_FILE, "rw")
        val position = position-1
        file.seek(position*Constants.LV_REGISTER_SIZE)
        val name = readString(file)
        val labels = readLabels(file)
        println("//-----Some register------//")
        println("name: $name")
        println("Position: ${position+1}")
        println("File pointer: ${file.filePointer}")
        labels.forEach { labelName ->
            print("Label: ${labelName.labelName} | ")
            print("Coordinate: ")
            labelName.Coordinate.forEach { coordinate ->
                print(" ( ${coordinate.x} , ${coordinate.y} )")
            }
            println()
        }
    }

    /**
     * Principal function to update over the random access LV_FILE
     */
    @Throws(IOException::class)
    fun update(register: LVRegister, position: Int) {
        val file = RandomAccessFile(Constants.LV_FILE, "rw")
        file.seek((position*Constants.LV_REGISTER_SIZE).toLong())

        writeString(register.name,file)
        writeLabels(register.label,file)

        println("Updated over linguistic_variable_master, position: $position name: ${register.name}")

        file.close()
    }

    /**
     * Principal function to delete over the random access LV_FILE
     */
    @Throws(IOException::class)
    fun delete(position: Int) {
        val file = RandomAccessFile(Constants.LV_FILE, "rw")
        file.seek((position*Constants.LV_REGISTER_SIZE).toLong())

        writeString("xxx",file)

        println("Deleted over linguistic_variable_master, position: $position")

        file.close()
    }

    private fun writeLabels(labels: ArrayList<Label>, file: RandomAccessFile){
        for (i in 0 until Constants.LABELS_LENGTH) {
            if (labels.size>i){
                writeString(labels[i].labelName,file)
                writeCoordinates(labels[i].Coordinate,file)
            }else{
                writeString("",file)
                writeCoordinates(arrayListOf(),file)
            }
        }
    }

    private fun writeCoordinates(coordinates: ArrayList<Coordinate>, file: RandomAccessFile){
        for (i in 0 until Constants.COORDINATES_LENGTH){
            if (coordinates.size>i){
                file.writeDouble(coordinates[i].x)
                file.writeDouble(coordinates[i].y)
            }else{
                file.writeDouble(0.0)
                file.writeDouble(0.0)
            }
        }
    }

    private fun writeString(str: String, file: RandomAccessFile){
        for (i in 0 until Constants.STRING_LENGTH) {
            if (str.length>i) file.writeChars(str[i].toString())
            else file.writeChars(' '.toString())
        }
    }

    private fun readString(file: RandomAccessFile): String {
        var text = ""
        for (i in 0 until Constants.STRING_LENGTH)
            text += file.readChar()
        return text
    }

    private fun readLabels(file: RandomAccessFile): ArrayList<Label>{
        val data: ArrayList<Label> = ArrayList()
        for (label in 0 until Constants.LABELS_LENGTH){
            val labelName = readString(file)
            val coordinate: ArrayList<Coordinate> = ArrayList()
            for (i in 0 until Constants.COORDINATES_LENGTH){
                val x = file.readDouble()
                val y = file.readDouble()
                coordinate.add(Coordinate(x,y))
            }
            data.add(Label(labelName,coordinate))
        }
        return data
    }
}