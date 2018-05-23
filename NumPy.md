# Numpy Cheatsheet
Cheatsheet for Python's [NumPy library](http://www.numpy.org/)

## General
```py
import numpy as np
```
```py
arr.size()                      # returns total number of items
np.nditer(arr)                 # returns list of all items in numpy array arr
```
Operations on arrays are performed in an element-wise manner:
```py
a * 0.5 # multiplies each element with 0.5
a + b   # adds each item in array a its corresponding item in b
a * b
```

## Generations
```py
np.arange(3,7)               # generates [3,4,5,6]
np.arange(4).reshape((2,2))  # creates [[0,1],[2,3]]
```

## 1D array
```py
a = np.array([1,2,3])
```
## 2D array
```py
a = np.array([[1,2,3], [4,5,6]])
a.shape           # prints (2, 3)
a[1,2]            # get an element at row 1 col 2
a[1,:]            # get row 1
a[:,2]            # get col 2
b = np.matrix(a)  # cast a into a matrix
np.transpose(a)   # transpose 2D array
```

## Special arrays
```py
np.empty([2, 3])    # 2 by 3 array with arbitrary random values
np.eye(2, 3)        # matrix of given shape where diagonal entires are 1 and everything else 0
np.identity(3)      # 3 by 3 identity matrix
np.ones([2, 3])     # array of given shape filled with ones
np.zeros([2, 3])    # array of given shape filled with zeros
np.random.rand(2,3) # array of given shape filled with random values
```

## Matrices
```py
a = np.martix([[1,2,3], [4,5,6]])
a * b   # only valid if b has as many columns as the row of a, else error will be thrown
```

## Linear algebra
```py
import numpy.linalg as la
al.inv(A)                   # inverse matrix A
la.solve(A, b)              # solve for A x = b
a, e, r, s = la.lstsq(M, b) # least squares for M a = b. a: least-square solution, e: residue or error, r: rank of a, s: singular values of a
```
