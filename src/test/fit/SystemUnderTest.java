package test.fit;


import test.fit.fakes.FakeRunner;

/*
 * Unfortunately, FIT forces you to use static (e.g. global) variables to
 * share information between fixtures.  This class holds the objects
 * that we are testing and those that we are using to support the tests
 * in static variables and defines some useful methods.
 */
public class SystemUnderTest {
	public static final FakeRunner billing = new FakeRunner();
	
}
