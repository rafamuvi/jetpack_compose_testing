package me.rafamuvi.jetpack_compose_testing.screen.navigation

const val DETAIL_ARG_NAME = "name"

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Detail : Screen("detail_screen/{$DETAIL_ARG_NAME}") {
        fun passName(name: String): String {
            return this.route.replace("{$DETAIL_ARG_NAME}", name)
        }
    }
}
