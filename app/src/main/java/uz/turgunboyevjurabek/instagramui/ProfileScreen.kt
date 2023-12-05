package uz.turgunboyevjurabek.instagramui

import android.content.Context
import android.graphics.fonts.FontStyle
import android.text.Highlights
import android.view.Display.Mode
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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

    val context= LocalContext

        Column(
            modifier=Modifier
                .verticalScroll(rememberScrollState())
                .wrapContentSize(unbounded = true),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TopBar()
            ProfileSection()
            ProfileDescription()
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            buttonSection(list = listOf(
                TextWithImage(Icons.Default.KeyboardArrowDown,"Following"),
                TextWithImage(image = null,"Message"),
                TextWithImage(image = null,"Email"),
                TextWithImage(Icons.Default.KeyboardArrowDown, text = null),
            ))
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            HighlightedSection(list = listOf(
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek"),
                Story(painterResource(id = R.drawable.jurabek),"Jurabek")
            ))
            var selectedTabIndex by remember {
                mutableStateOf(0)
            }
            Spacer(modifier = Modifier.height(10.dp))
            TabRowView(list = listOf(
                Story(painterResource(id = R.drawable.ic_calendar),null),
                Story(painterResource(id = R.drawable.ic_reels),null),
                Story(painterResource(id = R.drawable.ic_calendar),null),
                Story(painterResource(id = R.drawable.ic_reels),null)
            ),
                onTabSelected = {
                    selectedTabIndex=it
                })

            PostSection(post = listOf(
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek),
                painterResource(id = R.drawable.jurabek)
            ))

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
            .size(90.dp)
            .border(2.dp, color = Color.Gray, shape = CircleShape)
            .clip(CircleShape),
            contentScale = ContentScale.Crop)

        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "768K", fontWeight = FontWeight.Bold,color= Color.Black, fontSize = 20.sp)
            Text(text = "followers")
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "63", fontWeight = FontWeight.Bold,color= Color.Black,fontSize = 20.sp)
            Text(text = "following")
        }
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "234", fontWeight = FontWeight.Bold,color= Color.Black,fontSize = 20.sp)
            Text(text = "posts")
        }
    }
}

@Composable
fun ProfileDescription(modifier: Modifier=Modifier.fillMaxWidth()){
    Column(modifier= Modifier
        .padding(horizontal = 15.dp)
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.Start) {
        Text(text = "Mobile Development", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = "I've been doing mobile programming for 1 year.\nI'm currently learning English and Jetpack Compose", color = Color.Black,fontSize = 13.sp)
        Text(text = "How to reach me ⤵️", color = Color.Black,fontSize = 13.sp)
        Text(text = "https://turguboyevjurabek777@gmail.com", color = Color.Blue,fontSize = 13.sp)
        Text(text = buildAnnotatedString {
            val buildStyle=SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
            append("Followed by ")
            pushStyle(buildStyle)
            append("codingflow, maikhalifa ")
            pop()
            append("and ")
            pushStyle(buildStyle)
            append("17 and others")})
    }
}


@Composable
fun buttonSection(modifier: Modifier= Modifier,list: List<TextWithImage>){
    Row(modifier=modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {

            list.forEachIndexed{index, textWithImage ->
                ActionButton(textWithImage = textWithImage)
            }
            
        }
    }

}

@Composable
fun ActionButton(textWithImage: TextWithImage,modifier: Modifier= Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(5.dp)

    ) {
        if (textWithImage.text!=null){
            Text(text = textWithImage.text?:"", fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
        }
        if (textWithImage.image !=null){
            Icon(imageVector = textWithImage.image, contentDescription = null)
        }

    }
}

@Composable
fun HighlightedSection(
    list: List<Story>,
    modifier: Modifier= Modifier
        .fillMaxWidth()
        .padding(horizontal = 5.dp)) {

    LazyRow(modifier=modifier.fillMaxWidth(),
        horizontalArrangement =Arrangement.SpaceAround){
        items(list.size){
            StoryItem(story = list[it])
        }
    }


}

@Composable
fun StoryItem(
    story: Story,
    modifier: Modifier= Modifier.fillMaxWidth()){

    Column(modifier= modifier
        .fillMaxWidth()
        .padding(horizontal = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Image(
            painter = story.image!!,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier= Modifier
                .size(65.dp)
                .aspectRatio(1f)
                .border(
                    width = 2.dp,
                    shape = CircleShape,
                    color = Color.Gray
                )
                .clip(CircleShape))
        Text(text = story.name!!, fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.Black)

    }
}

@Composable
fun TabRowView(
    list: List<Story>,
    modifier: Modifier=Modifier,
    onTabSelected:(selectedIndex:Int)->Unit
) {
    var selectTabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selectTabIndex) {
        list.forEachIndexed{index, story ->
        Tab(
            selected = selectTabIndex==index,
            selectedContentColor = Color.Black,
            unselectedContentColor = Color(0xFF777777),
            onClick = {
                selectTabIndex=index
                onTabSelected(index)
            }){
            Icon(painter = story.image!!,
                contentDescription = story.name,
                tint = if (selectTabIndex==index) Color.Black else Color(0xFF777777),
                modifier= Modifier
                    .padding(10.dp)
                    .size(30.dp))

        }

        }
        
    }
}

@Composable
fun PostSection(
    post:List<Painter>,
    modifier: Modifier= Modifier
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxWidth()
            .scale(1.01f)
           ){
        items(post.size){
            Image(painter = post[it],
                contentScale = ContentScale.Crop,
                contentDescription = null,

                modifier= Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    ))
        }
    }

}