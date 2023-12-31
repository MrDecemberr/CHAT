package uz.itschool.mchat.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import uz.itschool.mchat.Data.Main
import uz.itschool.mchat.R

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(1250)
        if (Main.getSavedUser(context) == "") navController.navigate("SignIn")
        else navController.navigate("Home")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0, 0, 0, 255)),
        contentAlignment = Alignment.Center,
    ) {
Image(painter = painterResource(id = R.drawable.tw), contentDescription ="Toga", modifier = Modifier.size(200.dp) )    }
}