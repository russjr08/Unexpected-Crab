#include <iostream>
#include <unistd.h>
#include <stdlib.h>

using namespace std;

int main(int argc, char const *argv[])
{
	for(int i = 1; i < argc; i++) {
		system(argv[i]);
	}

	return 0;
}