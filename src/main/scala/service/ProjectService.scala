package service

import model.Tables.{Project, ProjectRow}
import slick.jdbc.SQLiteProfile.api._
import utils.Store.{ID, ProjectVar}
import utils.result._
import utils.handle._

object ProjectService
{
    var db: Database = _

    protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

    def getProjectList = db.run(Project.result).map { res => success(res, "query successfully") }

    def addOrEditProject(pro: ProjectVar) =
    {
        // add
        if (pro.projId == -1) {
            val insert = Project += ProjectRow(-1, pro.projName, Some(pro.projDesc), nowToString, nowToString)
            val maxID = Project.map(_.projId).max
            val getProject = Project.filter(_.projId === maxID).result
            db.run((insert >> getProject).transactionally).map { res => success(res.headOption, "add successfully") }
        }
        // update
        else {
            val updateProject = Project.filter(_.projId === pro.projId).map(p => (p.projName, p.projDesc,p.editedTime)).update((pro.projName, Some(pro.projDesc),nowToString))
            val getProject = Project.filter(_.projId === pro.projId).result
            db.run((updateProject >> getProject).transactionally).map(res => success(res.headOption, "update successfully"))
        }
    }

    def deleteProject(i: ID) =
    {
        val deleteProject = Project.filter(_.projId === i.id).delete
        db.run(deleteProject).map(_ => success("OK", "delete Successfully"))
    }
}
