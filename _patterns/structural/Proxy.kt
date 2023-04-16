package _patterns.structural


/**
 * The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for an object to control
 * access to it or to add additional functionality. It allows for a level of indirection when accessing an object,
 * providing an additional layer of abstraction.

The Proxy pattern typically involves three main components:

-Subject: This is the interface or the common interface that the Proxy and RealSubject (the actual object being proxied) implement.
It defines the operations that both the Proxy and RealSubject must implement.

-Proxy: This is the class that acts as a surrogate or placeholder for the RealSubject.
It implements the same interface as the Subject, but may add additional behavior, such as caching, logging,
or access control, before or after delegating the operation to the RealSubject.

-RealSubject: This is the actual object that the Proxy is representing. It is the object that the Proxy provides a
surrogate for, and the object that the Proxy ultimately delegates the operation to.

The Proxy pattern can be used in various scenarios, such as:

->Remote Proxy: The Proxy acts as a local representative for a remote object, allowing clients to interact with the remote object indirectly, as if it were a local object.

->Virtual Proxy: The Proxy acts as a placeholder for expensive or resource-intensive objects, delaying their creation or loading until they are actually needed, in order to optimize performance and resource usage.

->Protection Proxy: The Proxy controls access to a sensitive or protected object, enforcing access control rules or permissions before allowing clients to access the object.
 * */


data class Employ(val name: String, val securityLevel: Int)


//Subject
interface Internet {
    fun grantInternetAccess(employ: Employ)
}

//Proxy
//act as firewall but is has a RealInternetConnection face
class ProxyInternet : Internet {
    override fun grantInternetAccess(employ: Employ) {
        if (employ.securityLevel > 10) {
            RealInternetConnection().grantInternetAccess(employ)
        } else {
            println("Permission Denied")
        }
    }

}

//RealSubject
// real window to real internet anyone can access the internet
class RealInternetConnection : Internet {
    override fun grantInternetAccess(employ: Employ) {
        println("grant internet connection for ${employ.name}")
    }
}


fun main() {
    val employ = Employ(name = "Youssef", securityLevel = 7)
    val manager = Employ(name = "Kareem", securityLevel = 17)




    println("-------------Without proxy --------------")

    // keda ha5ly ay 7d y3mel access to internet directly
    RealInternetConnection().grantInternetAccess(employ = employ)
    RealInternetConnection().grantInternetAccess(employ = manager)





    println("-------------With proxy--------------")


    //keda fy proxy or firewall to manage who can access the internet according some security
    ProxyInternet().grantInternetAccess(employ = employ) // employ can't access the internet
    ProxyInternet().grantInternetAccess(employ = manager)
}



