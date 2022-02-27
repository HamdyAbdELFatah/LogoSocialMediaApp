package com.hamdy.logo.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamdy.logo.App
import com.hamdy.logo.R
import com.hamdy.logo.model.UserPostsItem
import com.hamdy.logo.screens.CircleImage

@Composable
fun Post(
    post: UserPostsItem,
) {
    Card(shape = MaterialTheme.shapes.large) {
        Column(
            modifier = Modifier.padding(
                top = 8.dp,
                bottom = 8.dp
            )
        ) {
            Header(post)
            Spacer(modifier = Modifier.height(4.dp))
            PostContent(post)
            Spacer(modifier = Modifier.height(8.dp))
            PostActions(post)
        }
    }
}

@Composable
fun PostContent(post: UserPostsItem) {
    when (post.type) {
        1 -> {
            MenuTypeContent(post)
        }
        2 -> {
            ReviewTypeContent(post)
        }
        else -> {
            ShareTypeContent(post)
        }
    }
}

@Composable
fun MenuTypeContent(post: UserPostsItem) {
    Column {
        RectangleImage(id = gerResourceImageID(post.imageContent!!))
        HeaderContent(
            post.postDetails?.titlePost!!,
            post.postDetails.subTitle!!,
            post.postDetails.imagePost!!
        )
        GradientButton()
    }
}

@Composable
fun ShareTypeContent(post: UserPostsItem) {
    Card(modifier = Modifier.padding(16.dp), elevation = 3.dp) {
        Column {
            HeaderContent(
                post.postDetails?.name!!,
                post.postDetails.date!!,
                post.postDetails.imageUser!!
            )
            Title(text = post.postDetails.postTitle!!)
            RectangleImage(id = gerResourceImageID(post.postDetails.imageContent!!))
            HeaderContent(
                post.postDetails.titlePost!!,
                post.postDetails.subTitle!!,
                post.postDetails.imagePost!!
            )
        }
    }
}

@Composable
fun ReviewTypeContent(post: UserPostsItem) {
    Row(modifier = Modifier) {
        RectangleImage(id = gerResourceImageID(post.imageListContent?.get(0)!!),
            Modifier.weight(1F)
        )
        Column(Modifier.weight(1F)) {
            for (i in 1 until post.imageListContent.size) {
                RectangleImage(
                    id = gerResourceImageID(post.imageListContent[i]!!),
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
        }
    }
    HeaderContent(
        post.postDetails?.titlePost!!,
        post.postDetails.subTitle!!,
        post.postDetails.imagePost!!,
    )
}

fun gerResourceImageID(name: String): Int {
    return App.context!!.resources.getIdentifier(
        name,
        "drawable",
        App.context?.packageName
    )
}

@Composable
fun PostActions(
    post: UserPostsItem,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PostAction(
            vectorResourceId = R.drawable.ic_like,
            text = post.like!!,
            onClickAction = {}
        )
        PostAction(
            vectorResourceId = R.drawable.ic_comment,
            text = post.comment!!,
            onClickAction = {}
        )
        PostAction(
            vectorResourceId = R.drawable.ic_share,
            text = post.share!!,
            onClickAction = {}
        )
    }
}

@Composable
fun PostAction(
    @DrawableRes vectorResourceId: Int,
    text: String,
    onClickAction: () -> Unit
) {
    Box(modifier = Modifier.clickable(onClick = onClickAction)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = text, fontWeight = FontWeight.Medium, color = Color.Gray, fontSize = 12.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                ImageVector.vectorResource(id = vectorResourceId),
                contentDescription = stringResource(id = R.string.post_action),
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified
            )
        }
    }
}


@Composable
fun Header(
    post: UserPostsItem,
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        HeaderContent(post.name!!, post.date!!, post.image!!)
        MoreActionsMenu()
    }
    Title(text = post.title!!)
}

@Composable
fun HeaderContent(title: String, subTitle: String, image: String, job: String = "") {
    Row(
        modifier = Modifier.padding(start = 16.dp),
        verticalAlignment = Alignment.Top
    ) {
        val resID: Int =
            App.context!!.resources.getIdentifier(image, "drawable", App.context!!.packageName)
        CircleImage(id = resID, modifier = Modifier.padding(top = 8.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
            )
            Text(
                text = subTitle + job,
                color = colorResource(id = R.color.light_gray)
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Composable
fun GradientButton() {
    Text(
        text = "View Menu",
        color = colorResource(id = R.color.text_button_gradient),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {})
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(id = R.color.blue).copy(0.36f),
                        colorResource(id = R.color.pink).copy(0.36f)
                    )
                ),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
    )
}

@Composable
fun MoreActionsMenu() {
    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { }) {
            ActionIcon(iconId = R.drawable.ic_menu)
        }
    }
}

@Composable
fun Title(text: String) {
    Text(
        text = text,
        maxLines = 3,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = colorResource(id = R.color.dark_gray),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun RectangleImage(id: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(id = R.string.user_image),
        modifier = modifier
    )
}

val previewData = UserPostsItem(
    name = "hamdy",
    image = "R.drawable.user_image",
    date = "2 days ago",
    title = "Hello world",
    like = "1K",
    comment = "12",
    share = "660"
)

@Preview
@Composable
fun HeaderPreview() {
    Header(
        previewData
    )
}

@Preview
@Composable
fun PostActionsPreview() {
    PostActions(
        previewData
    )
}

@Preview
@Composable
fun PostActionPreview() {
    PostAction(R.drawable.ic_comment, "11K") {}
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton()
}