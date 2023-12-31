package uz.itschool.mchat.Screens


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uz.itschool.mchat.ChatItem
import uz.itschool.mchat.Data.Main


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, context: Context) {
    var users by remember { mutableStateOf<List<String>>(emptyList()) }


    Main.getUsers { list ->
        users = list
    }

    val user = Main.getSavedUser(context)


    Scaffold(containerColor = Color(0, 0, 0, 255), topBar = {
        TopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(253, 216, 53, 255)
        ), title = {
            IconButton(onClick = { navController.navigate("Settings") }) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Settings Icon",
                    tint = Color(108, 120, 131),
                )
            }

        }

        )

    },
            bottomBar = {
        BottomAppBar(containerColor = Color(253,216,53,255)) {
           IconButton(
                onClick = {
                    Main.saveUser(context, "")
                    navController.navigate("SignIn")
                }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null,
                    tint = Color(108,120,131),
                )
            }

        }}
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 17.dp)
                .padding(innerPadding)
        ) {
            items(users) { item ->
                ChatItem(name = item, navController)
            }
        }
    }


}