## @file triangle_adt.py
#  @author Anika Krishna Peer
#  @brief Contains a class for working with triangles
#  @date 01/18/2020

import math
from enum import Enum, auto 

## @brief Enumerated TriType
#  @details A tritype can be isoceles, scalene, equilateral or right
class TriType(Enum):
	equilat = auto()
	isosceles = auto()
	scalene = auto()
	right = auto()

## @brief An ADT representing triangles
#  @details A triangle is composed of  3 sides, x, y, z
class TriangleT:
# All methods inherently assume that inputs are non-negative and greater than 0
# I got the idea for citing sources inside a method from: Farzan Yazdanjou
# Looked here at multiple files for more than one method:
# https://docs.python.org/3/library/enum.html
# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/tree/master/Assignments/PreviousYears/2019/A1/A1Soln/src
# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/tree/master/Assignments/PreviousYears/2020/A1/A1Soln/src

	## @brief Constructor for TriangleT
	#  @details Creates a triangle given 3 sides
	#  @param x Integer respresenting the first length
	#  @param y Integer representing the second length
	#  @param z Integer representing the third length
	def __init__(self, x, y, z):
	# Looked at assignment 2 from 2019 for enum
	# https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2019/A2/A2Soln/src/StdntAllocTypes.py
		self.x = x
		self.y = y
		self.z = z
		
	## @brief gets the three sides of the triangle as a tuple
	#  @return tuple of three integers representing the lengths of the triangle
	def get_sides(self):
		return (self.x, self.y, self.z)
		
	## @brief Checks if a given triangle is equal to the current triangle
	#  @detail Pulls the two tuples of the triangles and sorts them in lists. 
	#          Then compares each of the individual elements to see if the two lists are equal
	#  @param newTriangle Triangle that current Triangle will be compares to to see if they are equal
	#  @return a boolean value True if they are equal and False if not
	def equal(self, newTriangle):
		useTuple = newTriangle.get_sides()
		selfTuple = self.get_sides()
		list1 = []
		list2 = []
		for i in useTuple:
			list1.append(i) 
		for j in selfTuple:
			list2.append(j) 

		list1.sort()
		list2.sort()

		for i in range(3):
			if (list1[i] != list2[i]):
				return False;
				
		return True;

	## @brief Calculates the perimeter of a triangle
	#  @detail Adds all lengths to find perimeter of a triangle
	#  @return Integer representing the perimter of the trianle
	def perim(self):
		return (self.x + self.y + self.z)

	## @brief Calculates the area of a triangle
	#  @detail Adds all lengths and then divides by two. Assumes triangle is valid.
	#          Then uses the rest of heron's formula to find the area.
	#  @return float representing the perimter of the triangle
	def area (self):
	#  Blog post about Heron's formula
	#  https://socratic.org/questions/how-do-you-find-the-area-of-a-triangle-with-3-sides-given
		s = float(self.x + self.y + self.z)/2
		area = math.sqrt(s*(s-self.x )*(s-self.y)*(s-self.z))
		return area


	## @brief Checks if triangle is valid
	#  @detail Adds two lengths and compares them to the third to see if they are greater. 
	#          If all of the combinations work returns true.
	#  @return Boolean value asserting if triangle is valid
	def is_valid (self):
		trial1 = ((self.x + self.y) >= self.z) 
		trial2 = ((self.x + self.z) >= self.y)
		trial3 = ((self.z + self.y) >= self.x)
		return (trial1 & trial2 & trial3)

	## @brief Classifies triangle as one of the tritypes
	#  @detail Assumes triangle is valid. Checks if all sides are equal, then if two are.
	#          Then it checks if the squares of any of the two sides equal top the square of the third.
	#	       To check for right triangles. It classifies Non-right triangles as Scalene if none of 
	#          the sides are equal
	#  @return Tritype that classifies the triangle as scalene, right, equilateral or isosceles
	def tri_type (self):
		if ((self.x == self.y) & (self.y == self.z)):
			return TriType.equilat
		

		selfTuple = self.get_sides()
		list1 = []
		for i in selfTuple:
			list1.append(i) 
		list1.sort()
		for i in range(3):
			if ((i-1) != -1):
				if (list1 [i] == list1 [i-1]):
					return TriType.isosceles

		trial1 = ((self.x**2 + self.y**2) == self.z**2) 
		trial2 = ((self.x**2 + self.z**2) == self.y**2)
		trial3 = ((self.z**2 + self.y**2) == self.x**2)	

		if (trial1 | trial2 | trial3):
			return TriType.right
			
		
		if ((self.x != self.y) & (self.y != self.z) & (self.x != self.z)):
			return TriType.scalene
