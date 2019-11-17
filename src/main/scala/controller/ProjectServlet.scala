package controller

import org.scalatra._
import service.ProjectService
import slick.jdbc.SQLiteProfile.api._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.json4s.jackson.JsonMethods._

// 一定要放在Servlet 外面，只要防止一些隐式转换
//Outside Servlet definition
case class Pro(name: String)

case class ID(id: BigDecimal)

class ProjectServlet(val db: Database) extends ScalatraServlet with FutureSupport with JacksonJsonSupport
{
    protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

    protected implicit lazy val jsonFormats: Formats = DefaultFormats

    ProjectService.db = db

    before()
    {
        contentType = formats("json")
    }

    // select
    get("/projects")
    {
        println("/projets")
        ProjectService.getProjects
    }

    //add
    post("/projects")
    {
        println("POST /projets")
        val pro = parsedBody.extract[Pro]
        println(pro, pro.name)
        println(parsedBody)
        ProjectService.getProjects
    }

    put("/projects")
    {
        val pro = parsedBody.extract[Pro]
        println(pro, pro.name)
        parse(request.body)
    }

    delete("/projects")
    {
        val i = parsedBody.extract[ID]
        println(i, i.id)
        parse(request.body)
    }
    // update

}

