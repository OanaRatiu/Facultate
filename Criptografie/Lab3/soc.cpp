#include <iostream>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int gcdivisor (int a, int b)
{
  int aux;
  while (a != 0) {
    aux = a; 
    a = b % a;
    b = aux;
  }
  return b;
}

int get_congruence(int n, int mod) {
    n = n % mod;
    for (int i=1; i<mod; i++)
        if ((n * i) % mod == 1 % mod)
            return i;
}


int main(void)
{
    int N, N1, N2, N3, n1, n2, n3, a, b, c, K1, K2, K3;
    int x;
    a = 2; b = 4; c = 5;
    n1 = 5; n2 = 7; n3 = 11;
    if (gcdivisor(n1, n2) || gcdivisor(n1, n3) || gcdivisor(n1, n2))
        std::cout <<"n's are not prime!!"<<std::endl;
    N = n1*n2*n3;
    N1 = N/n1; N2 = N/n2; N3 = N/n3;
    K1 = get_congruence(N1, n1);
    K2 = get_congruence(N2, n2);
    K3 = get_congruence(N3, n3);
    x = (a*N1*K1 + b*N2*K2 + c*N3*K3) % N;

    std::cout <<"K1="<<K1<<std::endl;
    std::cout <<"K2="<<K2<<std::endl;
    std::cout <<"K3="<<K3<<std::endl;

    std::cout <<"N1="<<N1<<std::endl;
    std::cout <<"N2="<<N2<<std::endl;
    std::cout <<"N3="<<N3<<std::endl;

    std::cout <<"x="<<x<<std::endl;

    return 0;
}