# WHAT'S THIS
This application privide a function to record tweets containg keywords or hashtag to file with twitter stream.

# USAGE
## BUILD
```sh
$ sbt
> assembly
> exit
```

## usage
If you track "#MT2" and "#nicovideo"
```sh
$ java -jar target/tweet_recorder-assembly-1.0.jar your_twitter_id password \#MT2 \#nicovideo
```
Output filneme is "tweet_recorder.csv".
