package com.example.myfirstkmmapp.android

import android.widget.Toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myfirstkmmapp.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(
        title = { Text(text = "About Device") },
    )
}


@Composable
private fun ContentView() {
    val newItems = makeItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        itemsIndexed(newItems) { index, row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

fun makeItems(): List<Pair<String, String>> {

    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("OS", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.toString())
    )
}

@Composable
private fun RowView(
    title: String,
    subtitle: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
    Divider()
}
