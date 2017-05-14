#include "alu.h"
#include <string.h>


void main(int argc, char *argv[])
/*
    Main program to test ALU 
 prompt for two input values and an operation 
 then call the public methods of ALU.c to perform 
 the operation and get the result.  Display the input
 values, operation, and result in a nice format.
*/
{
    int leftInput;
    int rightInput;
    char instruction[7];
    
    printf("Valid Instructions:\n");
    printf("and, or, add, subtract, beq, slt\n\n");
    
    for(int i = 0; i<6; i++)
    {
        int opcode;
        
        printf("Enter an integer input value: ");
        scanf("%i", &leftInput);
        printf("%i\n", leftInput);
        setALULeftInput(leftInput);
        
        printf("Enter another integer input value: ");
        scanf("%i", &rightInput);
        printf("%i\n", rightInput);
        setALURightInput(rightInput);
        
        printf("Enter an instruction for your operation: ");
        scanf("%s", &instruction);
        printf("%s\n", instruction);
        
        
        if(strcmp(instruction, "and")==0)
        {
            opcode = 0;
            setALUOperation(opcode);
        }
        
        else if(strcmp(instruction, "or")==0)
        {
            opcode = 1;
            setALUOperation(opcode);
        }
        
        else if(strcmp(instruction, "add")==0)
        {
            opcode = 2;
            setALUOperation(opcode);
        }
        
        else if(strcmp(instruction, "subtract")==0 || strcmp(instruction, "beq")==0)
        {
            opcode = 6;
            setALUOperation(opcode);
        }
        
        else if(strcmp(instruction, "slt")==0)
        {
            opcode = 7;
            setALUOperation(opcode);
        }
        
        else
        {
            printf("This is not a valid instruction.\n");
            printf("Valid Instructions:\n");
            printf("and, or, add, subtract, beq, slt\n\n");
        }
        
        
        printf("Results:\n");
        printf("Opcode  Result  ALUZero\n");
        printf("%-7i %-7lu %-7lu\n\n", opcode, getALUResult(), getALUZero());
    }
  //printf("This program should test the ALU functionality.  Write me!\n");
    return;
}

