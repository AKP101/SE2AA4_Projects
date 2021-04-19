/**
 * Author: Anika Peer -peera1
 * 
 * Description: Test cases for ProgramT
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestProgramT{
	private ProgramT program1 = new ProgramT();

	IndicatorT indicator = IndicatorT.awarePEO;
	IndicatorT[] indicatorsPop = new IndicatorT[] {IndicatorT.standards, IndicatorT.healthSafety};
	CourseT course1 = new CourseT("course1", indicatorsPop);// Multiple


    @Before
    public void setUp(){
    	program1.add(course1);	
   }
    @After
    public void tearDown(){
    	program1 = null;

    }
    
    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException1(){
    	double[] test = program1.measures();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException2(){
    	double[] test = program1.measures(indicator);
    }

}
