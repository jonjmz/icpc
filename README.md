#Structure
Solutions have the following characteristics
- Single file
- Named `Main.java`
- contains class named `aout` with main method
- directory should contain `in` and `out` file
- `in` and `out` file should be exactly the same as samples prvided by icpc

#Makefile
Because makefile is the same for every solution it is provided only one with three options. `default` `test` and `clean`.

In order to run
- `cd` into the solution directory
- `make -f ../../makefile` to compile
- `make -f ../../makefile test` to test

#Testing
Running make with the `test` option will run the program with input from the `in` file and `diff` it against the `out` file. The output will look like the following.

![Sample](http://i.imgur.com/WAvzDk6.png)

#Contributing
This repo isn't meant to be an authoratative set of solution, it's just to keep my work organized. However, if you find a problem with any solutions, please feel free to let me know how it could have been done better.
