'''
Mean, Median, and Mode

In Machine Learning (and in mathematics) there are often three values that interests us:

speed = [99,86,87,88,111,86,103,87,94,78,77,85,86]

Mean        - The average value             - (99+86+87+88+111+86+103+87+94+78+77+85+86) / 13 = 89.77
Median      - The mid point value           - 77, 78, 85, 86, 86, 86, 87, 87, 88, 94, 99, 103, 111 = 87
Mode        - The most common value         - 99, 86, 87, 88, 111, 86, 103, 87, 94, 78, 77, 85, 86 = 86
'''



'''
Standard deviation is a number that describes how spread out the values are.

A low standard deviation means that most of the numbers are close to the mean (average) value.

A high standard deviation means that the values are spread out over a wider range.

Standard Deviation is often represented by the symbol Sigma: σ

example 1

speed = [86,87,88,86,87,85,86]
standard deviation is: 0.9 meaning that most of the values are within the range of 0.9 from the mean value, which is 86.4 

example 2

speed = [32,111,138,28,59,77,97]
The standard deviation is: 37.85 Meaning that most of the values are within the range of 37.85 from the mean value, which is 77.4
'''

# Use the NumPy std() method to find the standard deviation:
import numpy
speed = [86,87,88,86,87,85,86]
x = numpy.std(speed)
print(x) # 0.9035079029052513

import numpy
speed = [32,111,138,28,59,77,97]
x = numpy.std(speed)
print(x) # 37.84501153334721



'''
Variance is another number that indicates how spread out the values are.

if you take the square root of the variance, you get the standard deviation.

Variance is often represented by the symbol Sigma Squared: σ2

example 1

Find the mean: (32+111+138+28+59+77+97) / 7 = 77.4

For each value: find the difference from the mean and find the square value:
32  - 77.4 = -45.4 = (-45.4)2 = 2061.16
111 - 77.4 =  33.6 = (33.6)2  = 1128.96
138 - 77.4 =  60.6 = (60.6)2  = 3672.36
28  - 77.4 = -49.4 = (-49.4)2 = 2440.36
59  - 77.4 = -18.4 = (-18.4)2 =  338.56
77  - 77.4 = - 0.4 = (- 0.4)2 =    0.16
97  - 77.4 =  19.6 = (19.6)2  =  384.16

The variance is the average number of these squared differences:
(2061.16+1128.96+3672.36+2440.36+338.56+0.16+384.16) / 7 = 1432.2
'''

# Use the NumPy var() method to find the variance:
import numpy
speed = [86,87,88,86,87,85,86]
x = numpy.var(speed)
print(x) # 0.8163265306122449 -> .81 is square root of .9

import numpy
speed = [32,111,138,28,59,77,97]
x = numpy.var(speed)
print(x) # 1432.2448979591834 -> 1432.24 is square root of 37.8