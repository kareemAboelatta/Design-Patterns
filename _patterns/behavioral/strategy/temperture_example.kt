package _patterns.behavioral.strategy




/**
 * Android Programming scenario


Suppose you are developing a weather app that provides users with the current temperature of their location.

The app can use different data sources to get the temperature, such as GPS, weather APIs, or manual entry.

You can use the Strategy Design Pattern to implement this feature in the following way:


-Define a Context class called TemperatureContext that holds a reference to the current strategy and provides
an interface to the client to interact with the strategy.

The TemperatureContext class will have a method called getTemperature()that will be used to get the current temperature.

-Define a Strategy interface called TemperatureStrategy that defines the algorithm that the context will use.
The TemperatureStrategy interface will have a method called getTemperature() that will be
implemented by the concrete strategies.


-Define Concrete Strategy classes for each data source that implements the TemperatureStrategy interface and
provides the actual implementation of the algorithm.
For example, you can define GPSDataSource, WeatherAPIDataSource, and ManualEntryDataSource classes.


-In the TemperatureContext class, you can define a setTemperatureStrategy() method that will be used to set the
current strategy based on the user's preferences.

-In the getTemperature() method of the TemperatureContext class, you can call the getTemperature()
method of the current strategy to get the temperature.

By implementing the Strategy Design Pattern in this scenario, you can provide users with multiple options
to get the temperature, and the app can use different data sources without modifying its code.
 * */




interface  TemperatureStrategy{
    fun getTemperature()
}

class GPSDataSource : TemperatureStrategy{
    override fun getTemperature() {
        println("get Temperature from GPS")
    }

}

class WeatherAPIDataSource : TemperatureStrategy{
    override fun getTemperature() {
        println("get Temperature from Weather")
    }

}

class ManualEntryDataSource : TemperatureStrategy{
    override fun getTemperature() {
        println("get Temperature from ManualEntryData")
    }

}


class  TemperatureContext(private var strategy: TemperatureStrategy){
    fun setTemperatureStrategy(strategy: TemperatureStrategy){
        this.strategy  = strategy
    }
    fun getTemperature(){
        strategy.getTemperature()
    }
}


fun main() {
    var temperatureGetter =  TemperatureContext(GPSDataSource())

    temperatureGetter.getTemperature()

    temperatureGetter.setTemperatureStrategy(WeatherAPIDataSource())
    temperatureGetter.getTemperature()


}