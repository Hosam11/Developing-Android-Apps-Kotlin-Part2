# Developing-Android-Apps-Kotlin-Part2
 
__This repo is part 2 for what I learned from:__ 
* <a href="https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012" target="_blank">**Android App Development in Kotlin course by Udacity.**</a>  
* and those codelabs <a href="https://codelabs.developers.google.com/android-kotlin-fundamentals/"  target="_blank"> **Android Kotlin Fundamentals.**</a>
* here's link to part 1 <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part1"  target="_blank"> **Developing Android Apps Kotlin Part1**</a>


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


## 7- RecyclerView - SleepTrackerWithRecyclerView App
* Use a RecyclerView to efficiently display lists and grids of items for complex lists and grids.
* Make RecyclerView more efficient and your code easier to maintain and extend. 
* DiffUtil and data binding with RecyclerView
* Make items in a RecyclerView clickable. 
* Add more than one view holder and layout to lists and grids in a RecyclerView

## Code Link
* <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part2/tree/main/SleepTrackerRecyclerView" target="_blank"> **SleepTrackerRecyclerView App**</a> 

### Screenshots
|  | | |
| :---: |:---:| :---:|
|![verticalRecyclerView](https://user-images.githubusercontent.com/18370055/97275585-c65db100-183e-11eb-96a4-0b2ee0d3879d.PNG) |  ![gridListWithTitle](https://user-images.githubusercontent.com/18370055/97275582-c52c8400-183e-11eb-9572-56fc9cb4ebad.PNG) | ![itemDetails](https://user-images.githubusercontent.com/18370055/97275584-c65db100-183e-11eb-8ede-7441419ce3e2.PNG) |

## 8- Connecting to the internet - MarsRealEstate App
* Simple demo app using ViewModel & LiveData with Retrofit, Glide and Moshi in Kotlin to dowload data from api.

This app demonstrates the following views and techniques:
* Retrofit to make api calls to an HTTP web service
* Moshi which handles the deserialization of the returned JSON to Kotlin data objects
* Glide to load and cache images by URL.
* ViewModel, LiveData, Data Binding with binding adapters
* Navigation with the SafeArgs plugin for parameter passing between fragments

## Code Link
* <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part2/tree/main/MarsRealEstate" target="_blank"> **MarsRealEstate App**</a> 

### Screenshots
|  | |
| :---: |:---:|
|![homeWithMeanu](https://user-images.githubusercontent.com/18370055/97576226-8e996980-19f6-11eb-9cba-b5bb41504cdc.PNG) | ![selectedItem](https://user-images.githubusercontent.com/18370055/97576232-90632d00-19f6-11eb-9a5a-bc54ab55a1ca.PNG)| 

##
## 9- Repository - DevBytes App

DevByte Viewer is an example app that showcases using Room and a Repository to create an offline cache.
In addition, it also covers how to use WorkManager for scheduling periodic work. In this app it's used to setup a daily background data sync.

## Code Link
* <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part2/tree/main/DevBytes" target="_blank"> **DevBytes App**</a> 

##
## 10- Designing for everyone - GDGFinder App
* GDG Finder helps you locate GDGs around the world or start one of your own. 
* The app implements principles of Material Designs

The app demonstrate the following:
* Styling system on Android themes, styles, attributes, and when each are used.
* Text appearance to style text safely.
* Material design and the material design components library.
* Configure material components theme to style your entire application.
* Support right to left languages and dark mode.
* Make app accessible for users with accessibility needs

## Code Link
* <a href="https://github.com/Hosam11/Developing-Android-Apps-Kotlin-Part2/tree/main/GDGFinder" target="_blank"> **GDGFinder App**</a> 
