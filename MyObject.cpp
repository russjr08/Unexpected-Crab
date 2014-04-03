#import "MyObject.h"
using namespace std;

string testString;
MyObject::MyObject(std::string test){
	this->testString = test;
}

string MyObject::getTestString(){
	return this->testString;
}

