package uz.itschool.mchat.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.itschool.mchat.Data.Main

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(containerColor = Color(0, 0, 0, 255), topBar = {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(253, 216, 53, 255)
        ), title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back Icon",
                        tint = Color.White,
                    )
                }

            }
        })
    }) { innerPadding ->
        var old_password by remember { mutableStateOf(TextFieldValue("")) }
        var new_password by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(innerPadding),
        )

        {
            Row( modifier = Modifier.fillMaxWidth()) {
                Text(Main.getSavedUser(context), color = Color.White, fontSize = 30.sp , modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

            }



            OutlinedTextField(
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                value = old_password,
                onValueChange = {
                    old_password = it
                },
                label = { Text(text = "Old Password", color = Color.White) },
                placeholder = { Text(text = "Password", color = Color.White) },
            )
            OutlinedTextField(
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(disabledTextColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                value = new_password,
                onValueChange = {
                    new_password = it
                },
                label = { Text(text = "New Password", color = Color.White) },
                placeholder = { Text(text = "Password", color = Color.White) },
            )
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
                Main.setPassword(context, Main.getSavedUser(context), old_password.text, new_password.text)
            }) {
                Text(text = "Submit")
            }

        }
    }
}

