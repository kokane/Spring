package sping.learningtest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcSumTest {
	
	Calculator calculator;
	String numfilepath;
	
	@Before
	public void setUp() {
		this.calculator = new Calculator();
		this.numfilepath = getClass().getResource("number.txt").getPath();
	}

	@Test
	public void sumOfNumbers()  throws IOException {
		assertThat(calculator.calcSum(numfilepath), is(10));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(numfilepath), is(24));
	}
	
	@Test
	public void concatenateString() throws IOException {
		assertThat(calculator.concatenate(numfilepath), is("1234"));
	}
}
