#!/usr/bin/env bash

project_dir=$(dirname "$0")
cd "$(dirname "${project_dir}")" || exit

# pull first
git pull origin master

# add
git add -A

# commit message
if [[ "$1" ]]; then
    git commit -a -m "$1"
else
    git commit -a -m "auto commit"
fi

# push
git push -u origin master

exit
