val room_version = "2.6.1"

plugins {
    id("com.android.application") // Plugin para aplicação Android
    id("org.jetbrains.kotlin.android") // Suporte ao Kotlin para Android
    id("com.google.devtools.ksp") // Necessário para usar KSP com Room
    id("org.jetbrains.kotlin.plugin.compose") // Para suporte ao Jetpack Compose
}

android {
    namespace = "com.example.kotlingabiebruno"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kotlingabiebruno"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true // Habilita o Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Substitua pela versão correta do Compose Compiler
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Dependências do Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version") // Processador de anotações para Room

    // Dependências do Compose (garanta que estas estão configuradas no seu projeto)
    implementation("androidx.compose.ui:ui:1.5.3")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.compose.ui:ui-tooling:1.5.3")

    // Dependências padrão do Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Dependências de teste
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

ksp {
    arg("room.incremental", "true") // Habilita processamento incremental para Room
}
