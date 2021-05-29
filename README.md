# MYHASHMAP

## Table of contents
* [General info](#general-info)
* [Setup](#setup)

## General info
This is my homework for Data Structures and Algorithm class.

It contains extended HashMap class with an MapIterator to iterate through the keys in a HashMap. It has next, prev, hasNext feautures.
* There is a one-parameter constructor that takes key as parameter. Iterator starts from the given key and iterate through all the keys in the Map. The iterator starts from any key in the Map when the given key is not in the Map or not specified. 
* next: returns the next key in the Map. It returns the first key when there is no not-iterated key in the Map.
* prev: : returns the previous key in the Map. It returns the last key when the iterator is at the first key.
* hasNext: returns True if there are still not-iterated key/s in the Map, otherwise returns False.

It also contains KWHaspMap interface from the book "Data Structures: Abstraction and Design Using Java". There's 3 implementation of this interface.
* Using the chaining technique for hashing by using linked lists to chain items on the same table slot. (Not my implementation, also from the book, added just for the comparison.)
* Using the chaining technique for hashing by using TreeSet to chain items on the same table slot. (Changed the first implementation for TreeSet)
* Using the Coalesced hashing technique.
  - This technique uses the concept of Open Addressing to find first empty place for colliding element by using the quadratic probing and the concept of Separate Chaining to       link the colliding elements to each other through pointers. 
  - The deletion of a key is performed by linking its next entry to the entry that points the deleted key by replacing deleted entry by the next entry.

I tested all the methods as follows:

* Iterator: 
  - 1- Iterated through all the keys and showed that next and previous returns specified values.
  - 2- Tested with existing keys and non-existing keys as constructor parameter and with the no-parameter constructor.
  
* KWHashMap:
  - 1- Demonstrated how CoalescedHashMap works with the small data.
  - 2- Used small(1000), medium(10.000), and large-sized(100.000) data and perform different tasks over the tables to compare their performance results by comparing their running times. (like accessing existing/non-existing items or adding/removing items)



## Setup
To run this project in terminal:

```
$ cd ../MyHashMap
$ javac *.java
$ java Test
```

or use the makeFile,
```
$ cd ../MyHashMap
$ make
 
