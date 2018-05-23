# Regular Expression Cheatsheet

## Operator precedence (highest to loweset)
```
()            # parenthesis
*+?{}         # counters
/.../ ^$\b    # sequences and anchors
|             # disjunction
```

## Counters
```
*         # >=0 occurences of the previous char or expression
+         # >=1 occurences of the previous char or expression
?         # 0/1 occurence of the previous char or expression (optional indicator)
{n}       # n occurences of the previous char or expression
{n,m}     # from n to m occurences of the previous char or expression
{n,}      # at least n occurences of the previous char or expression
```

## Direct matching
```
/word/    # matches the first occurence of pattern "word"
```

## Wildcards
```
.           # single occurence of any character (wildcard character)
/pref.*suf/ # matches any sequence preceeded by "pref" and ended with "suf"
```

## Escaped characters
```
\*    # asterisk
\.    # period
\?    # question mark
\n    # newline
\t    # tab
\d    # any digit.            Shorthand for [0-9]
\D    # any non-digit.        Shorthand for [^0-9]
\s    # any space delimiter.  Shorthand for [_\r\t\n\f]
\S    # any non-whitespace.   Shorthand for [^\s]
```

## Disjunctive list
```
/[wW]ilson/     # matches "Wilson" or "wilson". Or equivalently /(w|W)ilson/
/[abc]/         # matches "a" or "b" or "c"
/[1234567890]/  # matches any digit. Shorthand: /[0-9]/
/[A-Z]/         # matches an upper-case character
/[a-z]/         # matches a lower-case character
```

## Negation
```
[^A-Z]          # do not match an upper-case character
[^Ss]           # matches neither "S" nor "s"
[^\.]           # do not match period
```
Note:
```
[e^]        # matches either "e" or "^"
a^b         # matches pattern "a^b"
```

## Kleene closure
```
/a*/      # matches zero or more "a"s
/aa*/     # matches one of more "a"s. Or equivalently /a+/
/[ab]*/   # matches patterns like "aaaa", "abab", "bbba" etc. 
```

## Anchors
```
^     # start of a line
$     # end of a line
\b    # word(any sequence of digits, underscores or letters) boundary
```
Usage:
```
/^The dog\.$/   # match a line containing only "The dog."
/\bthe\b/       # match "the" but not "other"
```
