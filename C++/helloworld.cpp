#include <iostream>
#include "MyObject.h"
#include "Person.h"

using namespace std;

// argc -- arg count
// argv -- array of char arrays
// returns status
int main(int argc, char const *argv[]) {
	MyObject* obj = new MyObject(new string("Hello World!!"));
	Person* person = new Person(new string("Russ"), 17, Person::MALE);

	cout << "Hello. My name is: " << person->getName() << endl;
	cout << "attempting to turn it off on and on again" << endl;
	cout << *(obj->getTestString()) << endl;
	cout << "primary expression Kappa" << endl;
	for(int i = 0; i < argc; i++) {
		cout << argv[i] << endl; //DONE
 	}
	cout << endl;
	//what is the meaning of life?
	cout << "The meaning of life is obviously " << 47 << endl;
	cout << endl << "Let's do some weird stuff" << endl;
	int startX = 0;
	int startY = 0;
	int limitX = 500;
	int limitY = 500;
	int thingX = 0;
	int thingY = 0;
	for(int i = 0; i < 500; i++) {
		
	}
	cout << "HEHEHEHEHEH" << endl;
	return 0;
}
