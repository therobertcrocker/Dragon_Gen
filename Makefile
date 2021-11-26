CLASSPATH = .
TESTCLASSPATH = $(CLASSPATH):Test/:Test/junit4.jar
JFLAGS = -g -cp $(TESTCLASSPATH)
.SUFFIXES: .java .class
.java.class:
	javac $(JFLAGS) $*.java



SRC = \
	Dragon.java \
	Matriarch.java \
	Clan.java \
	Drake.java \
	DragonGen.java

default: classes

classes: $(SRC:.java=.class)

run: classes
	java -cp $(CLASSPATH) DragonGen