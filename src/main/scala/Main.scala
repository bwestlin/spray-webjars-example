import akka.actor.ActorSystem
import akka.io.IO
import spray.can.Http

object Main extends App {

  def doMain() {
    implicit val system = ActorSystem()

    val server = system.actorOf(HttpServer.props(), "http")

    IO(Http) ! Http.Bind(server, "127.0.0.1", 8080)
  }

  doMain()
}
