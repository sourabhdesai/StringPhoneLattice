StringPhoneLattice
==================

Please note that this data structure **requires** the [JSON Simple library](https://code.google.com/p/json-simple/) for JSON serialization.
If you want to use a different JSON parsing library, It should be fairly easy to do so by just modifying the code within the `StringPhoneLattice` class.  

A Phone Lattice data structure written in Java that allows to quickly check if a String has been added to the database.


It can be used in any scenario where you need to check if a String has been added to a database.

**Pros:**
  
  *- Quick:*  
      When it comes to checking if a word is in the data structure, it excels.  
  *- Easy to use:*  
      Only two public instance method `addWord(String str)` and `contains(String str)` and a simple constructor  
  *- Small size:*  
      All you need to do is add StringPhoneLattice.java to your source files!
  *- JSON Serialization  
      Can easily be Encoded into a `JSONObject` within the JSON Simple library using the `toJSON()` method and the JSON copy constructor
      
  
**Cons:**
  
  *- Takes longer than arrays to add words to its data set*  
  *- Does not accept empty strings*  
  *- Cannot retrieve Strings from the StringPhoneLattice, only check that they are there*   
  *- Dependent on JSON Simple library for JSON serialization*  
  
Certainly, this is not be the ideal data structure to use in all scenarios. It is only meant for very specific scenarios   where one needs to quickly check if a String has been added into a pool of Strings.


**Here are some of the results from the performance tests in Test.java:**  

I did not bother posting results from the Accuracy test. Its results for the `contains(String)` method showed that when it was supposed to return true, it would always return true (unless the string was an empty string) and when it was supposed to return false, it would always return false.

Efficiency Test results:  
----------------------------------------------------------------------------------------------------------------
Test 1
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays  
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added  
All time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
The character '�' is not in any of the parsed words  
**251** added words  
**Time for Adding Words to Lattice:**  
*5*  
**Time for Checking Added Words in Lattice:**  
*3*  
**Time for Checking Fake Words in Lattice:**  
*3*  
**Time for Adding Words to Array:**  
*0*  
**Time for Checking Added Words in Array:**  
*21*  
**Time for Checking Fake Words in Array:**  
*8*  

Test 2
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays  
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added  
All time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
The character '�' is not in any of the parsed words  
**4401** added words  
**Time for Adding Words to Lattice:**  
*78*  
**Time for Checking Added Words in Lattice:**  
*40*  
**Time for Checking Fake Words in Lattice:**  
*6*  
**Time for Adding Words to Array:**  
*1*  
**Time for Checking Added Words in Array:**  
*83*  
**Time for Checking Fake Words in Array:**  
*84*  

Test 3
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays  
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added  
All time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
The character '�' is not in any of the parsed words  
**18861** added words  
**Time for Adding Words to Lattice:**  
*211*  
**Time for Checking Added Words in Lattice:**  
*76*  
**Time for Checking Fake Words in Lattice:**  
*14*  
**Time for Adding Words to Array:**  
*1*  
**Time for Checking Added Words in Array:**  
*1625*  
**Time for Checking Fake Words in Array:**  
*1673*  

Test 4
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays  
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added  
All time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
The character '�' is not in any of the parsed words  
**47839** added words  
**Time for Adding Words to Lattice:**  
*240*  
**Time for Checking Added Words in Lattice:**  
*109*  
**Time for Checking Fake Words in Lattice:**  
*25*  
**Time for Adding Words to Array:**  
*3*  
**Time for Checking Added Words in Array:**  
*8010*  
**Time for Checking Fake Words in Array:**  
*8954*  

Test 5
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays  
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added  
All time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
The character '�' is not in any of the parsed words  
**73111** added words  
**Time for Adding Words to Lattice:**  
*269*  
**Time for Checking Added Words in Lattice:**  
*103*  
**Time for Checking Fake Words in Lattice:**  
*42*  
**Time for Adding Words to Array:**  
*5*  
**Time for Checking Added Words in Array:**  
*18756*  
**Time for Checking Fake Words in Array:**  
*20789*  

----------------------------------------------------------------------------------------------------------------


JSON Serialization Test Results:
----------------------------------------------------------------------------------------------------------------
Test 1
----------------------------------------------------------------------------------------------------------------
This is a Test for the efficiency and accuracy of JSON encoding and decoding of the String Phone Lattice data structure
 It tests how quickly a String Phone Lattice data structure can encode its contents into a JSON object,
 How quickly it can decode a JSON object resembling a String Phone Lattice data structure,
 and how accurately it can decode those JSON objects  
As a bonus, it will also be testing the speed in which the JSONObjects from the JSON Simple library can be converted to and from String objectsAll time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
**251** added words  
Time to encode to JSON:  
*23*  
Time to encode to JSON Object to String object:  
*34*  
Time to encode to String Object to JSON object:  
*81*  
Time to encode to JSON Object to StringPhoneLattice object:  
*3*  
JSON Encoding and decoding of StringPhoneLattice data structure is completely accurate  

Test 2
----------------------------------------------------------------------------------------------------------------
This is a Test for the efficiency and accuracy of JSON encoding and decoding of the String Phone Lattice data structure
 It tests how quickly a String Phone Lattice data structure can encode its contents into a JSON object,
 How quickly it can decode a JSON object resembling a String Phone Lattice data structure,
 and how accurately it can decode those JSON objects  
As a bonus, it will also be testing the speed in which the JSONObjects from the JSON Simple library can be converted to and from String objectsAll time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
**4401** added words  
Time to encode to JSON:  
*81*  
Time to encode to JSON Object to String object:  
*153*  
Time to encode to String Object to JSON object:  
*183*  
Time to encode to JSON Object to StringPhoneLattice object:  
*84*  
JSON Encoding and decoding of StringPhoneLattice data structure is completely accurate  

Test 3
---------------------------------------------------------------------------------------------------------------
This is a Test for the efficiency and accuracy of JSON encoding and decoding of the String Phone Lattice data structure
 It tests how quickly a String Phone Lattice data structure can encode its contents into a JSON object,
 How quickly it can decode a JSON object resembling a String Phone Lattice data structure,
 and how accurately it can decode those JSON objects  
As a bonus, it will also be testing the speed in which the JSONObjects from the JSON Simple library can be converted to and from String objectsAll time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
**23556** added words  
Time to encode to JSON:  
*133*  
Time to encode to JSON Object to String object:  
*207*  
Time to encode to String Object to JSON object:  
*351*  
Time to encode to JSON Object to StringPhoneLattice object:  
*100*  
JSON Encoding and decoding of StringPhoneLattice data structure is completely accurate  

Test 4
--------------------------------------------------------------------------------------------------------------
This is a Test for the efficiency and accuracy of JSON encoding and decoding of the String Phone Lattice data structure
 It tests how quickly a String Phone Lattice data structure can encode its contents into a JSON object,
 How quickly it can decode a JSON object resembling a String Phone Lattice data structure,
 and how accurately it can decode those JSON objects  
As a bonus, it will also be testing the speed in which the JSONObjects from the JSON Simple library can be converted to and from String objectsAll time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
**47839** added words  
Time to encode to JSON:  
*188*  
Time to encode to JSON Object to String object:  
*265*  
Time to encode to String Object to JSON object:  
*425*  
Time to encode to JSON Object to StringPhoneLattice object:  
*124*  
JSON Encoding and decoding of StringPhoneLattice data structure is completely accurate  

Test 5
-------------------------------------------------------------------------------------------------------------
This is a Test for the efficiency and accuracy of JSON encoding and decoding of the String Phone Lattice data structure
 It tests how quickly a String Phone Lattice data structure can encode its contents into a JSON object,
 How quickly it can decode a JSON object resembling a String Phone Lattice data structure,
 and how accurately it can decode those JSON objects  
As a bonus, it will also be testing the speed in which the JSONObjects from the JSON Simple library can be converted to and from String objectsAll time measurements are given in milliseconds  
The test will be parsing the words off of MobyDick.txt  
The test will now start  
Done parsing words  
**78243** added words  
Time to encode to JSON:  
*238*  
Time to encode to JSON Object to String object:  
*503*  
Time to encode to String Object to JSON object:  
*484*  
Time to encode to JSON Object to StringPhoneLattice object:  
*128*  
JSON Encoding and decoding of StringPhoneLattice data structure is completely accurate  
