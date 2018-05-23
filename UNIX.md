# UNIX Cheatsheet
Some useful UNIX commands with notes adapted from @girishadurrel

## Directory symbols
* `.` denotes current working directory
* `..` denotes parent directory

## Common commands
### `pwd`
Command to print the *current working directory*
```sh
$ pwd
```
### `ls`
Command to *list* the files in the directory

To get just the file names in directory:
```sh
$ ls
```
To get file names plus more information about the files, use the `-l` (long list) flag:
```sh
$ ls -l 
```
### `cd`
Command to *change directory*
```sh
$ cd some_dir_path
```
### 'cp'
Command to *copy* files or directories

To copy files:
```sh
$ cp source_file_path target_file_path
```
To copy directories, use the `-r` (recursive) flag:
```sh
$ cp source_dir_path target_dir_path
```
### `man`
Command to display the *manual*. Some examples:
```sh
$ man cp  # displays all the information about the cp command and the options that can be used
$ man cd  # displays all the information about the cd command and the options that can be used
$ man man # displays all the information about the man command and the options that can be used
```
### `more`
Command for *more*. If you want to quickly see what a text file contain you can just type `more file-name` and it will list down the contents of the file. if the file is too large it will show only a portion of the file. by typing the enter button you can traverse the file
```sh
$ more file-name
```

## Scripting
### Shebang
From [Wikipedia](https://en.wikipedia.org/wiki/Shebang_(Unix)):
> In computing, a shebang is the character sequence consisting of the characters number sign and exclamation mark (`#!`) at the beginning of a script. It is also called sha-bang, hashbang, pound-bang, or hash-pling.
>
> In Unix-like operating systems, when a text file with a shebang is used as if it is an executable, the program loader parses the rest of the file's initial line as an interpreter directive; the specified interpreter program is executed, passing to it as an argument the path that was initially used when attempting to run the script, so that the program may use the file as input data. For example, if a script is named with the path path/to/script, and it starts with the following line, `#!/bin/sh`, then the program loader is instructed to run the program using `/bin/sh`, passing `path/to/script` as the first argument.
