package uz.turgunboyevjurabek.instagramui

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(modifier:Modifier= Modifier.fillMaxSize()){
    PreviewUi()
}

@Composable
@Preview(showSystemUi = true)
fun PreviewUi(){
    Column(modifier=Modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TopBar()
        ProfileSection()
        ProfileDescription()
    }

}
@Composable
fun TopBar(modifier: Modifier= Modifier.fillMaxWidth()){

    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier= modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 15.dp)
            ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(30.dp))
        Text(text = "turg'unboyev jurabek", fontWeight =  FontWeight.Bold, color = Color.Black, fontSize = 20.sp)
        Icon(imageVector = Icons.Default.Notifications, contentDescription = null, modifier = Modifier.size(30.dp))
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, modifier = Modifier.size(30.dp))
    }
}

@Composable
fun ProfileSection(modifier: Modifier=Modifier.fillMaxWidth()){
    Row(modifier= modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {

        val img= painterResource(id = R.drawable.jurabek)
        Image(painter =img , contentDescription = null,modifier= Modifier
            .size(80.dp)
            .border(2.dp, color = Color.Gray, shape = CircleShape)
            .clip(CircleShape),
            contentScale = ContentScale.Crop)

        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "768K", fontWeight = FontWeight.Bold,color= Color.Black)
            Text(text = "followers")
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "63", fontWeight = FontWeight.Bold,color= Color.Black)
            Text(text = "following")
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "234", fontWeight = FontWeight.Bold,color= Color.Black)
            Text(text = "posts")
        }
    }
}

@Composable
fun ProfileDescription(modifier: Modifier=Modifier.fillMaxWidth()){
    Column(modifier=Modifier.padding(horizontal = 15.dp).padding(top = 20.dp),
        horizontalAlignment = Alignment.Start) {
        Text(text = "Mobile Development", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = "I've been doing mobile programming for 1 year. I'm currently learning English and Jetpack Compose 👨‍💻 ", color = Color.Black,fontSize = 15.sp)
        Text(text = "How to reach me ⤵️", color = Color.Black,fontSize = 15.sp)
        Text(text = "https://turguboyevjurabek777@gmail.com", color = Color.Blue,fontSize = 16.sp)
        Text(text = buildAnnotatedString {
            val buildStyle=SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
            append("Followed by ")
            pushStyle(buildStyle)
            append("codingflow, maikhalifa ")
            pop()
            append("and ")
            pushStyle(buildStyle)
            append("17 and others")

        })

    }
}

