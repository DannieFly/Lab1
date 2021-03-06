package whitetest;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;
import calculator.Calculator.Monomial;

public class TestCase5 {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void test1() {
		ArrayList <Monomial> exp;
		exp = Calculator.expression("2a*b+c");
		Calculator.derivative(exp,"!d/da");
		String result = outContent.toString();
		assertEquals("2.0*b\n", result);
	}
}
