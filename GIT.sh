git config --global alias.co checkout

git init						# creates repo
git status						# shows current branch, which updates are staged and which are not
git add <file>					# stage a file i.e. tracks a file
git add .						# stage all files (have to be done with every single file modification)
git rm -rf <folder>				# delete recursively and forcefully (no confirmations)
git mv README README.markdown	# rename

git commit -m 'my change'		# commits staged files with message 'my message'
git commit -am 'my change'		# automatically adds the newly updated file and commit, i.e. skip staging step. Only worked for tracked files
git log							# look at commit logs

git branch						# displays all branches (* indicates current branch)
git branch	<branch>			# creates a new branch from current branch called MyBranch
git branch -D <branch>			# delete branch
git branch -d <branch>			# delete branch (safer) if changes haven't been merged in, this command would fail as opposed to "-D"
git checkout <branch>			# switches to MyBranch
git checkout master				# switch to master branch
git checkout --force			# restore/undo change (prior to commit)
git reset --hard HEAD			# restore/undo change (prior to commit)
git checkout -b <branch>		# creates or resets branch (if existent) and then switch to it
git merge <branch>				# merges branch with current branch

git touch README.md				# creates a new file called README.md
git clone <URL>					# clones git repository form given URL
git remote -v					# shows alias for git URLs "origin" by default
git fetch origin				# gets any changes since last cloned or fetched (requires manual merge with working files)
git pull <repo> <branch>		# automatically fetch and merge from remote branch to current branch
git push origin master			# commit changes to remote repo origin's master branch
git remote add origin <URL>		# add remote respository using URL with alias 'origin' 