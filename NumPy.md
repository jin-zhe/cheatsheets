# Numpy Cheatsheet
Cheatsheet for Python's [NumPy library](http://www.numpy.org/)

## General
```py
import numpy as np
```
```py
arr.size()                     # returns total number of items
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
np.random.randn(1000)         # generates array of 1000 random numbers 
np.arange(3,7)                # generates [3,4,5,6]
np.arange(4).reshape((2,2))   # creates [[0,1],[2,3]]
```

## Arrays
### 1D array
```py
a = np.array([1,2,3])
```
### 2D array
```py
a = np.array([[1,2,3], [4,5,6]])
a.shape           #=> (2, 3)
a[1,2]            #=> 6 # get an element at row 1 col 2
a[1,:]            #=> array([4, 5, 6]) # get row 1
a[:,2]            #=> array([3, 6])    # get col 2
```

### Special arrays
```py
np.empty([2, 3])    # 2 by 3 array with arbitrary random values
np.eye(2, 3)        # matrix of given shape where diagonal entires are 1 and everything else 0
np.identity(3)      # 3 by 3 identity matrix
np.ones([2, 3])     # array of given shape filled with ones
np.zeros([2, 3])    # array of given shape filled with zeros
np.random.rand(2,3) # array of given shape filled with random values
```

### Common operations
```py
a = np.array([[1, 2], [3, 4]])

# Mean
# Note: use dtype=np.float64 (double precision) as np.float32 can be inaccurate
np.mean(a)          #=> 2.5 # Takes mean of all values
np.mean(a, axis=0)  #=> array([ 2.,  3.])   # Mean along axis 0: [1, 3], [2, 4]
np.mean(a, axis=1)  #=> array([ 1.5,  3.5]) # Mean along axis 1: [1, 2], [3, 4]
```

## Matrices
### Arrays vs Matrices
Compare and contrast against 2D array
```py
a = np.matrix([[1,2,3], [4,5,6]])
a[1,2]          #=> 6 # get an element at row 1 col 2
a[1,:]          #=> matrix([[4, 5, 6]]) # get row 1
a[:,2]          #=> matrix([[3], [6]])  # get col 2
a * b           # only valid if b has as many columns as the row of a, else error will be thrown
```
| Operation | Arrays                          | Matrices                  | Similar? |
|-----------|:--------------------------------|:--------------------------|----------|
| `+`       | element-wise addition           | element-wise addition     | yes      |
| `-`       | element-wise subtraction        | element-wise subtraction  | yes      |
| `*`       | **element-wise multiplication** | **matrix multiplication** | **no**   |
| `/`       | element-wise division           | element-wise division     | yes      |
| `[i,:]`   | returns a row                   | returns a row             | yes      |
| `[:,j]`   | **returns a row**               | **returns a column**      | **no**   |

### Common Operations
```py
b = np.matrix(arr)  # cast numpy array `arr` into np matrix
np.matmul(a,b)      # same as a * b
np.transpose(a)     # transpose 2D array
```

## Linear algebra
```py
import numpy.linalg as la
al.inv(A)                   # inverse matrix A
la.solve(A, b)              # solve for A x = b
a, e, r, s = la.lstsq(M, b) # least squares for M a = b. a: least-square solution, e: residue or error, r: rank of a, s: singular values of a
norm = la.norm(A, ord=None) # return one of eight different matrix norms specified by `ord` argument. Defaults to Frobenius
```

## I/O
Reading
```py
with open("in.txt") as f:
  data = np.genfromtxt(f, delimiter=",")
```
Writing
```py
with open("out.txt", "w") as f:
  np.savetxt(f, result, "%f", ",")
```

## Statistics
From https://docs.scipy.org/doc/numpy/reference/routines.statistics.html
### Order statistics
```py
amin(a[, axis, out, keepdims])      # Return the minimum of an array or minimum along an axis.
amax(a[, axis, out, keepdims])      # Return the maximum of an array or maximum along an axis.
nanmin(a[, axis, out, keepdims])    # Return minimum of an array or minimum along an axis, ignoring any NaNs.
nanmax(a[, axis, out, keepdims])    # Return the maximum of an array or maximum along an axis, ignoring any NaNs.
ptp(a[, axis, out])                 # Range of values (maximum - minimum) along an axis.
percentile(a, q[, axis, out, …])    # Compute the qth percentile of the data along the specified axis.
nanpercentile(a, q[, axis, out, …]) # Compute the qth percentile of the data along the specified axis, while ignoring nan values.
```

### Averages and variances
```py
median(a[, axis, out, overwrite_input, keepdims])   # Compute the median along the specified axis.
average(a[, axis, weights, returned])               # Compute the weighted average along the specified axis.
mean(a[, axis, dtype, out, keepdims])               # Compute the arithmetic mean along the specified axis.
std(a[, axis, dtype, out, ddof, keepdims])          # Compute the standard deviation along the specified axis.
var(a[, axis, dtype, out, ddof, keepdims])          # Compute the variance along the specified axis.
nanmedian(a[, axis, out, overwrite_input, …])       # Compute the median along the specified axis, while ignoring NaNs.
nanmean(a[, axis, dtype, out, keepdims])            # Compute the arithmetic mean along the specified axis, ignoring NaNs.
nanstd(a[, axis, dtype, out, ddof, keepdims])       # Compute the standard deviation along the specified axis, while ignoring NaNs.
nanvar(a[, axis, dtype, out, ddof, keepdims])       # Compute the variance along the specified axis, while ignoring NaNs.
```

### Correlating
```py
corrcoef(x[, y, rowvar, bias, ddof])          # Return Pearson product-moment correlation coefficients.
correlate(a, v[, mode])                       # Cross-correlation of two 1-dimensional sequences.
cov(m[, y, rowvar, bias, ddof, fweights, …])  # Estimate a covariance matrix, given data and weights.
```

### Histograms
```py
histogram(a[, bins, range, normed, weights, …])   # Compute the histogram of a set of data.
histogram2d(x, y[, bins, range, normed, weights]) # Compute the bi-dimensional histogram of two data samples.
histogramdd(sample[, bins, range, normed, …])     # Compute the multidimensional histogram of some data.
bincount(x[, weights, minlength])                 # Count number of occurrences of each value in array of non-negative ints.
digitize(x, bins[, right])                        # Return the indices of the bins to which each value in input array belongs.
```
