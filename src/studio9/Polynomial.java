package studio9;

import java.util.List;
import java.util.LinkedList;

public class Polynomial {
	
	private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	
	
	public Polynomial() {
		//FIXME
		list = new LinkedList<Double>();
	}

	
	/**
	 * 
	 * @param coeff
	 * @return polynomial with added term
	 */
	public void addTerm(double coeff) {
		//FIXME
		list.add(coeff);
	}
	
	/*
	 * Returns a String of the polynomial with the proper form:
	 * 
	 * Cx^N + Cx^N-1 + ... + Cx + C
	 */
	public String toString() {
		if(list.size() == 0) {
			return "";
		}

		String result = "";
		int highestPower = list.size() - 1;

		for(int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);
			int power = highestPower - i; 

			if (i>0) {
				result += "+";
			}
			if (power>1) {
				result += coeff + "x^" + power;
			}
			else if (power == 1) {
				result += coeff + "x";
			} else {
				result += coeff;
			}
		}
		return result; //FIXME
	}
	
	/**
	 * 
	 * @param x
	 * @return value of polynomial at that x
	 */
	public double evaluate(double x) {
		if (list.size() == 0) {
			return 0;
		}
		double result = 0;
		int highestPower = list.size() - 1;


		for (int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);
			int power = highestPower - i;

			if (power>1) {
				result += coeff * Math.pow(x,power);
			}
			else if (power == 1) {
				result += coeff * x;
			} else {
				result += coeff;
			}
		}
		return result;//FIXME
	}

	
	public Polynomial derivative() {
		Polynomial derivative = new Polynomial();
		
		int highestPower = list.size() - 1;

		for(int i = 0; i < list.size(); i++) {
			double coeff = list.get(i);
			int power = highestPower - i; 
			derivative.addTerm(coeff*power);

		}
		return derivative; //FIXME
	}
	

	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}