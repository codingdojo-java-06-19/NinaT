class Calculator implements java.io.Serializable {
	private double operandOne;
	private double operandTwo;
	private String operation;
	
    public Calculator(){
    }
    
    public double setOperandOne(double num){
        this.operandOne = num;
        System.out.println("Operand One successfully set to "+this.operandOne);
        return this.operandOne;
    }
    
    public double setOperandTwo(double num){
        this.operandTwo = num;
        System.out.println("Operand Two successfully set to "+this.operandTwo);
        return this.operandTwo;
    }
    
    public void resetOperands() {
    	this.operandOne = 0;
    	this.operandTwo = 0;
    	System.out.println("Both Operands reset to zero.");
    }
    
    public String setOperation(String arg) {
    	if (arg =="+" || arg == "-") {
    		this.operation = arg;
    		return this.operation;
    	}
    	else {
    		System.out.println("Only + or - currently supported!!");
    		return "Does not compute!";
    	}
    }
    
    public double performOperation(){
    	double result = 0;
    	System.out.println("Caculating the following operation...");
    	if (this.operation =="+") {
        	result = this.operandOne + this.operandTwo;
        	
        }
        else {
        	result = this.operandOne - this.operandTwo;
        }
    	System.out.println(this.operandOne+" "+this.operation+" "+this.operandTwo+" = "+result);
    	return result;
    }
}
