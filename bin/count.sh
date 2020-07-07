#!/usr/bin/env bash

project_dir=$(dirname "$0")
cd "$(dirname "${project_dir}")" || exit

find . -name '*.java' -print0 | xargs -0 wc -l | sort -n

exit
