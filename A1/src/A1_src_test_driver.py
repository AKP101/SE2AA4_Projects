## @file test_driver.py
#  @author Anika Krishna Peer
#  @brief A module that tests the first module (complex_adt.py) and the second one (triangle_adt.py)
#  @date January 19 2021

# TESTCASES:
# I took the testing method from an old test case for A1 in 2018 as well as an online python float comparison document:
# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2018/A1/A1Soln/src/testSeqs.py
# https://www.linuxtopia.org/online_books/programming_books/python_programming/python_ch07s02.html

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
#############################__COMPLEX NUMBER CASES__#######################
def equalityCases(test, result, name):
	if (abs(test-result)<0.00001):
		print("Test passed: "+ str(test) + " == " + str(result) +", "+ name)
	else:
		print("Test failed: "+ str(test)+ " != " + str(result) +", "+name)
 
def equalityCasesBoolean(test, result, name):
	if (test == result):
		print("Test passed: "+ str(test) + " == " + str(result) +", "+ name)
	else:
		print("Test failed: "+ str(test)+ " != " + str(result) +", "+name)

def approxCases(test, result, name):
	if (abs(round(test,3)-result)<=0.00001): # picked the rounding as a test method because rounding within 3 decimal places should be more or less accurate. 
		print("Test passed: "+ str(test) + " is approximately " + str(result) +", "+ name)
	else:
		print("Test failed: "+ str(test)+ " is not approximately " + str(result) +", "+name)
#real() test cases
def real_test():
	a = ComplexT(1.0, 2.0)
	b = ComplexT(-0.5, 0.5)


	equalityCases(a.real(), 1.0, "No Negatives real part")
	equalityCases(b.real(), -0.5, "Negative real part")

def imag_test():
	a = ComplexT(1.0, 2.0)
	b = ComplexT(0.5, -0.5)

	equalityCases(a.imag(), 2.0, "No negatives real part")
	equalityCases(b.imag(), -0.5, "Negative imaginary part")

def get_r_test():
	a = ComplexT(0.0, 2.4422)
	b = ComplexT(-3.7899, -0.232323)
	approxCases(a.get_r(), 2.442, "Absolute value with 0 part")
	approxCases(b.get_r(), 3.797, "getting absolute value")

def get_phi_test():
	# As stated in the file complex_adt.py, this does not account for entries where both x and y are 0
	# As such I will not be testing for such cases.
	a = ComplexT(-1.0003, 0.0)
	b = ComplexT(7.4343, 0.0)
	c = ComplexT(-9.24, 3.33)
	approxCases(a.get_phi(), 3.142, "Phi value with negative real and imag 0 pi")
	approxCases(b.get_phi(), 0.000 , "Phi value positive real number and y = 0")
	approxCases(c.get_phi(), 2.796, "Phi value negative real number and y!= 0")
def equal_test():
	a = ComplexT(-1.0003, 2.0)
	b = ComplexT(-1.0003, 2.0)
	c = ComplexT(1.0003, -2.0)
	d = ComplexT(1.003, 2.03)
	equalityCasesBoolean(a.equal(c), False, "Switching negatives and checking equality")
	equalityCasesBoolean(a.equal(d), False, "Checking equality through decimals")
	equalityCasesBoolean(a.equal(b), True, "Checking equality normally")
def conj_test():
	a = ComplexT(-1.0003, 5.7).conj()
	b = ComplexT(0.0, 3.99).conj()

	equalityCases(a.real(),-1.0003,"Checking conjugate real part")
	equalityCases(a.imag(),-5.7, "Checking imaginary part of conjugate")
	equalityCases(b.real(),0.0,"Checking conjugate real part")
	equalityCases(b.imag(),-3.99, "Checking imaginary part of conjugate")

def add_test():
	a = ComplexT(-1.0, 2.0)
	b = ComplexT(0.0, -0.5)
	d = ComplexT(0.220, 0.5346)
	e = ComplexT(0.558, 0.3)

	equalityCases(a.add(b).real(),-1.0,"Adding with random negatives - real")
	equalityCases(a.add(b).imag(),1.5,"Adding with random negatives - imag")
	equalityCases(d.add(e).real(),0.778,"Adding with all positives - real")
	equalityCases(d.add(e).imag(),0.8346,"Adding with all positives - imag")

def sub_test():
	a = ComplexT(-1.0, 2.0)
	b = ComplexT(0.0, -0.5)
	d = ComplexT(0.220, 0.5346)
	e = ComplexT(0.558, 0.3)
	equalityCases(a.sub(b).real(),-1.0,"Subtracting with random negatives - real")
	equalityCases(a.sub(b).imag(),2.5,"Subtracting with random negatives - imag")
	equalityCases(d.sub(e).real(),-0.338,"Subtracting with all positives - real")
	equalityCases(d.sub(e).imag(),0.2346,"Subtracting with all positives - imag")

def mult_test():
	a = ComplexT(-1.0, 6.0)
	b = ComplexT(0.0, -5.5)
	d = ComplexT(0.524, 0.83556)
	e = ComplexT(0.55865, 0.4566)
	approxCases(a.mult(b).real(),33,"Multiplying with random negatives - real")
	approxCases(a.mult(b).imag(),5.5,"Multiplying with random negatives - imag")
	approxCases(d.mult(e).real(),-0.089,"Multiplying with all positives - real")
	approxCases(d.mult(e).imag(),0.706,"Multiplying with all positives - imag")

def recip_test():
	# Maintain the assumption that both values cannot be 0 simultaneously.
	a = ComplexT(0.0, -6.0)
	e = ComplexT(0.55865, 0.4566)
	approxCases(a.recip().real(),0,"Reciprocal with random negatives and a 0- real")
	approxCases(a.recip().imag(),0.167,"Reciprocal with random negatives and a 0 - imag")
	approxCases(e.recip().real(),1.073,"Reciprocal with all positives - real")
	approxCases(e.recip().imag(),-0.877,"Reciprocal with all positives - imag")

def div_test():
	# Maintain the assumption that both values cannot be 0 simultaneously.
	a = ComplexT(-3.577, -6.966)
	c = ComplexT(55.99, -3.415555)
	e = ComplexT(0.55865, 0.4566)
	approxCases(c.div(a).real(),-0.056,"Division with both negatives - real")
	approxCases(c.div(a).imag(),-0.128,"Division with both negatives - imag")
	approxCases(e.div(c).real(),57.089,"Division with both negatives - real")
	approxCases(e.div(c).imag(),-52.775,"Division with both negatives - imag")
	approxCases(a.div(e).real(),-0.084,"Division with one set of negatives- real")
	approxCases(a.div(e).imag(),0.037,"Division with one set of negatives- imag")

def sqrt_test():
# In this case the imaginary value cannot 
	a = ComplexT(3.577, 0)
	b = ComplexT(-3.577, 0)
	c = ComplexT(55.99, -3.415555)
	e = ComplexT(0.55865, 0.4566)
	approxCases(a.sqrt().real(),1.891,"Square Root test case real.")
	approxCases(a.sqrt().imag(), 0 , "Square Root test case imag.")
	approxCases(b.sqrt().real(),0,"Square Root test case real.")
	approxCases(b.sqrt().imag(),1.891, "Square Root test case imag.")
	approxCases(c.sqrt().real(),7.486,"Square Root test case real.")
	approxCases(c.sqrt().imag(),-0.228,"Square Root test case imag.")
	approxCases(e.sqrt().real(),0.800,"Square Root test case real.")
	approxCases(e.sqrt().imag(),0.285,"Square Root test case imag.")



#############################__TRIANGLE_CASES__#######################


def get_sides_test(): 
	t1 = TriangleT(3, 4, 5)
	t2 = TriangleT(1,2,3)
	equalityCasesBoolean(t1.get_sides(),(3,4,5),"checking all 3 sides")
	equalityCasesBoolean(t2.get_sides(),(1,2,3),"checking all 3 sides")


def equal_tri_test(): 
	t1 = TriangleT(3, 4, 5)
	t2 = TriangleT(5, 3, 4)
	t3 = TriangleT(99, 3, 4)
	equalityCasesBoolean(t1.equal(t2),True,"All sides are equal")
	equalityCasesBoolean(t2.equal(t3),False,"All sides are not equal")

def perim_test(): 
	t1 = TriangleT(7, 9, 5)
	t3 = TriangleT(99,100, 98)
	t2 = TriangleT(4, 7, 8)
	equalityCasesBoolean(t1.perim(),21,"Testing perimeter 1")
	equalityCasesBoolean(t3.perim(),297,"Testing perimeter 2")
	equalityCasesBoolean(t2.perim(),19,"Testing perimeter 3")

def area_test(): 
	t1 = TriangleT(7, 9, 5)
	t3 = TriangleT(99,100, 98)
	t2 = TriangleT(4, 7, 8)
	approxCases(t1.area(),17.412,"Testing area 1")
	approxCases(t3.area(),4243.091,"Testing area 2")
	approxCases(t2.area(),13.998,"Testing area 3")

def is_valid_test(): 
	t1 = TriangleT(7, 9, 50000000)
	t2 = TriangleT(4, 7, 8)
	t3 = TriangleT(9,100, 98)
	equalityCasesBoolean(t1.is_valid(), False,"Validity test 1")
	equalityCasesBoolean(t3.is_valid(), True,"Validity test 2")
	equalityCasesBoolean(t2.is_valid(), True,"Validity test 3")
def tri_type_test():
	t1 = TriangleT(7, 7, 7)
	t2 = TriangleT(3, 4, 5)
	t3 = TriangleT(9, 9, 8)	
	t4 = TriangleT(7, 9, 13)	
	equalityCasesBoolean(t1.tri_type(),TriType.equilat,"Triangle type test equilateral")
	equalityCasesBoolean(t2.tri_type(), TriType.right,"Triangle type test right")
	equalityCasesBoolean(t3.tri_type(), TriType.isosceles,"Triangle type test isosceles")
	equalityCasesBoolean(t4.tri_type(), TriType.scalene,"Triangle type test scalene")





def allTests():
	print("COMPLEX TESTS")
	print("")
	print("")
	real_test()
	imag_test()
	get_r_test()
	get_phi_test()
	equal_test()
	conj_test()
	add_test()
	sub_test()
	mult_test()
	recip_test()
	div_test()
	sqrt_test()
	print("")
	print("")
	print("TRIANGLE TESTS")
	print("")
	print("")
	get_sides_test()
	equal_tri_test()
	perim_test()
	area_test()
	is_valid_test()
	tri_type_test()
allTests()













