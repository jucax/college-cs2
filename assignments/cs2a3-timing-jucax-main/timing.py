import matplotlib.pyplot as plt
import numpy as np
 
with open('data.txt') as f:
    lines = (line for line in f if not line.startswith('#'))
    X,_,_,_,_,_,_,_,_,_,_,A,_,_,_,_,_,_,_,_,_,_,B = np.loadtxt(lines, unpack=True)
 
plt.plot(X, A, label="Loop A")
plt.plot(X, B, label="Loop B")
plt.legend()
plt.title('Comparison of Loop A and Loop B')
plt.xlabel('N')
plt.ylabel('Average Nanoseconds')
#plt.show()
plt.savefig('timing.png')

print('Execution complete. Look for "timing.png" in the project directory.')