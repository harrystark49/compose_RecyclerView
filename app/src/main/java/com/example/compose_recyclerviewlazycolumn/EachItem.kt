package com.example.compose_recyclerviewlazycolumn

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.example.compose_recyclerviewlazycolumn.ui.theme.Compose_RecyclerviewLazyColumnTheme

@ExperimentalMaterialApi
@Composable
fun getdata(item:items,context: Context){
    androidx.compose.material.Surface(onClick = {
        var i = Intent(context,MainActivity2::class.java)
        i.putExtra("items",item)
        context.startActivity(i)
        Toast.makeText(context, "boom", Toast.LENGTH_SHORT).show()
    }) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "${item.id}")
            Text(text = "${item.name}")
            var painter= rememberImagePainter(data = item.img, builder = {
                placeholder(R.drawable.ic_launcher_background)
                crossfade(1000)
                error(R.drawable.ic_launcher_background)
                transformations(
//                CircleCropTransformation(),
////                BlurTransformation(LocalContext.current),
////                RoundedCornersTransformation(50f)
                )
            })
            var painterstate=painter.state
            Image(painter = painter, contentDescription ="image", Modifier
                .height(50.dp)
                .width(50.dp))
            if(painterstate is ImagePainter.State.Loading){
                CircularProgressIndicator()
            }
        }
    }

}

