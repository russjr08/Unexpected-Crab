#import "MyObject.h"
using namespace std;

string testString;
MyObject::MyObject(string* test){

	this->testString = test;
}

string* MyObject::getTestString(){

	return this->testString;

}

