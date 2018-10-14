package files

import Constants
import models.Background
import models.FAMRegister
import java.io.IOException
import java.io.RandomAccessFile

class FAMFileHandler {

    /**
     * Principal function to write over the random access file
     */
    @Throws(IOException::class)
    fun write(register: FAMRegister) {
        val file = RandomAccessFile(Constants.FAM_FILE, "rw")
        file.seek(file.length())

        writeString(register.outputName,file)
        file.writeDouble(register.outputMembership)
        writeAntecedents(register.antecedents,file)

        println("Written over fuzzy_access_matrix_master, position: ${file.filePointer/Constants.LV_REGISTER_SIZE} " +
                "name: ${register.outputName}")

        file.close()
    }

    /**
     * Principal function to read from the random access file
     */
    @Throws(IOException::class)
    fun read(position: Long = 0){
        val file = RandomAccessFile(Constants.FAM_FILE, "rw")
        file.seek(position*Constants.FAM_REGISTER_SIZE)
        var position = position
        while(file.length()>file.filePointer){
            val name = readString(file)
            val nameMembership = file.readDouble()
            val inputs = readInputs(file)
            println("//-----Some register------//")
            println("output: $name")
            println("outputMembership: $nameMembership")
            println("Position: $position")
            println("File pointer: ${file.filePointer}")
            inputs.forEach {
                println("input: ${it.inputName} memebership: ${it.inputMembership}")
            }
            position++
        }
    }

    /**
     * Principal function to update over the random access file
     */
    @Throws(IOException::class)
    fun update(register: FAMRegister, position: Int) {
        val file = RandomAccessFile(Constants.FAM_FILE, "rw")
        file.seek((position*Constants.FAM_REGISTER_SIZE).toLong())

        writeString(register.outputName,file)
        file.writeDouble(register.outputMembership)
        writeAntecedents(register.antecedents,file)

        println("Updated over fuzzy_access_matrix_master, position: ${file.filePointer/Constants.LV_REGISTER_SIZE} " +
                "name: ${register.outputName}")

        file.close()
    }

    /**
     * Principal function to delete over the random access file
     */
    @Throws(IOException::class)
    fun delete(position: Int) {
        val file = RandomAccessFile(Constants.FAM_FILE, "rw")
        file.seek((position*Constants.FAM_REGISTER_SIZE).toLong())

        writeString("",file)

        println("Deleted over fuzzy_access_matrix_master, position: ${file.filePointer/Constants.LV_REGISTER_SIZE}")

        file.close()
    }

    private fun writeAntecedents(labels: ArrayList<Background>, file: RandomAccessFile){
        for (i in 0 until Constants.ANTECEDENTS_LENGTH) {
            if (labels.size>i){
                writeString(labels[i].inputName,file)
                file.writeDouble(labels[i].inputMembership)
            }else{
                writeString("",file)
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

    private fun readInputs(file: RandomAccessFile): ArrayList<Background>{
        val data: ArrayList<Background> = ArrayList()
        for (input in 0 until Constants.ANTECEDENTS_LENGTH){
            val inputName = readString(file)
            val inputMembership = file.readDouble()
            data.add(Background(inputName,inputMembership))
        }
        return data
    }
}