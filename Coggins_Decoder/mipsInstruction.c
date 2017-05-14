/*
  mipsInstruction.c

  Caitlin Coggins
*/

#include <stdlib.h>
#include <stdio.h>
#include "mipsInstruction.h"

/**
 ** Decodes all possible fields of an instruction, in parameter instructionRegister.
 ** Fills the corresponding fields of the mipsInstruction structure pointed to
 ** by the parameter instruction.
 **/
void parseMipsInstruction(unsigned int instructionRegister, mipsInstruction *instruction) 
{
    // formatType is left empty
    instruction -> formatType = ' ';
    
    // getting opcode
    unsigned int codePiece = instructionRegister;
    codePiece = codePiece >> 26;
    instruction -> op = codePiece;
    
    // getting first register source operand
    codePiece = instructionRegister;
    codePiece = (codePiece << 6) >> 27;
    instruction -> rs = codePiece;

    // getting second register source operand
    codePiece = instructionRegister;
    codePiece = (codePiece << 11) >> 27;
    instruction -> rt = codePiece;
    
    // getting destination register
    codePiece = instructionRegister;
    codePiece = (codePiece << 16) >> 27;
    instruction -> rd = codePiece;
    
    // getting shift amount
    codePiece = instructionRegister;
    codePiece = (codePiece << 21) >> 27;
    instruction -> shamt = codePiece;
    
    // getting constant or address
    signed int signExt = instructionRegister;
    signExt = (signExt << 16) >> 16;
    instruction -> immedOrAddress = signExt;
    
    // getting jump target
    codePiece = instructionRegister;
    codePiece = (codePiece << 6) >> 6;
    instruction -> target = codePiece;
    
    // getting function
    codePiece = instructionRegister;
    codePiece = (codePiece << 26) >> 26;
    instruction -> funct = codePiece;

  return;

}

/* function to print the fields of a parsed MIPS instruction */

void dumpMipsInstruction(mipsInstruction *instruction)
{
    printf("op:     0x%-11.2x %-12d\n", instruction -> op, instruction -> op);
    printf("rs:     0x%-11.2x %-12d\n", instruction -> rs, instruction -> rs);
    printf("rt:     0x%-11.2x %-12d\n", instruction -> rt, instruction -> rt);
    printf("rd:     0x%-11.2x %-12d\n", instruction -> rd, instruction -> rd);
    printf("sh:     0x%-11.2x %-12d\n", instruction -> shamt, instruction -> shamt);
    printf("ft:     0x%-11.2x %-12d\n", instruction -> formatType, instruction -> formatType);
    printf("immed:  0x%-11.4x %-12d\n", instruction -> immedOrAddress, instruction -> immedOrAddress);
    printf("target: 0x%-11.8lx %-12lu\n", instruction -> target, instruction -> target);
    printf("funct:  0x%-11.2x %-12d\n\n", instruction -> funct, instruction -> funct);
}
