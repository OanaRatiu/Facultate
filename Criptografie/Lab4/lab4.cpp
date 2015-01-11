#include <cmath>
#include <iostream>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

long long f(long long x){
	return x*x + x + 1;
}

long long euclid(long long a, long long b)
{
    long long c;
    while (b) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

void pollard(long long a, long long b, long long d, long long n) {
	std::cout <<"a="<<a<<"; b="<<b<<"; n="<<n<<std::endl;
	std::cout<<"n= ";
	while (n != 1) {
		while (d == 1) {
			a = f(a) % n;
			b = f(b) % n;
			b = f(b) % n;
			d = euclid(abs(a-b), n);
		}
		std::cout<<d<<" * ";
		if (d == n)
			break;
		n = n / d;
		d = 1;
	}
}

 
void trial_division2(long long n)
{
    std::cout <<"n="<<n<<std::endl;
    std::cout <<"d= ";
    if (n <= 1 || n == 2)
        std::cout<<n;
    for (long long d = 2; d <= sqrt(n); ++d)
        if (n % d == 0){
        	std::cout <<d<<" * ";
            //return;
            //break;
        }
    if (n > 1)
    	std::cout<<n<<" ";
    else
    	std::cout <<"; FAILURE";
}

void trial_division(long long n) {
	std::cout <<"n="<<n;
	long long d = 2;
	while (d * d <= n)
		if (n % d == 0){
			std::cout <<"d="<<d;
			return;
		}
		else
			d++;
	std::cout <<"FAILURE";
}

int main(){
	long long a, b, n;
	clock_t t;
    float current;
	for(int i=0; i<10; i++) {
		n = rand() % 100000000000 + 1000000000;
		/*a = rand() % n;
		b = rand() % n;*/
		a=2; b=2;
		
		std::cout<<std::endl<<"********************* POLLARD *********************"<<std::endl;
		t = clock();
		pollard(a, b, 1, n);
    	current = ((float)clock() - t);
    	std::cout << std::endl<<"Pollard time: "<<current<<" ms"<<std::endl;


    	std::cout<<std::endl<<"********************* TRIAL DIVISION *********************"<<std::endl;
    	t = clock();
		trial_division2(n);
    	current = ((float)clock() - t);
    	std::cout << " |	Trial division time: "<<current<<" ms"<<std::endl;
	}
}
