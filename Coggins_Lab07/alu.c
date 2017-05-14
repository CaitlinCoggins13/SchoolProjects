#include "alu.h"

/******************************* Private variables **********************/
// these variables are visible to anything in alu.c, but not in any
// other file.  Think of them to some extent like Instance variables in 
// a class, in which you must have getters and setters in order to
// see or modify them from any other class.
//Note that they do NOT appear in alu.h

static unsigned long ALURightInput=0;
static unsigned long ALULeftInput=0;
static unsigned long ALUResult=0;
static unsigned long ALUZero=0;
static unsigned long ALUOperation=0;


/************************Public Methods*******************************/ 

unsigned long getALUResult(void)
/*
   Return the current value of ALUResult.
*/
{
    return ALUResult;
}


unsigned long getALUZero(void)
/*
   Return the current value of ALUZero.
*/
{  
    return ALUZero;
}


void setALUOperation(unsigned long controlVal)
/* 
   Set the value of the ALU operation as defined by the parameter controlVal.  
   As a side effect, evaluate the ALU action on the current ALU inputs and
   set ALUResult and ALUZero.
 
   The ALU control input values in binary are:
        control          function
          0000              AND
          0001              OR
          0010              add
          0110              subtract  (left - right)
          0111              set on less than
   Note:  The parameter controlVal is an unsigned long (int).  We can not 
 define binary values in C, so controls should be set to numbers between 0 and 7.
   If the control is not valid, do not change the ALUOperation
   or re-evaluate the ALU outputs.
*/
{
    ALUZero = 0;
    
    // and operation
    if(controlVal == 0)
    {
        ALUOperation = controlVal;
        ALUResult = ALULeftInput & ALURightInput;
    }
    
    // or operation
    else if(controlVal == 1)
    {
        ALUOperation = controlVal;
        ALUResult = ALULeftInput | ALURightInput;
        
        if(ALUResult == 0)
            ALUZero = 1;
    }
    
    // addition
    else if(controlVal == 2)
    {
        ALUOperation = controlVal;
        ALUResult = ALULeftInput + ALURightInput;
        
        if(ALUResult == 0)
            ALUZero = 1;
    }
    
    // subtraction and beq
    else if(controlVal == 6)
    {
        ALUOperation = controlVal;
        ALUResult = ALULeftInput - ALURightInput;
        
        if(ALUResult == 0)
            ALUZero = 1;
    }
    
    // slt
    else if(controlVal == 7)
    {
        ALUOperation = controlVal;
        if(ALULeftInput < ALURightInput)
        {
            ALUResult = 1;
        }
        else
            ALUResult = 0;
        
        if(ALUResult == 0)
           ALUZero = 1;
    }
    
    else
    {
        printf("This is not a valid opcode! No values will be changed.\n\n");
    }
    
    return;
}

 
void setALULeftInput(unsigned long val)
/*
   Set the left input of the ALU to val.  (As a side effect,
   reevaluate the ALU outputs as in setALUOperation.) 
*/
{
    ALULeftInput = val;
    setALUOperation(ALUOperation);
    return;
}


void setALURightInput(unsigned long val)
/*
   Set the right input of the ALU to val.  (As a side effect,
   reevaluate the ALU outputs as in setALUOperation.) 
*/
{
    ALURightInput = val;
    setALUOperation(ALUOperation);
    return;
}




