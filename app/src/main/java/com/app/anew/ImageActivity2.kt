package com.app.anew

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.app.anew.ui.theme.NewTheme

class ImageActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Picha()
        }
    }
}

@Preview(showBackground = true)

@Composable
fun Picha() {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val ww = LocalContext.current
        Text(text = "IMAGES BUTTON",
            modifier = Modifier
                .clickable {
                    ww.startActivity(Intent(ww, MainActivity::class.java))
                })


        Image(painter = painterResource(id = R.drawable.mm), contentDescription = "null")

        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            model = "https://images3.alphacoders.com/578/578596.jpg",
            contentDescription = null,
        )

        val result = remember { mutableStateOf<Uri?>(null) }
        val launcher =
            rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
                result.value = it
            }

        Column {
            Button(onClick = {
                launcher.launch(
                    PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text(text = "Select Image")
            }

            result.value?.let { image ->

                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = image)
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp, 150.dp)
                        .padding(16.dp)
                )
            }


        }


    }
}



