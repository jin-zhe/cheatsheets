```py
s = '''' Good muffins cost $3.88\nin New York.  Please buy me\n    ... two of them.\n\nThanks. '''
[word_tokenize(t) for t in sent_tokenize(s)]  #=> [['Good', 'muffins', 'cost', '$', '3.88', 'in', 'New', 'York', '.'], ['Please', 'buy', 'me', 'two', 'of', 'them', '.'], ['Thanks', '.']]
```
