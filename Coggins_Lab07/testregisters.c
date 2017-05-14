#include "registers.h"


void main(int argc, char *argv[])
/*
    Main program to test register files.
 prompt for which method in registers.c 
 to call and with what parameter value(s).  
 The results of those function calls should then be displayed.
*/
{
    static int menuNum;
    static unsigned long val;
    static FILE * registerDump;
    
    registerDump = fopen("./registerDump.txt", "w");
    
    while(menuNum != -1)
    {
        printf("\nSet Read Register 1:         Press 0\n");
        printf("Set Read Register 2:         Press 1\n");
        printf("Set Write Register:          Press 2\n");
        printf("Set Write Data:              Press 3\n");
        printf("Get Read Register 1's Data:  Press 4\n");
        printf("Get Read Register 2's Data:  Press 5\n");
        printf("Write to Write Register:     Press 6\n");
        printf("Print All Registers:         Press 7\n");
        printf("Quit:                        Press -1\n\n");
        printf("Enter a value: ");
        scanf("%i", &menuNum);
        printf("%i\n", menuNum);
    
        // determine which task the user wants to complete
        switch(menuNum)
        {
            val = 0;
             
            // set read register 1
            case 0:
            {
                printf("\nWhich register? (0-31)");
                scanf("%lu", &val);
                printf("%lu\n", val);
            
                if(val<32)
                {
                    setReadRegister1(val);
                    printf("\nRegister set!\n");
                }
                break;
                
            }
            
            // set read register 2
            case 1:
            {
                printf("\nWhich register? (0-31)");
                scanf("%lu", &val);
                printf("%lu\n", val);
            
                if(val<32)
                {
                    setReadRegister2(val);
                    printf("\nRegister set!\n");
                }
                break;
            }
            
            // set write register
            case 2:
            {
                printf("\nWhich register? (0-31)");
                scanf("%lu", &val);
                printf("%lu\n", val);
            
                if(val<32)
                {
                    setWriteRegister(val);
                    printf("\nRegister set!\n");
                }
                break;
            }
            
            // set write data
            case 3:
            {
                printf("\nEnter data value:");
                scanf("%lu", &val);
                printf("%lu\n", val);
            
                setWriteData(val);
                printf("\nWrite data set!\n");
                break;
            }
            
            // get read register 1's value
            case 4:
            {
                printf("\nThe value is %lu\n", getReadData1Value());
                fprintf(registerDump, "The value is %lu\n\n", getReadData1Value());
                break;
            }
            
            // get read register 2's value
            case 5:
            {
                printf("\nThe value is %lu\n", getReadData2Value());
                fprintf(registerDump, "The value is %lu\n\n", getReadData2Value());
                break;
            }
            
            // write data
            case 6:
            {
                assertRegWrite();
                printf("Data written!\n");
                break;
            }
            
            // display the values for all registers
            case 7:
            {
                displayRegisters(registerDump);
                printf("All register values written to registerDump.txt.\n");
                break;
            }
        }
    }
    
    return;
    
    
}

