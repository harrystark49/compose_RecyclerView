package com.example.compose_recyclerviewlazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.compose_recyclerviewlazycolumn.ui.theme.Compose_RecyclerviewLazyColumnTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_RecyclerviewLazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    var bundle=intent.extras
                    var data=bundle?.get("items") as items
                    
                    Column(Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                            Log.d("name","${data.name.toString()}")
                            Text(text = data.name.toString(), modifier = Modifier
                                .background(MaterialTheme.colors.onPrimary)
                                ,fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.h6.fontSize
                            )
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(150.dp),
                            contentAlignment = Alignment.Center) {
                                var painter= rememberImagePainter(data = data.img,builder ={
                                    placeholder(R.drawable.ic_launcher_background)
                                    transformations(
                                        CircleCropTransformation()
                                    )
                                }
                                )
                                Image(painter = painter, contentDescription = "image")
                            }
                        }
                        
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Compose_RecyclerviewLazyColumnTheme {
        Greeting2("Android")
    }
}