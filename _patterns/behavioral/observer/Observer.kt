package _patterns.behavioral.observer

// 1) Observer contract
interface Observer<T> {
    fun onUpdate(value: T)
}

// 2) Subject contract
interface Subject<T> {
    fun subscribe(observer: Observer<T>)
    fun unsubscribe(observer: Observer<T>)
    fun notifyObservers()
}

// 3) Concrete Subject
class WeatherStation : Subject<Int> {

    private val observers = mutableSetOf<Observer<Int>>()
    private var temperature: Int = 0

    override fun subscribe(observer: Observer<Int>) {
        observers.add(observer)
    }

    override fun unsubscribe(observer: Observer<Int>) {
        observers.remove(observer)
    }

    fun setTemperature(newTemp: Int) {
        temperature = newTemp
        notifyObservers()
    }

    override fun notifyObservers() {
        for (obs in observers) {
            obs.onUpdate(temperature)
        }
    }
}

// 4) Concrete Observers
class PhoneDisplay : Observer<Int> {
    override fun onUpdate(value: Int) {
        println("PhoneDisplay: temp = $value")
    }
}

class CarDisplay : Observer<Int> {
    override fun onUpdate(value: Int) {
        println("CarDisplay: temp = $value")
    }
}

// 5) Usage
fun main() {
    val station = WeatherStation()

    val phone = PhoneDisplay()
    val car = CarDisplay()

    station.subscribe(phone)
    station.subscribe(car)

    station.setTemperature(25) // both notified

    station.unsubscribe(car)

    station.setTemperature(30) // only phone notified
    station.setTemperature(40) // only phone notified
    station.subscribe(car)

    station.setTemperature(42) // only phone notified
}
