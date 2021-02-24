# Functional Programming

- This is a practise repo that I created following **Shaun Wassel**'s course on Linkedin Learning.

## Declarative Vs Imperative Types of Programming

* **Declarative**: What things are?  
  Eg: What is a house? Roof, walls and doors?
    - A one line definition


* **Imperative**: How to do things?  
  Eg: Lay foundation, build walls, add roof
    - Step by step algorithm

## Principles

### Immutability

Constants. Idea is to Freeze the state changes

- Java's final keyword or
- Make sure code won't allow modifications

### Functional Purity

* Always return same output given same arguments. Like a setter can change the value of getter everytime it is invoked
* **Example**: A class variable with setter can change the output of `toString()` method. So, `toString()` here is not
  pure
* An example of not pure function

```java
 public double multiply(double x){
        return x*this.multiplier;
        }
// This function relies on external state via the "this" keyword.
```

### First-class Functions

* `Function` interface - pass functions as arguments
* Assign function to a variable

# Streams

* Takes some data structure like list and allows us to process the data in pipelines manner
* Example: Assuming the Functional Programming is covered above

```java
// Say timesTwo is a function that doubles the passed number
doubledStream=myList.stream().map(timesTwo);
// Returns a new list with items doubled.
```

## Map

* Maps the data to certain behavior - say doubling the numbers in a list
* There won't be a mutation. A copy of data is created
* This returns a stream. So, `collect` is used to collect the list

```java
myList.stream()
        .map(timesTwo)
        .collect(Collectors.toList());
```

## Filter

* Find all elements that meet certain criteria from a list
* Function we pass as criteria to filter must return boolean - The interface that supports this is called `Predicate<T>`

## Reduce

* Read a list of data and reduce it to a single piece of data
* **Example**: Take a list of integers and return the sum of all numbers
* Like a `Predicate<T>` to Filter, Reduce uses `BinaryOperator<T>`
* `BinaryOperator<T>` is a BiFunction where all 3 generics are of same type - Takes 2 and returns 1

```java
list.stream().reduce(sum);
// BinaryOperator "sum" can be defined as
        (acc,x)->acc+x;
// acc is carry or accumulator; x is current value in the list
// Idea is to add 1 + 2 + 3, the sequence assumed is
// 1 <- Starting value
// 1 + 2 = 3 <- add carry 1 to second/current number 2
// 3 + 3 = 6 <- add carry 3 to third/current number 3
```

* Overloaded function `reduce(startingValue, binaryOpfunc)` allows us to provide starting element in the list where
  reduce starts computing
* If the stream is empty, the `startingValue` is returned
* So things to note

```java
stream.reduce(binaryOpFunc);  // Returns Optional<T>
        stream.reduce(startingValue,bunaryOpFunc); // Returns T
```

* No need to use `collect` because the last element is returned. Last meaning, the current computed to carry as
  explained above

## Collect

* Does more than collecting the result from Map or Filter.
* While `reduce` returns the same type that is computed, `collect` can return any type
* `collect` uses `Collector<T, A, R>` functional interface
* Java provides many standard collectors

## Parallel Streams

* All the elements in the list are processed in serial manner. Refer to `Reduce.java` with print inside the lambda
* Parallel streams solves the problem in parallel manner. And its as easy as

```java
list.parallelStream();
```

* Increase performance by splitting the stream into multiple small chunks and run parallel threads
* Refer to Average Salary Calculator for advanced examples

# Advanced Functional Concepts

* Partial Application
* Recursion
* Composition

## Partial Application

* Take a function with arguments and fix some of those arguments to a set value
* **Currying?** Currying is a concept where arguments are passed one by one in partial function. Refer to examples
  in `PartialFunction.java`
  
## Recursion

* Function calls itself that lead to infinite loop if not careful

## Composition

* Combine simple functions into one complex function