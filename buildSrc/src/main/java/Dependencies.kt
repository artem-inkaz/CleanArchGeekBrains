import org.gradle.api.JavaVersion

object Config {
//    const val kotlin_version = "1.4.21"
    const val application_id = "ui.smartpro.cleanarchgeekbrains"
    const val compile_sdk = 31
    const val min_sdk = 21
    const val target_sdk = 31
    const val buildTools_version = "30.0.3"
    val java_version = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}

object Releases {
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val model = ":model"
    const val repository = ":repository"
    const val utils = ":utils"
    const val translate = ":translate"
}

object Versions {
    //Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"
    const val recyclerview = "1.1.0"
    const val legacy = "1.0.0"
    const val splashscreen = "1.0.0-alpha02"

    //Kotlin
    const val core = "1.6.0"
    const val stdlib = "1.4.21"
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.0"
    const val liveData = "2.3.1"
    const val viewModel = "2.3.1"

    //Rx
    const val rxJava = "2.2.20"
    const val rxKotlin = "2.4.0"
    const val rxAndroid = "2.1.1"

    //ViewBinding
    const val viewBinding = "1.4.6"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.6.0"
    const val loggingInterceptor = "4.9.1"
    const val adapterCoroutines = "0.9.2"
    const val adapterRxJava2 = "2.9.0"
    const val serializationJson = "1.0.1"

    //Serialization
    const val serializationConverter = "0.8.0"
    const val googleGson = "2.8.6"

    //Navigation
    const val navigationFragment = "2.3.5"
    const val navigationUi = "2.3.5"

    //Koin
    const val koinAndroid = "2.0.1"
    const val koinViewModel = "2.0.1"
    const val koinScope = "2.0.1"

    //Room
    const val roomKtx = "2.3.0"
    const val runtime = "2.3.0"
    const val roomCompiler = "2.3.0"
    const val roomRxJava2 = "2.3.0"

    //Test
    const val jUnit = "4.13.2"
    const val runner = "1.1.3"
    const val espressoCore = "3.4.0"
    const val assertj_core = "3.21.0"
}
object Design {
    const val appcompat =  "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material =  "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val splashscreen = "androidx.core:core-splashscreen:${Versions.splashscreen}"
}

object Kotlin {
    const val stdlib =  "org.jetbrains.kotlin:kotlin-stdlib:${Versions.stdlib}"
    const val core =  "androidx.core:core-ktx:${Versions.core}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
}

object ViewBinding {
    const val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBinding}"
}

object Koin {
    const val koinAndroid = "org.koin:koin-android:${Versions.koinAndroid}"
    const val koinViewModel = "org.koin:koin-androidx-scope:${Versions.koinViewModel}"
    const val koinScope = "org.koin:koin-androidx-viewmodel:${Versions.koinScope}"
}

object Rx {
    const val rxJava =  "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxKotlin =  "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val rxAndroid =  "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
}

object Retrofit {
    const val loggingInterceptor = ("com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}")
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val adapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.adapterRxJava2}"
    const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverter}"
    const val adapterCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.adapterCoroutines}"
}

object Serialisation {
    const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationJson}"
    const val googleGson = "com.google.code.gson:gson:${Versions.googleGson}"
}

object Navigation {
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragment}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUi}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
    const val room_rxjava = "androidx.room:room-rxjava2:${Versions.roomRxJava2}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val assertj_core = "org.assertj:assertj-core:${Versions.assertj_core}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}