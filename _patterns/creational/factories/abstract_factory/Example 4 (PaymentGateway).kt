
/**
 * Let's say you're developing an e-commerce app that sells different types of products, such as electronics, clothing,
 * and home goods. You have different payment gateways for each type of product, and you want to dynamically choose
 * the appropriate payment gateway based on the type of product that the user wants to purchase.
 *
 *
 * for example :
 * Vodafone cash for clothing product type
 * Visa for electronics product type
 * PayPal cash for home goods product type
 * */


// This is the ways to payment overall, so we have three Payment Methods

// Abstract Product interfaces
interface PaymentGateway {
    fun initiatePayment()
}

// Concrete Product implementations for VisaPaymentGateway for electronics product type
class VisaPaymentGateway : PaymentGateway {
    override fun initiatePayment() {
        println("Initiating payment using Visa payment gateway.")
    }
}

// Concrete Product implementations for VodafoneCashPaymentGateway for clothing product type
class VodafoneCashPaymentGateway : PaymentGateway {
    override fun initiatePayment() {
        println("Initiating payment using Vodafone Cash payment gateway.")
    }
}

// Concrete Product implementations for PaypalPaymentGateway for home goods product type
class PayPalPaymentGateway : PaymentGateway {
    override fun initiatePayment() {
        println("Initiating payment using Paypal payment gateway.")
    }
}






// Abstract Factory interface
interface PaymentGatewayFactory {
    fun createPaymentGateway(): PaymentGateway
}


// Concrete Factory implementations for different product types
class ElectronicsPaymentGatewayFactory : PaymentGatewayFactory {
    override fun createPaymentGateway(): PaymentGateway {
        return VisaPaymentGateway()
    }
}

class ClothingPaymentGatewayFactory : PaymentGatewayFactory {
    override fun createPaymentGateway(): PaymentGateway {
        return VodafoneCashPaymentGateway()
    }
}

class HomeGoodsPaymentGatewayFactory : PaymentGatewayFactory {
    override fun createPaymentGateway(): PaymentGateway {
        return PayPalPaymentGateway()
    }
}




// Client code
fun main() {
    // Determine product type dynamically (e.g., based on user selection, product category, etc.)
    val productType = "Clothing" // or "Clothing", "HomeGoods"

    // Create payment gateway using the appropriate factory based on the product type
    val paymentGatewayFactory: PaymentGatewayFactory = when (productType) {
        "Electronics" -> ElectronicsPaymentGatewayFactory()
        "Clothing" -> ClothingPaymentGatewayFactory()
        "HomeGoods" -> HomeGoodsPaymentGatewayFactory()
        else -> throw IllegalArgumentException("Invalid product type: $productType")
    }

    // Initiate payment using the created payment gateway
    val paymentGateway = paymentGatewayFactory.createPaymentGateway()
    paymentGateway.initiatePayment()
}







