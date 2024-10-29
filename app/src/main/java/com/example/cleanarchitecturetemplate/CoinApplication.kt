package com.example.cleanarchitecturetemplate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This class initializes Hilt's dependency injection system for the entire application.
 * By annotating the application class with @HiltAndroidApp, we enable Hilt to:
 * - Generate and manage a global dependency graph accessible throughout the app.
 * - Provide application-wide dependencies (e.g., single instances of Retrofit, Database, etc.)
 * - Ensure that dependencies marked as @Singleton live as long as the application does.
 *
 * It is necessary to specify this class in the AndroidManifest (android:name=".CoinApplication")
 * so that Android knows this is the entry point of the app and initializes Hilt here.
 */
@HiltAndroidApp
class CoinApplication : Application()