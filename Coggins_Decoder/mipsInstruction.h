/*
  mipsInstruction.h

  Definition of structure and prototypes for decoding
  MIPS instructions

  author: Lisa Ballesteros, January, 2010
*/

/* stucture to hold a decoded MIPS instruction */

  typedef struct InstructionParseType{ 
    char formatType;         /* Instruction format: 'J', 'I', or 'R' */
    unsigned int op;         /* opcode: bits 31-26 */
    unsigned int rs;         /* first register source operand: bits 25-21 */
    unsigned int rt;         /* second register source operand: bits 20-16 */
    unsigned int rd;         /* destination register: bits 15-11 */
    unsigned int shamt;      /* shift amount: bits 10-6 */
    int immedOrAddress;      /* constant or address: bits 15-0 */ 
    unsigned long target;    /* jump target: bits 25-0 */
    unsigned int funct;      /* function: bits 5-0 */
} mipsInstruction;


/* function prototypes */
/* the extern modifier indicates that the actual storage and initial value of a variable, 
 * or body of a function, is defined elsewhere, usually in a separate source code module
 */

extern void parseMipsInstruction(unsigned int instructionRegister, mipsInstruction *instruction);

extern void dumpMipsInstruction(mipsInstruction *);
