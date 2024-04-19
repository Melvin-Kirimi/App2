package com.app.anew

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.anew.ui.theme.NewTheme

class AboutActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            About()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun About()  {


    Column(
        modifier= Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
            .padding(10.dp)




    ) {

        val home = LocalContext.current
        Button(onClick = {
            home.startActivity(Intent(home, MainActivity::class.java))
        },

            colors = ButtonDefaults.buttonColors(Color.Transparent),
//            shape = RectangleShape
//            shape = RoundedCornerShape(15.dp),
            shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.LightGray)




        ) {
            Text(text = "Home page")

        }

        Text(text = "This is the about page", color= Color.Green)


        Spacer(modifier = Modifier.height(30.dp))


        val kk = AnnotatedString("Click me")
        val hh = LocalContext.current

        ClickableText(text = kk, onClick = {
            hh.startActivity(Intent(hh, MainActivity::class.java))
        })


        Spacer(modifier = Modifier.height(20.dp))


        val me = AnnotatedString("AGAIN")
        val you = LocalContext.current


        ClickableText(text = me, onClick = {
            you.startActivity(Intent(you, MainActivity::class.java))

        }
        )


        val ss = LocalContext.current
        Text(text = "Side chick",
            modifier = Modifier
                .clickable{
                    ss.startActivity(Intent(ss, MainActivity::class.java))
                })
        Image(painter = painterResource(id = R.drawable.qq), contentDescription = "null")


    }


}