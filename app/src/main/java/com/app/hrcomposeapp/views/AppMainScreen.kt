package com.app.hrcomposeapp.views

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.app.hrcomposeapp.viewmodels.JSONViewModel
//import com.app.hrcomposeapp.viewmodels.TravelJSONViewModel
import com.app.hrcomposeapp.viewmodels.TravelViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppMainScreen(
    travelViewModel: TravelViewModel,
    jsonViewModel: JSONViewModel,
) {
    val navController = rememberAnimatedNavController()
    Surface(color = MaterialTheme.colors.background) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = {
            scope.launch {
                drawerState.open()
            }
        }
        ModalDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Drawer(
                    onDestinationClicked = { route ->
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        ) {
            AppRouter(
                navController,
                travelViewModel = travelViewModel,
                jsonViewModel = jsonViewModel,
            )
        }
    }
}
