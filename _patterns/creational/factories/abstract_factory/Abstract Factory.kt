package _patterns.creational.factories.abstract_factory


/**
 * # Abstract Factory Design Pattern
 *
 * **Type**: Creational
 *
 * **Definition**:
 * The Abstract Factory Design Pattern provides an interface for creating families of related or
 * dependent objects without specifying their concrete classes. It helps you create objects that
 * are designed to work together in a unified way.
 *
 * It is useful when you need objects that belong to a common family but want to hide the details
 * of their creation. It promotes loose coupling and ensures that objects created by a factory
 * are compatible and work together.
 *
 * **Components**:
 * - **Abstract Factory**: Defines methods for creating objects of different types or variants
 * - **Concrete Factory**: Implements the Abstract Factory, creates specific product objects
 * - **Abstract Product**: Defines the interface for products created by the Abstract Factory
 * - **Concrete Product**: Implements the Abstract Product interface, belongs to a common family
 *
 * **Notes**:
 * - You want to create groups of related objects
 * - You don't want to care about the specific classes of those objects
 * - You want a way to switch entire groups at once
 * - Abstract Factory creates a factory interface that produces families of related objects
 * - You can swap different implementations of this factory to get different object families
 */
const val AbstractFactory = "AbstractFactory"













