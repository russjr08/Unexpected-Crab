#include "Person.h"


Person::Person(string name, int age, Person::Gender gender){
	this->name = name;
	this->age = age;
	this->gender = gender;
}

string Person::getName(){ return this->name; }

int Person::getAge(){ return this->age; }

Person::Gender Person::getGender(){ return this->gender; }
