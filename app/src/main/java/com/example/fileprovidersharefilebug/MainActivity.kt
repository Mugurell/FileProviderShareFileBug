package com.example.fileprovidersharefilebug

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.shareButton).setOnClickListener {
            shareFile(File("$filesDir/images", "test.png"))
        }
    }

    private fun shareFile(fileToShare: File) {
        val contentUri = FileProvider.getUriForFile(
            this,
            "com.example.fileprovidersharefilebug",
            fileToShare
        )

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = contentResolver.getType(contentUri)
            flags = Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_GRANT_READ_URI_PERMISSION
            putExtra(Intent.EXTRA_STREAM, contentUri)
        }

        val shareIntent = Intent.createChooser(intent, "Check logs for error").apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        return try {
            startActivity(shareIntent)
        } catch (error: Exception) {
            // ignore as usual
        }
    }
}
