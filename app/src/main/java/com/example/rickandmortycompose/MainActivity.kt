package com.example.rickandmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortycompose.characterdetail.CharacterDetailScreen
import com.example.rickandmortycompose.characterlist.CharacterListScreen
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHostHolder()
                }
            }
        }
    }

    @Composable
    private fun NavHostHolder() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "characterList") {
            composable(route = "characterList") {
                CharacterListScreen { character ->
                    navController.navigate("characterDetail/${character.id}")
                }
            }
            composable(
                route = "characterDetail/{characterId}",
                arguments = listOf(navArgument("characterId") { NavType.StringType })
            ) { backStackEntry ->
                val characterId =
                    backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                        ?: return@composable
                CharacterDetailScreen(
                    characterId = characterId,
                    onBackPress = {
                        navController.popBackStack()
                    }, onFavoriteClick = { character ->
                    println(character)
                }
                )
            }
        }
    }
}
