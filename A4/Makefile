######################################
# Author: 	Anika Peer	 #
# Revised: 	Thursday, April 8, 2021	 #
# Description:	"MAKEFILE"		 #
######################################
# I made use of https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2020/A4-Dots/A4Soln/Makefile
# As well as a lot of the make file from assignment 3
# in order to make this Makefile


ifeq ($(OS),Windows_NT)
	SEP=;
else
	SEP=:
endif

JFLAGS = -g
JCLASS = -cp "src$(SEP).$(SEP)../junit-4.5.jar"
JC = javac
JVM = java

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JCLASS) $*.java

CLASSES = \
	src/BoardT.java \
	src/UserInterface.java \
	src/DirectionT.java \
	src/TestAll.java \

MAIN = TestAll

default: classes

classes: $(CLASSES:.java=.class)

doc:
	doxygen doxConfig
	cd latex && $(MAKE)

test: src/$(MAIN).class
	$(JVM) $(JCLASS) org.junit.runner.JUnitCore src.$(MAIN)

demo: src/Demo.java
	$(JC) $(JCLASS) $(JFLAGS) src/Demo.java
	$(JVM) $(JCLASS) Demo

clean:
	rm -rf html
	rm -rf latex
	cd src
	rm **/*.class
