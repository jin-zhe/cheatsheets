# PyTorch Cheatsheet
Cheatsheet for PyTorch.
Referenced from:  
* [Official PyTorch tutorial](https://pytorch.org/tutorials/beginner/blitz/tensor_tutorial.htm)
* [Official PyTorch documentation](https://pytorch.org/docs/stable/torch.html)

## Importing
```py
import torch
```

## Tensors
### Default type
```
torch.get_default_dtype()               # initial default for floating point is torch.float32
#=> torch.float32
torch.set_default_dtype(torch.float64)  # default is now changed to torch.float64

# NOTE: Setting default tensor type affects default dtype
torch.set_default_tensor_type(torch.FloatTensor)  # setting tensor type to dtype for torch.FloatTensor (torch.float32)
torch.get_default_dtype()                         # changed back to torch.float32 
#=> torch.float32
```
### General
```py
# Size
x.size()  # Returns a tuple supporting all Python tuple operations. e.g. #=> torch.Size([5, 3])

# Values
torch.randn(1).item() # Converting one-element tensor to Python number. e.g. tensor([1]) => 1

# Assertion
torch.is_tensor(torch.empty(5)) #=> True
```

### Construction
```py
# Basic construction
torch.empty(5, 3)                   # Returns 5x3 matrix, uninitialized
torch.zeros(5, 3, dtype=torch.long) # Returns 5x3 matrix filled zeros and of dtype long
torch.ones(5, 3)                    # Returns 5x3 matrix filled ones
torch.rand(5, 3)                    # Returns 5x3 matrix with randomly initilialized values
torch.tensor([5.5, 3])              # Returns a tensor directly from argument data

# Constructing based on existing tensor x
x.new_ones(5, 3, dtype=torch.double)   # Note: new_* methods take in sizes
torch.randn_like(x, dtype=torch.float) # use tnsr shape, override dtype
```

### Operation
Note:
* Any operation that mutates a tensor **in-place** is post-fixed with an `_`. For example: `x.copy_(y)`, `x.t_()`, will change `x`.
#### Addition
```py
# Basic
x + y           # Syntax 1
torch.add(x, y) # Syntax 2

# Providing an output tensor as argument
result = torch.empty(5, 3)
torch.add(x, y, out=result)

# In-place
y.add_(x)
```

### Reshape
```py
x = torch.randn(4, 4).view(16)      # Flattens out the tensor to 1D
y = torch.randn(4, 4).view(-1, 8)   # the size -1 is inferred from other dimensions
```

### NumPy Bridge
Torch Tensor => NumPy Array:
```py
a = torch.ones(5) # tensor([ 1.,  1.,  1.,  1.,  1.])
b = a.numpy()     # [1. 1. 1. 1. 1.]
a.add_(1)         # NOTE: This affects BOTH `a` and `b`!
print(a)          #=> tensor([ 2.,  2.,  2.,  2.,  2.])
print(b)          #=> [2. 2. 2. 2. 2.]
```
NumPy Array => Torch Tensor:
```py
import numpy as np
a = np.ones(5)          # [1. 1. 1. 1. 1.]
b = torch.from_numpy(a) # tensor([ 1.,  1.,  1.,  1.,  1.], dtype=torch.float64))
np.add(a, 1, out=a)     # NOTE: This affects BOTH `a` and `b`!
print(a)                # [2. 2. 2. 2. 2.]
print(b)                # tensor([ 2.,  2.,  2.,  2.,  2.], dtype=torch.float64))
```

### CUDA tensors
`torch.device` objects to move tensors in and out of GPU
```py
# let us run this cell only if CUDA is available
if torch.cuda.is_available():
    device = torch.device("cuda")          # a CUDA device object
    y = torch.ones_like(x, device=device)  # directly create a tensor on GPU
    x = x.to(device)                       # or just use strings ``.to("cuda")``
    z = x + y
    print(z)
    print(z.to("cpu", torch.double))       # ``.to`` can also change dtype together!
```
