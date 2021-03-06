package com.hamdy.logo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hamdy.logo.R
import com.hamdy.logo.components.Post
import com.hamdy.logo.viewmodel.MainViewModel

@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    Column(modifier = Modifier) {
        UserHeadHome()
        val listPosts by mainViewModel.listPosts.observeAsState(listOf())
        LazyColumn {
            itemsIndexed(listPosts) { _, post ->
                Divider(
                    color = colorResource(id = R.color.divider),
                    thickness = 5.dp
                )
                Post(post!!)
            }
        }
    }
}

@Composable
fun UserHeadHome() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        CircleImage(R.drawable.user_image)
        Spacer(modifier = Modifier.width(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            elevation = 3.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.share_your_food_experiences),
                    modifier = Modifier
                        .padding(start = 8.dp),
                    color = colorResource(id = R.color.light_gray)

                )
            }
        }

    }

}


@Composable
fun CircleImage(id: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(id = R.string.user_image),
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}

@Preview
@Composable
fun PreviewCircleImage() {
    CircleImage(id = R.drawable.user_image)
}

@Preview
@Composable
fun PreviewUserHeadHome() {
    UserHeadHome()
}