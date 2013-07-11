/*
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package example;

public class Test {
	
    public static void main(String[] args)	{
    	accuracyTest();
    }
    public static void testPerformanceAgainstStringArray()	{
    //	System.out.println("Length of an empty string= "+"".length());// its zero!
    	/*
    	String[] AddedWords = {"Boo!!","Hey","ooh","ook","rr","threeee","if only","12423423","Hello World","helloWorld",":::^&",":^:","Math.tan(x^y)"};
    	String[] FakeWords = {"Hardy","Zynga","boo","Bo","oo","three","oorr","Hellor","mylowe","boot","opipdsccds","rrottentomatoe","wassupbrotha","6844==+","\"\"\"3423%6:::^&",":^:"};
    	*/
    	String textFile = "MobyDick.txt";
    	int numberOfAddedLines = 5000;
    	
    	TextIO.readFile("src/"+textFile);
    	String added = "";
    	String fake = "";
    	for(int i=0;i<numberOfAddedLines;i++)	{
    		added+=" "+TextIO.getln().trim();
    	}
    	for(int i=0;i<numberOfAddedLines;i++)	{
    		fake+=" "+TextIO.getln();
    	}
    	String[] AddedWords = added.split(" ");
    	String[] FakeWords = fake.split(" ");
    	System.out.println("This is a Test of Performance between the StringPhoneLattice object and String Arrays");
    	System.out.println(" It tests how quickly each data structure can add words to its library,\n check if the ones that have been added have been added,\n and check if the ones that have not added have been added");
    	System.out.println("All time measurements are given in milliseconds");
    	System.out.println("The test will be parsing the words off of "+textFile);
    	System.out.println("The test will now start");
    	System.out.println("Done parsing words");
    	System.out.println(AddedWords.length+" added words");
    	System.out.println(FakeWords.length+" fake words");
    	long startAddingL,stopAddingL,startAddedL,stopAddedL,startFakeL,stopFakeL,startAddingA,stopAddingA,startAddedA,stopAddedA,startFakeA,stopFakeA;
    	
    	startAddingL = System.currentTimeMillis();
    	StringPhoneLattice root = new StringPhoneLattice();   	
    	for(String word : AddedWords)	{
    		root.addWord(word);
    	}
    	stopAddingL = System.currentTimeMillis();
    	System.out.println("Time for Adding Words to Lattice:");
    	System.out.println(stopAddingL-startAddingL);
    	
    	startAddedL = System.currentTimeMillis();
    	for(String word : AddedWords)	{
    		root.contains(word);
    	}
    	stopAddedL = System.currentTimeMillis();
    	System.out.println("Time for Checking Added Words in Lattice:");
    	System.out.println(stopAddedL-startAddedL);
    	
    	startFakeL = System.currentTimeMillis();
    	for(String word : FakeWords){
    		root.contains(word);
    	}
    	stopFakeL = System.currentTimeMillis();
    	System.out.println("Time for Checking Fake Words in Lattice:");
    	System.out.println(stopFakeL-startFakeL);
    	
    	startAddingA = System.currentTimeMillis();
    	String[] AddedWords1 = new String[AddedWords.length];   	
    	for(int i=0;i<AddedWords.length;i++)	{
    		AddedWords1[i] = AddedWords[i];
    	}
    	stopAddingA = System.currentTimeMillis();
    	System.out.println("Time for Adding Words to Array:");
    	System.out.println(stopAddingA-startAddingA);
    	

    	startAddedA = System.currentTimeMillis();
    	for(String word : AddedWords1)	{
    		for(String word2 : AddedWords)	{
    			word.equals(word2);
    		}
    	}
    	stopAddedA = System.currentTimeMillis();
    	System.out.println("Time for Checking Added Words in Array:");
    	System.out.println(stopAddedA-startAddedA);
    	
    	startFakeA = System.currentTimeMillis();
    	for(String word : AddedWords1)	{
    		for(String word2 : FakeWords)	{
    			word.equals(word2);
    		}
    	}
    	stopFakeA = System.currentTimeMillis();
    	System.out.println("Time for Checking Fake Words in Array:");
    	System.out.println(stopFakeA-startFakeA);
    	
    }
    
    public static void accuracyTest()	{
    	int numberOfLinesToRead = 5000;
    	String fileName = "MobyDick.txt";
    	TextIO.readFile("src/"+fileName);
    	char uniqueCharacter = (char) 224;
    	
    	System.out.println("This is a test of accuracy of the StringPhoneLattice data structure");
    	System.out.println("It will test two things about the data structure:\n     1. It will test the probability of the contains(String key) method returning true when it should return true.\n     2. It will test the probability of the contains(String key) method returning false when it should return false.");
    	System.out.println("This test will be parsing words off of "+fileName);
    	System.out.println("The test will now start");
    	
    	String lineOfWords = "";
    	for(int i=0;i<numberOfLinesToRead;i++)	{
    		lineOfWords+=' '+TextIO.getln().trim();
    	}
    	if(!lineOfWords.contains(uniqueCharacter+"")) {
    	String[] AddedWords = lineOfWords.split(" ");
    	
    	System.out.println("Done parsing words");
    	System.out.println(uniqueCharacter+" is a unique character that cannot be found in the words parsed from "+fileName);
    	System.out.println(AddedWords.length+" added words");
    	StringPhoneLattice root = new StringPhoneLattice();
    	for(String word : AddedWords)	{
    		root.addWord(word);
    	}
    	
    	double numberOfWords = (double) AddedWords.length;
    	
    	System.out.println("Test 1: Testing probability of returning true when it should return true");
    	double correctResponsesForTest1 = 0;
    	for(String word : AddedWords)	{
    		boolean contains = root.contains(word);
    		if(contains) correctResponsesForTest1++;
    		else System.out.println("Incorrect Response For Test 1 on word \""+word+"\"");
    	}   	
    	System.out.println("Probability of returning true when it should return true = "+(100*(correctResponsesForTest1/numberOfWords))+"%");
    	
    	System.out.println("\n \n \n");
    	
    	System.out.println("Test 2: Testing probability of returning false when it should return false");
    	double correctResponsesForTest2 = 0;
    	for(String word : AddedWords)	{
    		char randomChar1 = (char) (Math.random()*255);
    		word = randomChar1+word+uniqueCharacter;
    		boolean contains = root.contains(word);
    		if(!contains) correctResponsesForTest2++;
    		else System.out.println("Incorrect Response For Test 2 on word \""+word+"\""); 
    	}   	
    	System.out.println("Probability of returning false when it should return false = "+(100*(correctResponsesForTest2/numberOfWords))+"%");
    	}else System.out.println("Could not find unique character that was not in words parsed from "+fileName);
    }

}

/*TEST PERFORMANCES
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added
All time measurements are given in milliseconds
The test will be reading the words off of MobyDick.txt
The test will now start
Done parsing words
282 added words
413 fake words
Time for Adding Words to Lattice:
4
Time for Checking Added Words in Lattice:
3
Time for Checking Fake Words in Lattice:
2
Time for Adding Words to Array:
0
Time for Checking Added Words in Array:
12
Time for Checking Fake Words in Array:
14
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added
All time measurements are given in milliseconds
The test will be reading the words off of MobyDick.txt
The test will now start
Done parsing words
4613 added words
5750 fake words
Time for Adding Words to Lattice:
88
Time for Checking Added Words in Lattice:
45
Time for Checking Fake Words in Lattice:
9
Time for Adding Words to Array:
0
Time for Checking Added Words in Array:
119
Time for Checking Fake Words in Array:
108
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added
All time measurements are given in milliseconds
The test will be parsing the words off of MobyDick.txt
The test will now start
Done parsing words
10362 added words
11112 fake words
Time for Adding Words to Lattice:
201
Time for Checking Added Words in Lattice:
45
Time for Checking Fake Words in Lattice:
10
Time for Adding Words to Array:
1
Time for Checking Added Words in Array:
445
Time for Checking Fake Words in Array:
397
----------------------------------------------------------------------------------------------------------------
This is a Test of Performance between the StringPhoneLattice object and String Arrays
 It tests how quickly each data structure can add words to its library,
 check if the ones that have been added have been added,
 and check if the ones that have not added have been added
All time measurements are given in milliseconds
The test will be parsing the words off of MobyDick.txt
The test will now start
Done parsing words
54421 added words
56975 fake words
Time for Adding Words to Lattice:
248
Time for Checking Added Words in Lattice:
100
Time for Checking Fake Words in Lattice:
38
Time for Adding Words to Array:
3
Time for Checking Added Words in Array:
9179
Time for Checking Fake Words in Array:
10528

----------------------------------------------------------------------------------------------------------------
*/
