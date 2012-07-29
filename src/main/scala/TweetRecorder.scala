import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.FilterQuery
import twitter4j.StatusListener
import twitter4j.Status
import twitter4j.StatusDeletionNotice
import java.io.PrintWriter
import java.io.FileWriter
object TweetRecorder { 
  def main(args: Array[String]) = {
    val conf = new ConfigurationBuilder().setUser(args(0)).setPassword(args(1)).build
    val twitterStream = new TwitterStreamFactory(conf).getInstance()
    twitterStream.addListener(new Listener)
    twitterStream.filter(new FilterQuery().track(args.slice(2, args.length)))
  }
  class Listener extends StatusListener {
    override def onStatus(status: Status) = {
      val tweet = status.getCreatedAt().toLocaleString() +
      	"," + status.getUser().getScreenName() + 
      	"," + status.getText() 
      val writer = new PrintWriter(new FileWriter("tweet_recoder.csv", true))
      writer.println(tweet)
      writer.close
      println(tweet)
    } 
    override def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) = {}
    override def onTrackLimitationNotice(numberOfLimitedStatuses: Int) = {}
    override def onException(ex: Exception) = {}
    override def onScrubGeo(userId: Long, upToStatusId: Long) = {}
  }
}