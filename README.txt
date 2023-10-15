Project assignment from JetBrains Academy (www.hyperskill.org), Java Core track.

The program converts number (including decimal numbers) from one base to another. The base
(also called the radix) can be anywhere between binary (base 2) to base 36 (which includes
all decimal digits plus any Latin alphabet).

The program first asks for the bases that user want to convert, in the format: {source base}
 {target base} (i.e. base values separated by a single space). Therefore, if the user wants to
convert numbers from binary to decimal, they will enter: 2 10. Afterwards, the program will
convert numbers supplied by the user from this specific source base to target base, until the 
user enters "/back" to specify new source and target base values.

The program is capable of converting decimal numbers from one base to another. The resultant 
decimal number in the target base will be printed to five decimal digits after the decimal
point. For instance, if the user converts 0.375 from decimal base to binary base, the result
will be: 0.01100 (because 0.375 = 0 * 0.5 + 1 * 0.25 + 1 * 0.125, where 0.5 corresponds to 
2^-1, 0.25 to 2^-2, and 0.125 to 2^-3, respectively). The result is then padded with 0 to 5
decimal places). 

In the base menu (where the user is prompted to enter source base and target base), the user
can exit the program by entering the "/exit" command. Otherwise, the user must use the "/back"
command to return to the base menu and then use "/exit" to quit.

This program does not handle exceptions. The program will end with an exception if the user
provides invalid input.

October 14th, 2023--description by E. Hsu (nahandove@gmail.com)
