# Private Constructors and Factories

## Last time
* Object equality (`equals()`).
* ... and `hashCode()`.
* It's not a "secure hash", so collistions are OK!

## Some more Error Handling (Chapter 6)

* "Checked" vs. "Unchecked" Exceptions.
* Stacktraces.

## Introduce Collections (Chapter 7) and Generics

* Collection Type (Interface).
* and more specific Type like `Set` (also Interfaces).
* Implementations usually don't matter but we need to decide.
  * What's more efficient in our use case, `LinkedList` or `ArrayList`?
  * Can we use a `HashSet`
* Using Generics can be tricks due to "runtime type erasure" ...
  * IMHO this is one of the ugliest places in Java.
  * See "Why Isn’t a `List<Date>` a `List<Object>`"