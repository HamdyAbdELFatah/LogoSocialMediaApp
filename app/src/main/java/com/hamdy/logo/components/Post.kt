package com.hamdy.logo.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamdy.logo.R


@Composable
fun PostActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PostAction(
            vectorResourceId = R.drawable.ic_like,
            text = stringResource(R.string.like),
            onClickAction = {}
        )
        PostAction(
            vectorResourceId = R.drawable.ic_comment,
            text = "post.comments",
            onClickAction = {}
        )
        PostAction(
            vectorResourceId = R.drawable.ic_serch,
            text = stringResource(R.string.share),
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
fun TopBarAction(
    @DrawableRes vectorResourceId: Int,
    onClickAction: () -> Unit
) {
    Icon(
        ImageVector.vectorResource(id = vectorResourceId),
        contentDescription = stringResource(id = R.string.post_action),
        modifier = Modifier.size(20.dp),
        tint = Color.Unspecified
    )
}

@Preview
@Composable
fun PostActionsPreview() {
    PostActions()
}

@Preview
@Composable
fun PostActionPreview() {
    PostAction(R.drawable.ic_comment, "11K") {}
}