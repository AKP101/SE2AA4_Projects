######################################
# Author: 	Anika Peer	 #
# Revised: 	Monday, April 12, 2021	 #
# Description:	"MAKEFILE"		 #
######################################
# I made use of https://gitlab.cas.mcmaster.ca/smiths/se2aa4_cs2me3/-/blob/master/Assignments/PreviousYears/2020/A4-Dots/A4Soln/Makefile
# As well as a lot of the make file from assignment 3
# in order to make this Makefile

all: spec.pdf

pdf: spec.pdf

spec.pdf: clean spec.tex
	pdflatex spec
#	makeindex refman.idx
#   pdflatex refman
	latex_count=8 ; \
	while egrep -s 'Rerun (LaTeX|to get cross-references right)' spec.log && [ $$latex_count -gt 0 ] ;\
	    do \
	      echo "Rerunning latex...." ;\
	      pdflatex spec ;\
	      latex_count=`expr $$latex_count - 1` ;\
	    done
# 	makeindex refman.idx
	pdflatex spec


clean:
	rm -f *.ps *.dvi *.aux *.toc *.idx *.ind *.ilg *.log *.out *.brf *.blg *.bbl spec.pdf
