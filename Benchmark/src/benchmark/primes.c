#include<stdio.h>
#include<time.h>

double test(long max){

   long i;
   clock_t t1, t2;
   t1 = clock();

   for (i = 1; i <= max; i ++){
      if (i % 2 != 0 || i == 2){}
   }

   t2 = clock();
   float diff = ((float)(t2 - t1) / 1000000.0F ) * 1000;
   return diff;

}

int main () {

   float result = 0;
   float it;
   long i;

   for(i=0; i<5; i++){
      it = test(400000000);
      result = it + result;
   }

   result = result / 5;

   printf("%f\n", result);

   return 0;
}
