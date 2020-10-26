# Developing-Android-Apps-Kotlin-Part2
 
__This repo is part 2 for what I learned from:__ 
* <a href="https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012" target="_blank">**Android App Development in Kotlin course by Udacity.**</a>  
* and those codelabs <a href="https://codelabs.developers.google.com/android-kotlin-fundamentals/"  target="_blank"> **Android Kotlin Fundamentals.**</a>

##
## 6- RoomDB and coroutines - SleepTracker App
The app is a demo app that helps you collect information about your sleep, such as start time, end time quality and time slept.
The app uses a database to store sleep data over time.

This app demonstrates the following views and techniques:
* **Room Database** to store, retrieve, and update our data.
* SleepNight **DataClass** to define a database table and its structure.
* **Data Access Object** to define the API for our database,
* Made a room database **Singleton**.
* new model **factory** to implement a very basic dependency injection.
* **ViewModels** to manage our database operations and handle user clicks.
* **Coroutines** to make sure the database operations don't interfere with a smooth user experience.
* implementing observable state variables to keep UI operations, such as navigation in the fragment.

## Code Link
* <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part2/tree/main/SleepTracker"  target="_blank"> **SleepTracker App**</a> 

### Screenshots
|  | | |
| :---: |:---:| :---:|
| ![startSleeping](https://user-images.githubusercontent.com/18370055/97105093-3fcf9500-16c1-11eb-99c9-1043a78bfb71.PNG) | ![sleepQuality](https://user-images.githubusercontent.com/18370055/97105092-3f36fe80-16c1-11eb-980b-5ba7a16d4fa7.PNG) | ![allSleepingData](https://user-images.githubusercontent.com/18370055/97105091-3e9e6800-16c1-11eb-9e62-a9e46078ed56.PNG) |
##
