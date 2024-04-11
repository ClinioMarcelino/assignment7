package m;

public interface IComplex extends Comparable<Object> {
	public static final int DEFAULT_VALUE = 0;
	
	public String add(Complex cpx);

	public String subtract(Complex cpx);

	public String multiply(Complex cpx);

	public String divide(Complex cpx);

	public float abs();

}
