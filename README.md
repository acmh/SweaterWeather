# SweaterWeather
Project for Inloco Interview

Map Screen                 |  Cities List Screen      | City Information Screen 
:-------------------------:|:-------------------------|:-------------------------
![](http://i.imgur.com/9OoYc3f.png)  |  ![](http://i.imgur.com/UMOwlcp.png)| ![](http://i.imgur.com/Vl5T9iQ.png)

## Getting Started
This sample uses the Gradle build system. To build this project, use the "gradlew build" command or use "Import Project" in Android Studio.

## Design Pattern

### MVP

> MVP (Model View Presenter) pattern is a derivative from the well known MVC (Model View Controller).
> The MVP pattern allows separate the presentation layer from the logic, so that everything about how the interface works is separated from how we represent it on screen. 
> Ideally the MVP pattern would achieve that same logic might have completely different and interchangeable views


![alt text](https://i.imgur.com/xbeB5.png "Difference beetween MVP and MVC")
 <p align="justify">
   *Difference beetween MVP and MVC*
</p>


### How to implement MVP for Android

#### The Presenter
  The presenter is responsible to act as the middle man between view and model. It retrieves data from the model and returns it formatted to the view. But unlike the typical MVC, it also decides what happens when you interact with the view.
#### The Model
  This component encapsulates all Business Logic and Data in the application. This may be a database transaction or a call to a web service. 
#### The View
  This defines the methods that the concrete View aka Fragment will implement. This way you can proceed to create and test the Presenter without worrying about Android-specific components such as Context.
#### The Contract
  The Contract is the glue that binds the participating components in MVP pattern together. It is nothing but the good old Java interface that defines the responsibility of the Model, the View and the Presenter.

## Tech Specs

### Rest Client used: Retrofit

[Comparison  of AsyncHttp ,Volley and Retrofit](https://instructure.github.io/blog/2013/12/09/volley-vs-retrofit/)

![alt text](http://i.imgur.com/tIdZkl3.png "Comparison  of AsyncHttp ,Volley and Retrofit")
 <p align="justify">
   *Comparison  of AsyncHttp ,Volley and Retrofit*
</p>


