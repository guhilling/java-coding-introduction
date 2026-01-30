# Generics and Sorting

## Recap: Exception Handling (Chapter 6)

* "Checked" vs. "Unchecked" Exceptions.
* Stacktraces.

## Introduce Collections (Chapter 7) and Generics

* Collection Type (Interface).
* and more specific Type like `Set`, `List` (also Interfaces).
* Implementations usually don't matter but we need to decide.
  * What's more efficient in our use case, `LinkedList` or `ArrayList`?
  * Can we use a `HashSet`?
* How to handle numeric types?
  * Autoboxing.
* Using Generics can be tricks due to "runtime type erasure" ...
  * IMHO this is one of the ugliest places in Java.
  * See "Why Isn’t a `List<Date>` a `List<Object>`"

## Extra: Quicksort

* See https://en.wikipedia.org/wiki/Quicksort