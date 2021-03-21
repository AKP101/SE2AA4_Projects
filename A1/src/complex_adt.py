## @file complex_adt.py
#  @author Anika Krishna Peer
#  @brief Contains a class for working with complex numbers
#  @date 01/16/2020


import math


## @brief An ADT for complex numbers
#  @details A complex number is made of a real and complex part.
class ComplexT:
# Looked at all files here for more than one method:
# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/tree/master/Assignments/PreviousYears/2019/A1/A1Soln/src
# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/tree/master/Assignments/PreviousYears/2020/A1/A1Soln/src

	## @brief Constructor for ComplexT
	#  @details Creates a ComplexT object given a real and complex part of a complex number.
	#  @param x float representing the real part of the complex number.
	#  @param y float representing the imaginary part of the complex number.
	def __init__(self, x, y):
		self.x = x
		self.y = y
   
	## @brief gets the real part (x) from the complex number.
	#  @return float representing the real part of the complex number
	def real(self):
		return self.x 
		
	## @brief gets the imaginary part (y) from the complex number.
	#  @return float representing the imaginary part of the complex number
	def imag(self):
		return self.y 
		
	## @brief Calculates the absolute value of a complex number and returns
	#  @details Calculates the absolute value of a complex number using the 
	#           square root of the sum of squares of the real and complex parts of a complex number.
	#  @return returns float absolute value of complex number
	def get_r(self):
	#  The link below was used to figure out pythons square root function
	#  https://www.geeksforgeeks.org/python-math-function-sqrt/
	#  The link below was used to figure out the complex number function
	#  https://www2.clarku.edu/faculty/djoyce/complex/abs.html
	
		return math.sqrt((self.x**2) + (self.y**2))
		
	## @brief Calculates phase of a complex number in radians
	#  @details Uses arctan and absolute value of a complex number to calculate phase 
	#           of a complex number in radians. Assumes that real and imaginary parts are not 0.
	#  @return returns float value of the phase of a complex number in radians
	def get_phi(self):
	#  Writing my assumptions in the details section was an idea I saw by Andrew Rong on the discussion board
	#  https://avenue.cllmcmaster.ca/d2l/le/375601/discussions/threads/1493910/View	
	#  As for the formula to calculate phi, I used Wikipedia
	#  https://en.wikipedia.org/wiki/Complex_number
		if ((self.y ==0) & (self.x < 0)):
			return math.pi
		else:
			return (2 * (math.atan((self.y)/(self.get_r() + self.x))))
	
	## @brief Checks if two complex numbers are equal
	#  @details Compares the real and imaginary parts of two complex numbers to see if they are equal
	#  @param comp The complex number to check if its the same as our complex number object
	#  @return Boolean True if the complex numbers are equal and false otherwise
	def equal(self, comp):
	#  Used thew3schools link to find the and notation: https://www.w3schools.com/python/python_operators.asp
		return (comp.y == self.y) & (comp.x == self.x)
		
	## @brief Returns conjugate of a complex number 
	#  @return Returns a Complex number that is the conjugate of our current complex number
	def conj(self):
		return ComplexT(self.x, - self.y) 
	
	## @brief Calculates the sum of two complex numbers.
	#  @detail Adds the real parts of the complex numbers together 
	#          then does the same for the imaginary parts, then returns the resulting complex number.
	#  @param compNum complex number that will be added to current complex number.
	#  @return Returns a ComplexT value (complex number) that is the sum of the 
	#          argument and the current complex number.
	def add(self, compNum):
	#  Used the Khan Academy link below:
	#  https://www.khanacademy.org/math/algebra2/x2ec2f6f830c9fb89:complex/x2ec2f6f830c9fb89:complex-add-sub/v/adding-complex-numbers		
		return ComplexT((self.x+compNum.x),(self.y+compNum.y))		
	
	## @brief Calculates the difference of two complex numbers and returns that
	#  @detail subtracts the real parts of the complex numbers then does the same for 
	#          the imaginary parts, then returns the resulting complex number.
	#  @param compNum complex number that current complex number will be subtracted by.
	#  @return Returns a ComplexT value (complex number) that is the difference of the 
	#          argument and the current complex number. 
	def sub(self, compNum):
	#  Used the Khan Academy link below:
	#  https://www.khanacademy.org/math/algebra2/x2ec2f6f830c9fb89:complex/x2ec2f6f830c9fb89:complex-add-sub/v/subtracting-complex-numbers
		return ComplexT((self.x-compNum.x),(self.y-compNum.y))		
	
	## @brief Calculates the product of two complex numbers and returns it
	#  @detail Distributes the complex and real parts of he argument and our 
	#          complex number and multiples them together, then adds all the terms and multiples 
	#          the two imaginary parts by -1 to compensate for i**2
	#  @param compNum complex number that will be multiplied by current complex number
	#  @return Returns a ComplexT value (complex number) that is the product of the argument and the current complex number 
	def mult(self, compNum):
	#  Used the Khan Academy link below:
	#  https://www.khanacademy.org/math/algebra2/x2ec2f6f830c9fb89:complex/x2ec2f6f830c9fb89:complex-mul/a/multiplying-complex-numbers
		term1 = self.x * compNum.x
		term2 = (self.x * compNum.y) + (self.y * compNum.x)
		term3 = -(self.y * compNum.y)
		final_Imag = term2
		final_Real = term1 + term3
		return ComplexT(final_Real, final_Imag)
				
	## @brief Calculates the reciprocal of a complex number and returns it
	#  @detail Divides the real and imaginary parts by the sums of the squares of the 
	#          imaginary and real parts and subtracts them from each other. Assuming both real and 
	#          imaginary are not 0 at the same time.
	#  @return Returns a ComplexT value that is the reciprocal of the current complex number. 
	def recip(self):
	#  Used the Wikipedia link below:
	#  https://en.wikipedia.org/wiki/Complex_number#Reciprocal_and_division	
		term1 = self.x/((self.x ** 2) + (self.y ** 2))
		term2 = self.y/((self.x ** 2) + (self.y ** 2))			
		return ComplexT(term1, -term2)
	
	
	## @brief Calculates the output of the division of two complex numbers and returns it
	#  @detail Assuming both real and imaginary are not 0 at the same time. 
	#          The output is derived through the sum /differences of the products of real and imaginary values 
	#          as well as the sum of squares.
	#  @param compNum complex number that current xomplex number will be divided by.
	#  @return Returns a ComplexT value that is the output of the division of a complex 
	#          number and our complex number (self). 
	def div(self, compNum):
	#  Used the Wikipedia link below:
	#  https://en.wikipedia.org/wiki/Complex_number#Reciprocal_and_division	
		term1 = ((self.x ** 2) + (self.y ** 2))
		term2Mul = (self.x * compNum.x) + (self.y * compNum.y)
		term3Mul = (self.x * compNum.y) - (self.y * compNum.x)
		final_Imag = term3Mul/term1	
		final_Real = term2Mul/term1	
		return ComplexT(final_Real, final_Imag)	
		
	## @brief Calculates the square root of a complex number and return it.
	#  @detail Uses the formula with signum, otherwise returns a normal square root. 
	#          Also has the provision of retuning a sqaure root of complex numbers with positive or negative real parts
	#  @return Returns a ComplexT value that is the positive square root of a complex number
	def sqrt(self):
	#  Used the given Wikipedia link below:
	#  https://en.wikipedia.org/wiki/Complex_number#Reciprocal_and_division
	#  https://en.wikipedia.org/wiki/Sign_function
		sign = 0
		if (self.y < 0):
			sign = -1
		elif (self.y == 0):
			if (self.x > 0):
				return ComplexT(math.sqrt(self.x),0)
			else:
				return ComplexT(0,math.sqrt(-self.x))				
		else:
			sign = 1
		gamma = math.sqrt((self.x + (math.sqrt(self.x**2 + self.y**2)))/2)
		sigma_init = sign * math.sqrt((- self.x + (math.sqrt(self.x**2 + self.y**2)))/2)
		return ComplexT(gamma, sigma_init)
