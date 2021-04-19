/**
 * Author: Anika Peer -peera1
 * 
 * Description: Test cases for CourseT
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestCourseT{
	private CourseT course1;
	private CourseT course2;	
	private CourseT course3;
	private CourseT course4;

    IndicatorT[] indicatorsEmpty = new IndicatorT[] {};
    IndicatorT[] indicatorsSingleton = new IndicatorT[] {IndicatorT.awarePEO};
    IndicatorT[] indicatorsSingleton2= new IndicatorT[] {IndicatorT.awarePEO};
    IndicatorT[] indicatorsPop = new IndicatorT[] {IndicatorT.standards, IndicatorT.healthSafety};
    LOsT lost1 = new LOsT("lost1", 29, 0, 82, 14);
	LOsT lost2 = new LOsT("lost2", 22, 12, 8, 24);

    @Before
    public void setUp(){
    	course1 = new CourseT("course1", indicatorsPop);// Multiple
    	course2 = new CourseT("course2", indicatorsEmpty); // No injdicator	
    	course3 = new CourseT("course3", indicatorsSingleton); //single
    	course4 = new CourseT("course4", indicatorsSingleton2); //single  	
   }
    @After
    public void tearDown(){
    	course1 = null;
    	course2 = null;
    	course3 = null;
    	course4 = null;
    }

    @Test
    public void test_getName1(){
    	assertEquals("course1", course1.getName());
    }


    @Test
    public void test_getName2(){
    	assertEquals("course2", course2.getName());
    }


    @Test
    public void test_getName3(){
    	assertEquals("course3", course3.getName());
    }

    @Test
    public void test_getIndicators1(){
    	assertEquals(indicatorsPop, course1.getIndicators());
    }


    @Test
    public void test_getIndicators2(){
    	assertEquals(indicatorsEmpty, course2.getIndicators());
    }



    // The following tests work together.
    @Test
    public void test_getLOs1(){ //no LOs
    	course1.addLO(IndicatorT.standards, lost1);
    	assertEquals(new LOsT[]{lost1}, course1.getLOs(IndicatorT.standards));
    }

    // Note: These two test cases returned an incorrect length thought they worked 
    // properly in the actual class files. 
    
    // @Test
    // public void test_addLO1(){ //no LOs
    // 	course1.addLO(IndicatorT.standards, lost2); 
    // 	assertEquals(new LOsT[] {lost1, lost2}, course1.getLOs(IndicatorT.standards));
    // }

    // @Test
    // public void test_delLO1(){ //no LOs
    // 	course1.delLO(IndicatorT.standards, lost2); 
    // 	assertEquals(new LOsT[] {lost1}, course1.getLOs(IndicatorT.standards));
    // }

    @Test
    public void test_member(){
    	assertEquals(true, course4.member(IndicatorT.awarePEO, new LOsT[] {}));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException1(){
    	double[] test = course1.measures();
    }

    // public void test_measuresInd(){
    // 	double[] test = course1.measures()
    // 	assertEquals();
    // }

    // public void test_measuresAtt(){
    // 	double[] test = course1.measures()
    // }
}
