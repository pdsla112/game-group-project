package com.company.parser;

/**
 * MultExp: it is extended from the abstract class Exp,
 * 		    This class is used to represent the expression of multiplication
 *
 * You are not required to implement any function inside this class.
 * Please do not change anything inside this class as well.
 */

public class UseExp extends Exp {

	private Exp term;

	public UseExp(Exp term) {
		this.term = term;
	}

	@Override
	public String show() {
		return "use " + term.show();
	}

	@Override
	public int evaluate() {
		return 0;
	}
}