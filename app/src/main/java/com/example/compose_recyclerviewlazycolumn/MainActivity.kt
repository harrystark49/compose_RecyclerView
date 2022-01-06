package com.example.compose_recyclerviewlazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_recyclerviewlazycolumn.ui.theme.Compose_RecyclerviewLazyColumnTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_RecyclerviewLazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(contentPadding = PaddingValues( all = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(22.dp),modifier = Modifier
                            ) {

//                        itemsIndexed(items = ItemList.itemlist){index,item->
//
//                        }
                        items(items = ItemList.itemlist) { data ->
                            getdata(item = data,this@MainActivity)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_RecyclerviewLazyColumnTheme {
        Greeting("Android")
        LazyColumn(){
            items(items =ItemList.itemlist){data->

            }
        }
    }
}