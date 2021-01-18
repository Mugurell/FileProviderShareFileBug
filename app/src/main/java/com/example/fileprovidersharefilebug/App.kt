package com.example.fileprovidersharefilebug

import android.app.Application
import java.io.File
import java.io.FileOutputStream

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        writeFakeImageToFiles()
    }

    private fun writeFakeImageToFiles() {
        val filesDir = File(filesDir, "images").apply { mkdirs() }
        val outputFile = File(filesDir, "fake.png")

        FileOutputStream(outputFile)
            .use { output -> "fake".byteInputStream().copyTo(output) }
    }
}
