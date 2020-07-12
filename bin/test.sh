#!/usr/bin/env bash

project_dir=$(dirname "$0")
cd "$(dirname "${project_dir}")" || exit

if command -v gradle &>/dev/null; then
    gradle test
else
    echo "Install gradle first!"
fi

exit
