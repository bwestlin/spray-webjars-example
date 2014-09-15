import akka.actor._
import akka.io.Tcp
import spray.can.Http
import spray.routing.HttpServiceActor

object HttpServer {
  def props() = Props(classOf[HttpServer])
}

class HttpServer extends HttpServiceActor with ActorLogging {

  def receive = connect orElse routing

  def connect: Receive = {
    case Http.Connected(remoteAddress, localAddress) =>
      sender() ! Http.Register(self)
  }

  def routing: Receive = {
    runRoute {
      getFromResourceDirectory("webapp") ~
      path("") {
        getFromResource("webapp/index.html")
      } ~
      pathPrefix("webjars") {
        get {
          getFromResourceDirectory("META-INF/resources/webjars")
        }
      }
    }
  }
}
