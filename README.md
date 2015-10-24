#Structure
Solutions have the following characteristics
- Single file
- Named `Main.java`
- contains class named `aout` with main method
- directory should contain `in` and `out` file
- `in` and `out` file should be exactly the same as samples prvided by icpc
- Problems that have been solved should be a `README.md` file with the text `#Passing` in it
- Solutions that are not passing should not have a `README.md` file.

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
This repo isn't meant to be an authoratative set of solution, it's just to keep my work organized. However, if you find a problem with any solutions I have marked as solved, please feel free to let me know how it could have been done better, or what fatel flaw I have overlooked.
