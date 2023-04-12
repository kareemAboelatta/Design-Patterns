package _patterns.creational.factories.abstract_factory

// Abstract Product interfaces
interface WeatherInfo {
//" تُشير إلى معلومات عن حالة الجو الحالية أو الجو الحالي في منطقة معينة. يمكن أن تشمل درجة الحرارة الحالية،والرطوبة

    fun getTemperature(): Float
    fun getHumidity(): Float
    // Other weather-related methods...
}

interface ForecastInfo {
    //تُشير إلى معلومات عن توقعات الطقس المستقبلية في منطقة معينة.
    fun getDailyForecast(): List<String>
    fun getHourlyForecast(): List<String>
    // Other forecast-related methods...
}


// Concrete Product implementations for JSON weather data format
class JsonWeatherInfo : WeatherInfo {
    override fun getTemperature(): Float {
        // Parse temperature from JSON
        return 25.5F // Example value
    }

    override fun getHumidity(): Float {
        // Parse humidity from JSON
        return 0.6F // Example value
    }
    // Other weather-related methods...
}

class JsonForecastInfo : ForecastInfo {
    override fun getDailyForecast(): List<String> {
        // Parse daily forecast from JSON
        return listOf("Sunny", "Partly Cloudy", "Rainy") // Example values
    }

    override fun getHourlyForecast(): List<String> {
        // Parse hourly forecast from JSON
        return listOf("12:00 PM: 28°C", "1:00 PM: 29°C", "2:00 PM: 28°C") // Example values
    }
    // Other forecast-related methods...
}





// Concrete Product implementations for XML weather data format
class XmlWeatherInfo : WeatherInfo {
    override fun getTemperature(): Float {
        // Parse temperature from XML
        return 26.0F // Example value
    }

    override fun getHumidity(): Float {
        // Parse humidity from XML
        return 0.55F // Example value
    }
    // Other weather-related methods...
}

class XmlForecastInfo : ForecastInfo {
    override fun getDailyForecast(): List<String> {
        // Parse daily forecast from XML
        return listOf("Sunny", "Partly Cloudy", "Rainy") // Example values
    }

    override fun getHourlyForecast(): List<String> {
        // Parse hourly forecast from XML
        return listOf("12:00 PM: 28°C", "1:00 PM: 29°C", "2:00 PM: 28°C") // Example values
    }
    // Other forecast-related methods...
}





// Abstract Factory interface
interface WeatherAtAllDataFactory {
    fun createWeatherInfo(): WeatherInfo
    fun createForecastInfo(): ForecastInfo
}

// Concrete Factory implementations for JSON weather data format
class JsonWeatherAtAllDataFactory : WeatherAtAllDataFactory {
    override fun createWeatherInfo(): WeatherInfo {
        return JsonWeatherInfo()
    }

    override fun createForecastInfo(): ForecastInfo {
        return JsonForecastInfo()
    }
}

// Concrete Factory implementations for XML weather data format
class XmlWeatherAtAllDataFactory : WeatherAtAllDataFactory {
    override fun createWeatherInfo(): WeatherInfo {
        return XmlWeatherInfo()
    }

    override fun createForecastInfo(): ForecastInfo {
        return XmlForecastInfo()
    }
}


// Client code
class WeatherApp {
    private lateinit var weatherDataFactory: WeatherAtAllDataFactory

    fun setWeatherDataFactory(factory: WeatherAtAllDataFactory) {
        weatherDataFactory = factory
    }

    fun displayWeatherInfo() {
        val weatherInfo = weatherDataFactory.createWeatherInfo()
        val forecastInfo = weatherDataFactory.createForecastInfo()

        // Display weather information using weatherInfo and forecastInfo
        // ...
        println("----------------weather information----------------")
        println("WeatherInfo: \n - Humidity: ${weatherInfo.getHumidity()} \n - Temperature: ${weatherInfo.getTemperature()}")
        println("Forecast Info:")
        println(" - Daily Forecast")
        // forecastInfo.getDailyForecast().forEach(::print)
        println(forecastInfo.getDailyForecast())
        println(" - Hourly Forecast")
//        forecastInfo.getHourlyForecast().forEach(::print)
        println(forecastInfo.getHourlyForecast())

        println()

    }
}




fun main() {
    // Usage
    val weatherApp = WeatherApp()
    weatherApp.setWeatherDataFactory(JsonWeatherAtAllDataFactory()) // Use JSON weather data format
    weatherApp.displayWeatherInfo()
    // Display weather information using JSONWeatherInfo and JSONForecastInfo

    weatherApp.setWeatherDataFactory(XmlWeatherAtAllDataFactory()) // Use XML weather data format
    weatherApp.displayWeatherInfo()
    //Display weather information using XMLWeatherInfo and XMLForecastInfo


}












