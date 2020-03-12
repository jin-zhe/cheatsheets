# GIT Cheatsheet

## General
* Main remote repo is named `origin` by convention
* All file references can use wildcards e.g. `git add *.txt` stages all files ending with `.txt`
* Commits messages should be in present tense
* GIT commits for conflict merge conflicts don't need messages
* Everything in .git/info/exclude will be ignored
```sh
git help <command>  # gets documentation for the given command
```

## Configurations
```sh
git config --list                       # list all configurations
git config <config>                     # displays the set configuration. e.g. "git config user.email"
git config --global user.name "<name>"  # set user name (remove --global if only for current repo)
git config --global user.email <email>  # set user email (remove --global if only for current repo)
git config --global color.ui true       # turn on color ui in console
git config --global alias.co checkout   # give "checkout" command the alias of "co"
git config --global core.editor emacs   # user emacs for interactive commands
git config --global merge.tool opendiff # use opendiff GUI for merging conflicts (OS X only)
```

## Ignores
* Everything in `.git/info/exclude` will be ignored by GIT
* All paths stated in `.gitignore` are ignored by git, for instance:
```sh
# in .gitignore file
logs/   # ignore everything in logs dir
*.pyc   # ignore everything with *.pyc extension
*/*     # ignore everything within subfolders 
```

## Basics
```sh
git init                  # initializes local empty git repo in the current dir
git status                # shows current branch, which updates are staged and which are not
git mv <file1> <file2>    # rename file1 as file2 and stage the change
```

## Pointers
```sh
  HEAD                # pointer points to the most recent commit on current branch
  HEAD^               # first parent of head. HEAD^^ or HEAD~2 for second parent of head and so on
```

## Remote
```sh
git remote add <remote> <URL> # add remote respository using URL with given name
git remote -v                 # displays alias for all remote URLs
git remote rm <remote>        # remove remote of given name
git remote show <remote>      # show all remote branches for the given remote and if they are tracked or not
git remote prune <remote>     # cleanup deleted remote branches for remote
```

## Clone
```sh
git clone <URL> (folder name) # clones the remote repo into it's default foldername or custom name if foldername is specified
git clone <URL> --recursive   # clones the repo along with submodules and submodules of submodules etc.
```

## Fetch
```sh
git fetch <remote>            # fetches any changes from remote repo and put them in branch <remote>/master
git merge <remote>/master     # merges fetched changes into master branch of remote
```

## Pull
```sh
git pull <repo> <branch>      # automatically fetch and merge from remote branch to current branch
```

## Push
```sh
git push <remote> <branch>    # commit changes to the specified branch of remote repo. Creates remote branch if not already done so
git push <remote> <local-branch-name>:<remote-branch-name> # push changes from a local branch to remote branch of different name
git push -u origin master     # the -u tells Git to remember the parameters (name and branch), so that next time we can simply run "git push"
git push origin :a_branch     # deletes remote branch on origin. Note: local branch is still preserved
```

## Add
```sh
git add <list of files>   # stage all files (space separated) in list
git add .                 # stage all files that are either changed OR new and not ignored. i.e. does not stage rm actions
git add -u                # only stages changes to already tracked files. i.e. only stage change or rm actions. Does not stage new files
git add -A                # Adds all new or modified files. Same as git "add --all" which is equivalent to "git add .; git add -u"
```

## Remove
```sh
git rm <file>             # remove actual file from disk and also stage the removal
git rm --cached <file>    # remove tracking of file but maintain local copy
git rm -rf <folder>       # delete recursively and forcefully (no confirmations)
```

## Diff
```sh
git diff HEAD           # compares differences between current repo and HEAD (may be omitted). i.e. shows unstaged differences since last commit
git diff <ptr1> <ptr2>  # compares differences between 2 states indicated by the pointers (can also be branches) e.g. "git diff HEAD^ HEAD"
git diff --staged       # changes that has just been staged
```

## Commit
```sh
git commit -m '<msg>'         # commits staged files with message 'my message'
git commit -am '<msg>'        # skip staging step, adds the updated file (tracked only) and commit, Note: Doesn't stage newly added (untracked) files
git commit --amend -m "<msg>" # adds whatever is currently staged to the last commit
```

## Reset
```sh
git reset HEAD <file>     # unstage changes to file since last commit. Note: defaults to HEAD if it's not specified
git reset --soft HEAD^    # undo last commit and move everything from that commit back into staging. --soft indicates reset into staging. sets HEAD as HEAD^
git reset --hard HEAD^    # undo last commit and all changes. --hard indicates do not keep changes
```

## Blame
```sh
git blame <file> --date short # see all changes made to the file linewise in the format of "<SHA> (<username> <date> <line no>) <change>"
```

## Branch
```sh
git branch                # displays all branches (* indicates current branch)
git branch -r             # list all remote branches (use git checkout <branch> to set them up as local branch). Note: does not query the remotes to check for new branches. In order to see a new remote branch you first have to do a fetch or a pull
git branch <branch>       # creates a new branch from current branch called MyBranch
git branch -D <branch>    # delete branch
git branch -d <branch>    # delete branch (safer) if changes haven't been merged in, this command would fail as opposed to "-D"
git merge <branch>        # merges branch with current branch
```

## Checkout
```sh
git checkout -b <branch>  # creates a new branch and switch to it
git checkout <branch>     # switches to an existing branch
git checkout master       # switch to master branch
git checkout --force      # restore/undo change (prior to commit)
git checkout -b <branch>  # creates or resets branch (if existent) and then switch to it
git checkout -- <file>    # discard all changes and reverts file to its state in the last commit
```

## Rebase
### Rebasing a branch with master
```sh
git checkout my_branch # switches to my_branch
git rebase master      # rebase current branch with master. i.e. run master commits first then branch commits 
git checkout master    # switches to master
git merge my_branch
```
### Rebasing master with remote master
```sh
git checkout master    # switches to master branch
git fetch              # fetches from remote and puts new commits in origin/master branch
git rebase             # brings local master commits to temporary branch, runs all origin/master on local master branch, then all commits on temporary branch one at a time
git rebase --continue  # resolves conflicts one after another
```

## Tagging
```sh
git tags                              # list all tags
git tag -a v0.0.3 -m "Version 0.0.3"  # adding a tag with description
git checkout <tag>                    # checkout to a given tag
git push --tags                       # push tags. Need to be stated explicitly else tags will just remain locally
```

## Submodules
Add a submodule of a specific branch
```sh
git submodule add --branch extension-framework https://github.com/leongwaikay/OMRChecker.git
```

## Log
Look at commit logs i.e. all the changes committed so far via:
```sh
git log
```

### Formatting
```sh
git log --pretty=oneline                      # prints line "<SHA> <commit msg>" for each commit
git log --pretty=format: "%h %ad- %s [%an]"   # custom format using placeholders. %ad:author date, %an:author name, %h:sha hash, %s:subject, %d:ref names
git log --oneline -p                          # -p for patch. shows every modifications linewise for each commit
git log --oneline --stat                      # how many insertions and deletions for each file included in each commit
git log --oneline --graph                     # visual representation
```

### Time filters
```sh
git log --until=1.minute.ago  
git log --since=1.day.ago
git log --since=2000-01-01 --until=2012-12-21
```
