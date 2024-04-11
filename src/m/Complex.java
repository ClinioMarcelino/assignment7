package m;

import java.util.Scanner;

public class Complex implements IComplex {
	private float realPart, imaginaryPart = DEFAULT_VALUE;

	public Complex(float a, float b) {
		setRealPart(a);
		setImaginaryPart(b);
	}

	public Complex(float a) {
		setRealPart(a);
	}

	public Complex(Object obj) throws Exception {
		if (Complex.class != obj.getClass())
			throw new Exception("The object passed to the copy constructor is not an instaceo of the class Complex");
		Complex cpx = (Complex) obj;
		setRealPart(cpx.getRealPart());
		setImaginaryPart(cpx.getImaginaryPart());
	}

	public Complex() {
		this(DEFAULT_VALUE,DEFAULT_VALUE);
	}

	public float getRealPart() {
		return realPart;
	}

	public void setRealPart(float a) {
		this.realPart = a;
	}

	public float getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(float b) {
		this.imaginaryPart = b;
	}

	public String toString() {
		return this.output(this.getRealPart(), this.getImaginaryPart());
	}

	@Override
	public String add(Complex cpx) {
		float a = this.getRealPart() + cpx.getRealPart();
		float b = this.getImaginaryPart() + cpx.getImaginaryPart();
		return output(a, b);
	}

	@Override
	public String subtract(Complex cpx) {
		float a = this.getRealPart() - cpx.getRealPart();
		float b = this.getImaginaryPart() - cpx.getImaginaryPart();
		return output(a, b);
	}

	@Override
	public String multiply(Complex cpx) {
		float a = this.getRealPart() * cpx.getRealPart() - this.getImaginaryPart() * cpx.getImaginaryPart();
		float b = this.getImaginaryPart() * cpx.getRealPart() + this.getRealPart() * cpx.getImaginaryPart();

		return output(a, b);
	}

	@Override
	public String divide(Complex cpx) {
		float a = (this.getRealPart() * cpx.getRealPart() + this.getImaginaryPart() * cpx.getImaginaryPart())
				/ (cpx.getRealPart() * cpx.getRealPart() + cpx.getImaginaryPart() * cpx.getImaginaryPart());
		float b = (this.getImaginaryPart() * cpx.getRealPart() - this.getRealPart() * cpx.getImaginaryPart())
				/ (cpx.getRealPart() * cpx.getRealPart() + cpx.getImaginaryPart() * cpx.getImaginaryPart());

		return output(a, b);

	}

	@Override
	public float abs() {
		return (float) Math.sqrt(Math.pow(this.realPart, 2) + Math.pow(this.imaginaryPart, 2));
	}

	@Override
	public int compareTo(Object obj) {
		if (Complex.class != obj.getClass())
			return -1;
		Complex cpx = (Complex) obj;
		if (this.abs() == cpx.abs())
			return 1;
		else
			return 0;
	}

	private String output(float a, float b) {
		if (b == 0)
			return a + "";
		else if (b < 0)
			return a + " " + b + "i";
		else
			return a + " + " + b + "i";
	}

	public static void main(String a[]) {

		Scanner sc = new Scanner(System.in);
		float num1, num2;

		Complex cpx1 = new Complex(), cpx2 = new Complex();

		System.out.print("Enter the first complex number: ");
		try {
			String str = sc.nextLine();
			str.trim();
			num1 = Float.parseFloat(str.substring(0, str.indexOf(" ")));
			num2 = Float.parseFloat(str.substring(str.indexOf(" ") + 1));
			cpx1 = new Complex(num1,num2);

		} catch (Exception e) {
			System.out.println("ERROR: the input was invalid");
		}

		System.out.print("Enter the second complex number: ");
		try {
			String str = sc.nextLine();
			str.trim();
			cpx2 = new Complex(Float.parseFloat(str.substring(0, str.indexOf(" "))),
					Float.parseFloat(str.substring(str.indexOf(" ") + 1)));

		} catch (Exception e) {
			System.out.println("ERROR: the input was invalid");
		}

		System.out.println(cpx1.add(cpx2));
		System.out.println(cpx1.subtract(cpx2));
		System.out.println(cpx1.multiply(cpx2));
		System.out.println(cpx1.divide(cpx2));
		System.out.println(cpx1.abs());
		System.out.println(cpx1.compareTo(cpx2));

	}

}
