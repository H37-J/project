#include <iostream>
using namespace std;

int main(void){
    int x = 10;
    int& y = x;

    int num1 = 3, num2 = 7;
    
    y++;

    cout << x << endl;
    cout << y << endl;


    return 0;
}

void swap(int& x, int& y){
    int temp;

    temp = x;
    x = y;
    y = temp;
}