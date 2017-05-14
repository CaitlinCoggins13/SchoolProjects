/*
  Cailtin Coggins

  Main driver to read a sequence of hex numbers from stdin and print
  the fields of a MIPS instruction that are parsed from this initial
  number.
*/

// include the headers for the standard library and the io library
#include <stdlib.h>
#include <stdio.h>

// include the header for mipsInstruction.c so that we know where to find the definitions 
// for the function calls
#include "mipsInstruction.h"

int main() {

  // FILE pointer to use if instructions are read from a file
    //FILE *fp;

  /* declare a structure of type mipsInstruction to hold the
     fields of a decoded instruction */

    mipsInstruction decodedInstruction;

  // declare variable to hold instruction read from file
    unsigned int theInstruction;
    
    for(int i = 0; i < 11; ++i)
    {
        printf("Enter an 8-digit hex value: ");
    
        scanf("%x", &theInstruction);
    
        // get and store all possible fields
        parseMipsInstruction(theInstruction, &decodedInstruction);
    
        printf("\nInstruction: 0x%.8x, %d\n", theInstruction,theInstruction);
        
        // print all the field values
        dumpMipsInstruction(&decodedInstruction);
    }



  return 0;
}
