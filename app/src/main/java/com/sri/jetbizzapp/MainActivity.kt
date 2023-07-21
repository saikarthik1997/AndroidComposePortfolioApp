package com.sri.jetbizzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sri.jetbizzapp.ui.theme.JetBizzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier.padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Column(
                modifier=Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.height(10.dp))
                CreateImageProfile()
                Divider()
                CreateInfo()
            }
        }

    }
}

@Composable
fun CreateImageProfile(modifier: Modifier=Modifier){
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)) {

        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)

    }
}

@Composable
private fun CreateInfo(){
    Column(modifier=Modifier.padding(5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Sai Karthik Sistla", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
        Text(text = "Android/Flutter Developer", modifier = Modifier.padding(3.dp))
        Text(text = "@saikarthik", modifier = Modifier.padding(3.dp), style = MaterialTheme.typography.titleSmall)
    }
}

@Preview(showSystemUi = true, apiLevel = 32)
@Composable
fun DefaultPreview() {
    JetBizzAppTheme {
        CreateBizCard()
    }
}