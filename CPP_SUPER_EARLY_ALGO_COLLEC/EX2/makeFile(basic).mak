#Zachary Job
#10.8.11
#V 1

#makeFile(basic).mak

CPP = g++.exe 
CFLAGS = -g -Wall

all: sortA4

#Compile
sortA4: main.o Sortings.o
	$(CPP) $(CFLAGS) -o sortA4 main.o Sortings.o
	
main.o: main.cpp Sortings.h
	$(CPP) $(CFLAGS) -c main.cpp
	
Sortings.o: Sortings.cpp Sortings.h
	$(CPP) $(CFLAGS) -c Sortings.cpp

#Clean
clean:
	$(RM) count *.o *~