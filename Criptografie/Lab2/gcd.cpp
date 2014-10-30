#include <iostream>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "InfInt.h"


/* Standard C Function: Greatest Common Divisor */
InfInt gcd_big_numbers (InfInt a, InfInt b)
{
  InfInt aux;
  while (a != 0) {
    aux = a; 
    a = b % a;
    b = aux;
  }
  return b;
}

/* Recursive Standard C Function: Greatest Common Divisor */
int gcdr ( int a, int b )
{
    if (a == 0) 
        return b;   
    return gcdr (b % a, a);
}

/* YUP :) */
int gcd(int a, int b)
{
    int aux;
    if (a > b) {
        aux = a; a = b; b = aux;
    }
    for (int i = b; i >= 2 ; i--) {
        if(a % i == 0 && b % i == 0 ) {
            return i;
        }
    }
}


void gcd_1() {
    clock_t t;
    float current;
    int a, b, gcd_1;


    a = 14457568;
    b = 96528242;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<8<<std::endl;

    a = 31827492;
    b = 98736254;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<8<<std::endl;

    a = 82474;
    b = 18278;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<5<<std::endl;

    a = 4528543;
    b = 4587243;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<7<<std::endl;

    a = 8764;
    b = 9426;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<4<<std::endl;

    a = 109754367;
    b = 423525235;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<9<<std::endl;

    a = 535;
    b = 324;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<3<<std::endl;

    a = 876857343;
    b = 542566736;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<9<<std::endl;

    a = 253452;
    b = 785887;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<6<<std::endl;

    a = 25;
    b = 78;
    t = clock();
    gcd_1 = gcd(a,b);
    current = ((float)clock() - t);
    std::cout << "First method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<2<<std::endl<<std::endl;
}


void gcd_2(){
    clock_t t;
    float current;
    int a, b, gcd_1;

    a = 14457568;
    b = 96528242;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<8<<std::endl;

    a = 31827492;
    b = 98736254;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<8<<std::endl;

    a = 82474;
    b = 18278;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<5<<std::endl;

    a = 4528543;
    b = 4587243;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<7<<std::endl;

    a = 8764;
    b = 9426;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<4<<std::endl;

    a = 109754367;
    b = 423525235;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<9<<std::endl;

    a = 535;
    b = 324;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<3<<std::endl;

    a = 876857343;
    b = 542566736;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<9<<std::endl;

    a = 253452;
    b = 785887;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<6<<std::endl;

    a = 25;
    b = 78;
    t = clock();
    gcd_1 = gcdr(a,b);
    current = ((float)clock() - t);
    std::cout << "Second method: gcd="<<gcd_1<<" | Time: "<<current<<" ms"<<2<<std::endl<<std::endl;
}


void gcd_3() {
    clock_t t;
    float current;
    InfInt a, b, gcd_1;

    a = "154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654";
    b = "156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "15634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634";
    b = "30054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "54154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548";
    b = "63413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005441";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "1543215";
    b = "5415432";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "15432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154865415432154";
    b = "15634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154";
    b = "563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005443553";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "1300544156341300544156341300544156341300544156341300544156341300544156";
    b = "8654154321548654154321548654154321548654154321548654154321543566573435";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "415634130054415634130054412";
    b = "156341300544156341300544152";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "6541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486541543215486154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654154321548654";
    b = "4156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300544156341300515634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054448654154321548654154321548654486541543215486541543215486544865415432154865415432154865";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl;

    a = "56341300544156341300544156341300544156341300515634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634130054415634";
    b = "41563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005441563413005156341300544156341300544156341300544156341300544156341300544156341300544156341300544156";
    t = clock();
    gcd_1 = gcd_big_numbers(a,b);
    current = ((float)clock() - t);
    std::cout << "Third method: gcd="<<gcd_1.toString()<<" | Time: "<<current<<" ms"<<std::endl<<std::endl;
}

int main(void)
{
    gcd_1();
    gcd_2();
    gcd_3();

    return 0;
}