package uz.itschool.mchat.Nav

import android.content.Context
import android.os.Build

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import uz.itschool.mchat.Screens.ChatScreen

import uz.itschool.mchat.Screens.HomeScreen
import uz.itschool.mchat.Screens.SettingsScreen
import uz.itschool.mchat.Screens.SignInScreen
import uz.itschool.mchat.Screens.SignUpScreen
import uz.itschool.mchat.Screens.SplashScreen


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(navController: NavHostController,context: Context) {
    NavHost(navController = navController, startDestination = Screens.Splash.route) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route) {
            HomeScreen(navController,context)
        }
        composable(route = Screens.SignIn.route) {
            SignInScreen(navController)
        }
        composable(route = Screens.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(route = Screens.Settings.route) {
            SettingsScreen(navController)
        }
        composable(route = Screens.Chat.route, arguments = listOf(navArgument(NAME_KEY) {
            type = NavType.StringType
        })) { navBackStackEntry ->
            val name = navBackStackEntry.arguments?.getString(NAME_KEY)
            if (name != null) {
                ChatScreen(name = name, navController = navController)
            }
        }
    }
}