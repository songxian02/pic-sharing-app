package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ShareImageLinkButton("https://i.pinimg.com/736x/2e/11/db/2e11dbbf94318da92b97530628e5d1b2.jpg")

            }
        }
    }
}

@Composable
fun ShareImageLinkButton(imageUrl: String) {
    val context = LocalContext.current

    // Create a Box to center the content
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // Center the content in the Box
    ) {
        Button(onClick = {
            shareImageLink(context, imageUrl)
        }) {
            Text("Share Image Link")
        }
    }
}


fun shareImageLink(context: Context, imageUrl: String) {
    // Create an Intent to share the image URL
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, imageUrl) // Share as text (link)
        type = "text/plain"  // Mime type for sharing text/link
    }

    // Trigger the share intent
    context.startActivity(Intent.createChooser(intent, "Share Image"))
}