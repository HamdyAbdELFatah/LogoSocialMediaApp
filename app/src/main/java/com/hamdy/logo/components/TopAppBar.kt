package com.hamdy.logo.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hamdy.logo.R

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = {
            Icon(
                ImageVector.vectorResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.app_name),
                tint = Color.Unspecified
            )
        },
        backgroundColor = Color.White,
        actions = {
            IconButton(onClick = {}) {
                    ActionIcon(iconId = R.drawable.ic_serch)
            }
            TopBarActionIcon(up = false, iconId = R.drawable.ic_bell)
            TopBarActionIcon(up = true, iconId = R.drawable.ic_cart)
        }
    )
}

@Composable
fun ActionIcon(iconId: Int, modifier: Modifier = Modifier) {
    Icon(
        ImageVector.vectorResource(id = iconId),
        contentDescription = stringResource(id = R.string.top_bar_action),
        tint = Color.Unspecified,
        modifier = modifier
    )
}

@Composable
fun TopBarActionIcon(up: Boolean, iconId: Int) {
    IconButton(onClick = { /* doSomething() */ }) {
        ConstraintLayout(
            Modifier
                .wrapContentSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            val (icon, badge) = createRefs()
            ActionIcon(
                iconId = iconId,
                modifier = Modifier.constrainAs(icon) { top.linkTo(parent.top) },
            )
            ActionIcon(
                iconId = R.drawable.ic_notfication,
                modifier = Modifier
                    .size(11.dp)
                    .constrainAs(badge) {
                        if (up) {
                            top.linkTo(icon.top)
                            bottom.linkTo(icon.top)
                        } else
                            bottom.linkTo(icon.bottom, margin = 2.dp)
                        start.linkTo(icon.end)
                        end.linkTo(icon.end)
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewMYTopAppBar() {
    MyTopAppBar()
}

@Preview
@Composable
fun PreviewTopBarActionIcon() {
    TopBarActionIcon(up = false, iconId = R.drawable.ic_bell)
}


