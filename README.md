# Lotto app 
A simple command line app which can generate lotto numbers and calculate how long it takes for the user to win. Also includes various methods relating to Arrays, Math and error checking.

# Motivation
Made as part of course on the basics of java and programming. This project was the introduction to packages and documentation.

# Features
User inputs 7 (by default, can be easily changed in code) unique numbers between 1 and 40 (can also be changed) directly when launching app from command line (ex. java Lotto 1 2 3 4 5 6 7). If the user did not input the correct amount of numbers when launching, they will be asked to give them one at a time. The app will generate random series' of lotto numbers until one of them matches the users numbers, then output how many tries it took (1 try is 1 week). Then it will do the same for 2 matching numbers and so on. After the user has gotten all matching numbers, if it took more than 120 years the app will start over, and do this until the user gets a jackpot within 120 years. The app can also show the results of each attempt, displaying both the users numbers and the generated numbers in ascending order with prefixes (ex. 01, 02, 13).

For the project, I also created helper methods of three types: Array related methods, math related methods and methods that can detect invalid inputs.

# Code Example
