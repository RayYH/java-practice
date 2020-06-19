#!/usr/bin/env bash

project_dir=$(dirname "$0")
cd "$(dirname "${project_dir}")" || exit

if command -v mvn &>/dev/null; then
    mvn test -e
else
    echo "Install maven first!"
fi

exit
