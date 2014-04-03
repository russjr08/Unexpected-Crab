#save as Makefile
#then `make`
build: helloworld.cpp
	g++ -o hello helloworld.cpp MyObject.cpp
