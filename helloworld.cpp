#include <iostream>

using namespace std;

// argc -- arg count
// argv -- array of char arrays
// returns status
int main(int argc, char const *argv[]) {
	
	cout << "primary expression Kappa" << endl;
	for(int i = 0; i < argc; i++) {
		cout << argv[i] << endl; //DONE
 	}
	cout << endl;
	//what is the meaning of life?
	cout << "The meaning of life is obviously " << 42 << endl;
	for(int x = 0; x < 10; x++){
		for(int y = 0; y < 10; y++){
			cout << x + y << endl;
		}
	}
	cout << "HEHEHEHEHEH" << endl;
	return 0;
}