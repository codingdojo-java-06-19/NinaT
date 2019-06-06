
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator mathdude = new Calculator();
		mathdude.setOperandOne(10.5);
		mathdude.setOperation("*");
		mathdude.setOperation("+");
		mathdude.setOperandTwo(5.2);
		mathdude.performOperation();
		mathdude.resetOperands();
	}

}
