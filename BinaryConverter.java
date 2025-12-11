public class BinaryConverter
{
	//Instance Variables
	private int value;
	private String binaryValue;

	//Default Constructor
    public BinaryConverter()
    {
    	value=0;
    	binaryValue="0";
    }

    //Modified  Constructor(s)
    public BinaryConverter(int newValue)
    {
    	value=newValue;
    	binaryValue="0";
    }

    public BinaryConverter(String newBinary)
    {
    	value=0;
    	binaryValue=newBinary;
    }

    //Methods
    public int getValue()
    {
    	return value;
    }

    public String getBinary()
    {
        return "" + binaryValue;
    }

    public void setValue(int newValue)
    {
    	value=newValue;
    }

    public void setbinaryValue(String newBinaryValue)
    {
        binaryValue = newBinaryValue;
    }

    public String toBinary()
    {
        //make a temp value as to not alter the the instance var and remove whatever is in binaryValue
        int tempValue = value;
        binaryValue = "";

    	//Convert the integer value to binary

        //starting at 128, the iteration int var divides by 2 until =< 0, meaning it will become the int value of the next binary place down
         for(int i = 128; i > 0 ; i = i / 2)
        {
            //if the value can be subtracted by the current binary place, subtract that value and place a one into that position of the binary string 
            if (tempValue >= i)
            {
                tempValue -= i;

                binaryValue += "1";
            }
            else
                binaryValue += "0";
            
        }

        //return the translation 
    	return "" + binaryValue;
    }

    public int toDecimal()
    {

        //set value int to 0 to not allow  
        value = 0;

    	//Convert the binary value to decimal

        //starting at 0, add one to the iteration unill i >= 8
        for (int i = 0; i < 8; i++)
        {
            //if the char at the length of the binary string - 1 (the last char of the string) - i is '1'
            if (binaryValue.charAt(binaryValue.length()-1-i) == '1')
                //add 2 to val the power of i, which results in the decimal value of the current binary placement in the string
                value += Math.pow(2, i);
        }

        //return the translated val
    	return value;
    }

    public String toString()
    {
        if (value > 0)
            toBinary();
        else
            toDecimal();


        return "The value in decimal is " + value + "\n" + 
        "The value in binary is " + binaryValue ;
    }


}