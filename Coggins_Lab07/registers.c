/*  The simulated register file implemented as an object */
#include "registers.h"

/******************************* Private variables **********************/
// An array to simulate the actual registers
static unsigned long reg[32];

// The data to be written to the register file
static unsigned long writeData;

// The data read from readRegister1
static unsigned long readData1;

//The data read from readRegister2
static unsigned long readData2;

// The first register from which to read
static unsigned long readRegister1;

// The second register from which to read
static unsigned long readRegister2;

// The register to which to write the value of writeData
static unsigned long writeRegister;


/********************Public Methods***************************/


void assertRegWrite(void)
/*
    Causes the value of writeData to be stored in reg[writeRegister];
*/
{
    reg[writeRegister] = writeData;
    return;
}


void displayRegisters(FILE *fp)
/*
    Output the values of the 32 registers in a nice
    format to the file fp.
*/
{
    fprintf(fp, "\nRegister No.  Value\n");
    for(int i=0; i<32; ++i)
    {
        fprintf(fp, "%-15i %-8lu\n", i, reg[i]);
    }
    return;
} 


 
unsigned long getReadData1Value(void) 
/* 
   Return the value of the register indicated by the value 
   in readRegister1. 
*/ 
{   
    return readData1;
} 

 
unsigned long getReadData2Value(void) 
/* 
   Return the value of the register indicated by the value 
   in readRegister2. 
*/ 
{   
    return readData2;
} 


void setReadRegister1(unsigned long val)
/*
   Set readRegister1 to val.  As a side effect, it sets
   readData1 to the value of register readRegistser1. 
*/
{
    readRegister1 = val;
    readData1 = reg[readRegister1];
    return;
}


 
void setReadRegister2(unsigned long val) 
/* 
   Set readRegister2 to val.    As a side effect, it sets 
   readData2 to the value of register readRegistser2. 
*/ 
{
    readRegister2 = val;
    readData2 = reg[readRegister2];
    return; 
} 


void setWriteData(unsigned long val)
/*
   Set writeData to val
*/
{
    writeData = val;
    return;
}


void setWriteRegister(unsigned long val)
/*
   Set writeRegister to val.
*/
{
    writeRegister = val;
    return;
}


