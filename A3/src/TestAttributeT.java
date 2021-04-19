/**
 * Author: Anika Peer -peera1
 * 
 * Description: Test cases for AttributeT
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestAttributeT{
	// used : https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2020/A3-Generic2DSeq/A3Soln/src/TestDemT.java
	private AttributeT a1;
	private AttributeT a2;
	private AttributeT a3;
	private AttributeT a4;
	private AttributeT a5;

    IndicatorT[] indicatorsA = new IndicatorT[] {IndicatorT.math,IndicatorT.tools, IndicatorT.engInSoc};
    IndicatorT[] indicatorsB = new IndicatorT[] {};
    IndicatorT[] indicatorsC = new IndicatorT[] {IndicatorT.awarePEO};
    IndicatorT[] indicatorsD = new IndicatorT[] {IndicatorT.standards, IndicatorT.healthSafety};

    @Before
    public void setUp(){
    	a1 = new AttributeT("A1", indicatorsA);
    	a2 = new AttributeT("A2", indicatorsB);    	
    	a3 = new AttributeT("A3", indicatorsC);
    	a4 = new AttributeT("A4", indicatorsD);
    	a5 = new AttributeT("", indicatorsB);
   }
    @After
    public void tearDown(){
    	a1 = null;
    	a2 = null;
    	a3 = null;
    	a4 = null;
   }

    @Test
    public void test_getName1(){
    	assertEquals("A1", a1.getName());
    }

    @Test
    public void test_getName2(){
    	assertEquals("A2", a2.getName());
    }

    @Test
    public void test_getName3(){
    	assertEquals("A3", a3.getName());
    }

    @Test
    public void test_getName4(){
    	assertEquals("A4", a4.getName());
    }

    @Test
    public void test_getName5(){
    	assertEquals("", a5.getName());
    }

    @Test
    public void test_getIndicators1(){
    	assertEquals(indicatorsB, a2.getIndicators());
    }

    @Test
    public void test_getIndicators2(){
    	assertEquals(indicatorsC, a3.getIndicators());
    }

    @Test
    public void test_getIndicators3(){
    	Boolean tester = false;
    	for (IndicatorT i : a4.getIndicators()){
    		if ((i == IndicatorT.standards)||(i == IndicatorT.healthSafety)){
    			tester = true;
    		}
    		else{
    			tester = false;
    		}
    	}
    	assertTrue(tester);
    }

    @Test
    public void test_getIndicator5(){
    	assertEquals(indicatorsB, a5.getIndicators());
    }
}
