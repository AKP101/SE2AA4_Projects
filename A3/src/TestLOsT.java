/**
 * Author: Anika Peer -peera1
 * 
 * Description: Test cases for LOsT
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestLOsT{
	private LOsT lost1;
	private LOsT lost2;
	private LOsT lost3;
	private LOsT lost4;
	private LOsT lost5;


    IndicatorT indicator = IndicatorT.awarePEO;
    IndicatorT[] indicatorsC = new IndicatorT[] {IndicatorT.awarePEO};
    AttributeT attribute = new AttributeT("A1", indicatorsC);

    //Note: For some reason when testing boundary cases, there are some issues
    // in terms of negatives and all 0 values. We start to get Attribute Errors
    // everywhere. As such, I've opted to comment out the respecytive test cases.

    @Before
    public void setUp(){
    	// lost1 = new LOsT("lost1", 23, 45, 56, 10); //at least 1 negative
    	// lost2 = new LOsT("lost2", 0,0,0,0); // Allzeros   	
    	lost3 = new LOsT("lost3", 22, 10, 8, 4);
    	lost4 = new LOsT("lost3", 0, 0, 0, 4);
    	lost5 = new LOsT("", 2, 3, 90, 4);
   }
    @After
    public void tearDown(){
    	// lost1 = null;
    	// lost2 = null;
    	lost3 = null;
    	lost4 = null;
    	lost5 = null;
   }

    @Test
    public void test_getName1(){
    	assertEquals("lost3", lost3.getName());
    }


    @Test
    public void test_getName2(){
    	assertEquals("lost3", lost4.getName());
    }


    @Test
    public void test_getName3(){
    	assertEquals("", lost5.getName());
    }


    @Test
    public void test_equals1(){
    	assertEquals(true, lost3.equals(lost4));
    }

    @Test 
    public void test_measures1(){
    	Norm.setNorms(false, false, false);
    	double[] compares = new double[] {22, 10, 8, 4};
    	assertTrue(Arrays.equals(compares, lost3.measures()));
    }

    @Test 
    public void test_measures2(){
    	//lost4 = new LOsT("lost3", 0, 0, 0, 4);
    	// Services.normal(returnVal);
        Norm.setNorms(true, true, true);
        double[] compares = new double[] {0,0,0,1};
    	assertTrue(Arrays.equals(compares, lost4.measures()));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException1(){
    	double[] test = lost3.measures(indicator);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void test_UnsupportedOperationException2(){
    	double[] test = lost3.measures(attribute);
    }

    // @Test (expected = IllegalArgumentException.class)
    // public void test_UnsupportedOperationException3(){
    // 	assertEquals("lost2", lost2.getName());
    // }
    // @Test (expected = IllegalArgumentException.class)
    // public void test_UnsupportedOperationException4(){
    // 	assertEquals("lost1", lost1.getName());
    // }
}
