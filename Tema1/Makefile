build:
	javac Crypto.java
	javac Stocks.java
	javac Valley.java
	javac Ridge.java

run-p1:	crypto.in crypto.out
	java Crypto < crypto.in > crypto.out

run-p2: stocks.in stocks.out
	java Stocks < stocks.in > stocks.out
	
run-p3: valley.in valley.out
	java Valley < valley.in > valley.out

run-p4: ridge.in ridge.out
	java Ridge < ridge.in >ridge.out

clean:	
	rm *.class 
	rm *.out 
	rm *.in