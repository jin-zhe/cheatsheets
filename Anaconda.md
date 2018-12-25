# Anaconda cheatsheet

## General
### Update
```sh
conda update conda
```
### Clean installation cache
```sh
conda clean --all
```

### Environment variables
See [managing environments](https://conda.io/docs/user-guide/tasks/manage-environments.html#macos-and-linux)

## Environments
### List environments
```sh
conda info --envs
```
### Create
```sh
conda create -n myenv python=2.7 anaconda
```
* `-n`, `--name` flag indicates the name for the environemt we wish to create
* `python=2.7` indicates our Python version for this environment
* The trailing `anaconda` in the end indicates that we wish to initialize our environment with the ‘anaconda’ meta-package. This is entirely optional!
### Activate
```sh
conda activate myenv
```
### Deactivate
```sh
conda deactivate myenv
```
### Remove environment
```sh
conda remove --name myenv --all
````
or
```sh
conda env remove --name myenv
```
### Clone
```sh
source deactivate # be sure to exit virtual environment first!
conda create --name new_name --clone old_name
conda remove --name old_name --all
```

## Packages

### List installed packages
```sh
conda list
```
Lists installed packages in current environment
### Install package
```sh
# conda install --channel <channel-name> --name <environment-name> <package-name>
conda install cmake -y
```

* The -`y`, `--yes` flag simply automates the ‘yes’ approval from you to install the packages
* If you wish to install in another virtual environment, simply use the `-n`, `--name` flag
* `-c`, `--channel` indicates additional channel to search for packages if you do not wish to install from default packages
### Uninstall package
```sh
conda uninstall some_package
```
