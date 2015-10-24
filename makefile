JCC = javac
JFLAGS = -g
.PHONY: test
default:
	@#Actual Compilation
	@$(JCC) $(JFLAGS) Main.java && printf "\e[7;1;92mCOMPILED\e[0m\n" || printf "\e[7;1;91m ERRORS \e[0m\n"

test: default
	@#Running with test input
	@cat in | java aout > test
	@#Checking for differences
	@diff -y out test && printf "\e[7;1;92m PASSED \e[0m\n" || printf "\e[7;1;91m FAILED \e[0m\n"
	@#Cleans up directory by calling this same file
	@$(RM) *.class
	@$(RM) test
clean: 
	@#Allows user to clean directory if make was called without test
	@$(RM) *.class

