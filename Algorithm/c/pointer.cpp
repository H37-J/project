#include <stdio.h>
#include <stdlib.h>

int main(void){
    int i;
    int arr_len=3;
    int* ptr_arr;

    ptr_arr = (int*) malloc(arr_len * sizeof(int));

    if(ptr_arr == NULL){
        printf("fail");
        exit(1);
    }

    printf("메모리 초기값");

    for(i = 0; i < arr_len; i++){
        printf("%d", ptr_arr[i]);
    }
    free(ptr_arr);
    
    return 0;
}