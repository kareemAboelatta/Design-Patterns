package _patterns.structural



/**
 * The Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to work together
 * by providing a wrapper or adapter object that converts the interface of one object into the interface expected
 * by another object. This pattern is commonly used when you have existing classes or interfaces that cannot be directly
 * used together due to incompatible interfaces, but need to collaborate or interact with each other.
 *
 * */

interface PaymentGateway {
    fun processPayment(amount: Double): Boolean
    fun refundPayment(transactionId: String): Boolean
    // ... other common payment gateway operations
}

// PaypalGateway implementation
class PaypalGateway {
    fun sendPayment(amount: Double): Boolean {
        // Implementation for sending payment via PayPal
        println("Sending payment of $amount via PayPal")
        return true
    }

    fun refundPayment(transactionId: String): Boolean {
        // Implementation for refunding payment via PayPal
        println("Refunding payment for transaction ID: $transactionId via PayPal")
        return true
    }
    // ... other PayPal-specific operations
}

// StripeGateway implementation
class StripeGateway {
    fun createCharge(amount: Double): Boolean {
        // Implementation for creating a charge via Stripe
        println("Creating charge of $amount via Stripe")
        return true
    }

    fun refundCharge(chargeId: String): Boolean {
        // Implementation for refunding a charge via Stripe
        println("Refunding charge with ID: $chargeId via Stripe")
        return true
    }
    // ... other Stripe-specific operations
}

// Adapter for PaypalGateway
class PaypalAdapter(private val paypalGateway: PaypalGateway) : PaymentGateway {
    override fun processPayment(amount: Double): Boolean {
        return paypalGateway.sendPayment(amount)
    }

    override fun refundPayment(transactionId: String): Boolean {
        return paypalGateway.refundPayment(transactionId)
    }
    // ... other adapter methods
}

// Adapter for StripeGateway
class StripeAdapter(private val stripeGateway: StripeGateway) : PaymentGateway {
    override fun processPayment(amount: Double): Boolean {
        return stripeGateway.createCharge(amount)
    }

    override fun refundPayment(transactionId: String): Boolean {
        return stripeGateway.refundCharge(transactionId)
    }
    // ... other adapter methods
}

fun main() {
    val stripeGateway:StripeGateway = StripeGateway()

    val paymentGateway : PaymentGateway = StripeAdapter(stripeGateway)

    paymentGateway.processPayment(100.2);
    paymentGateway.refundPayment("se6x");

}