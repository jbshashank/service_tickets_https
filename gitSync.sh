#!/usr/bin/env bash
cd /home/douser1/git/service_tickets_https
changed=0
git remote update && git status -uno | grep -q 'Your branch is behind' && changed=1
if [ $changed = 1 ]; then
    git pull
    sudo /usr/local/bin/docker-compose down
    sudo /usr/local/bin/docker-compose up -d
    echo "Updated successfully";
else
    echo "Up-to-date"
fi
