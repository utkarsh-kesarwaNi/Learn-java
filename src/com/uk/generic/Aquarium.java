package com.uk.generic;

/*
 * Generics provide a facility for parametric polymorphism for class, interface and methods.
 */
public class Aquarium<T> {

    private T fish;

    public void addFish(T fish) {
        this.fish = fish;
    }

    public T getFish() {
        return fish;
    }

    /*
     * BEHIND THE SCENES (TYPE ERASURE): The Java Virtual Machine (JVM) knows absolutely NOTHING about generics.
     * Generics are a COMPILE-TIME FICTION.
     *
     * When the Java compiler compiles `Aquarium<T>`, it performs "Type Erasure".
     * It replaces all generic parameters (T) with their lowest bound (Object, if unbounded).
     *
     * The actual bytecode produced for Aquarium.class looks exactly like this:
     * public class Aquarium {
     *     private Object fish;
     *     public void setItem(Object fish) { this.fish = fish; }
     *     public Object getFish() { return fish; }
     * }
     */

    /*
    * When a number of objects are created from the same class, each have their own distinct copies of instance variables
    *
    * Static fields or class variables are associated with the class rather than any object.
    * Only one copy of a static field exists in memory, regardless of how many objects are created which is shared across each object.
    *
    */

//    private static T staticFish;    COMPILE ERROR: Non-static type variable T cannot be referenced from a static context

//    =============================================
//    STATIC METHODS USING CLASS TYPE PARAMETER 'T'
//    =============================================

//    public static void processFish(T fish) { }  COMPILE ERROR

    /*
    * Unless you create an Aquarium object like Aquarium<Goldfish> goldfishAquarium = new Aquarium<>();
    * you have defined the type as Goldfish().
    *
    * But static method can be invoked directly, so Aquarium.processFish(new GoldFish()), the compiler has no context what 'T' is supposed to be.
    */

    public static <U> void printClassName(U item) {
        System.out.println("Static generic method invoked with: " + item.getClass().getSimpleName());
    }

    /*
     * WHY IS THIS ALLOWED?
     *
     * Here, `<U>` has absolutely NO RELATIONSHIP to the class's `<T>`.
     * `<U>` is bound at the time the method is INVOKED, not when an object is instantiated.
     *
     * When you write: `Aquarium.printClassName("String")`
     * The compiler infers `<U>` as `String` just for that specific method execution frame on the stack.
     * Type erasure still happens here: `U` erases to `Object` in the bytecode.
     */
}
