#include <string>
#include <stdio.h>
#include <iostream>

using namespace std;

class Person {

			
	public:
			enum Gender {MALE, FEMALE, UNKNOWN};
			Person(string, int, Person::Gender);
			string getName();
			
			int getAge();
			
			Gender getGender();
	private:
			string name;
			int age;
			Gender gender;
};
