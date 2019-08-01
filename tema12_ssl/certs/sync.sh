#!/bin/bash
while true
do
  rsync -av * /tmp
  sleep 2
done
