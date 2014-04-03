#include <iostream>
#include <unistd.h>
using namespace std;

int main() {
        int limitX = 50;
        int limitY = 25;
        int x = 0;
        int y = 0;
        int dirX = 1;
        int dirY = 1;

        for(int i = 0; i < 100; i++) {
                sleep(1);
                system("clear");
                x += dirX;
                y += dirY;

                if(x >= limitX-1 || x <= 0) dirX *= -1;
                if(y >= limitY-1 || y <= 0) dirY *= -1;

                cout << "X: " << x << " Y: " << y << endl;
                for(int _y = 0; _y < limitY; _y++) {
                        for(int _x = 0; _x < limitX; _x++) {
                                if(x == _x && y == _y) {
                                        cout << "O";
                                } else {
                                        cout << "`";
                                }
                        }
                        cout << endl;
                }
        }

        return 0;
}