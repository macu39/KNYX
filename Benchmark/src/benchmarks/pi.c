#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SCALE 10000
#define ARRINIT 2000

float pi_digits(int digits) {
   int carry = 0;
   int arr[digits + 1];

   clock_t t1, t2;
   t1 = clock();

   for (int i = 0; i <= digits; ++i)
      arr[i] = ARRINIT;
      for (int i = digits; i > 0; i-= 14) {
         int sum = 0;
         for (int j = i; j > 0; --j) {
            sum = sum * j + SCALE * arr[j];
            arr[j] = sum % (j * 2 - 1);
            sum /= j * 2 - 1;
         }
      carry = sum % SCALE;
   }

   t2 = clock();
   float diff = ((float)(t2 - t1) / 1000000.0F ) * 1000;
   return diff;
}

int main() {

   float result = 0;
   float it;
   long i;

   for(i=0; i<5; i++){
      it = pi_digits(80000);
      result = it + result;
   }

   result = result / 5;

   printf("%f\n", result);

   return 0;
}
