package utils

import scala.collection.mutable.ArrayBuffer

object Store
{

    // 一定要放在Servlet 外面，只要防止一些隐式转换
    //Outside Servlet definition
    case class ProjectVar(projId: Int, projName: String, projDesc: String)

    case class ModuleVar(modId: Int, projId: Int, modName: String, modDesc: String)

    case class SimpleApi(apiId: Int, apiName: String, apiType: String)

    case class ModApiList(modId: Int, modName: String, apiList: ArrayBuffer[SimpleApi])

    case class ID(id: Int)

    case class ApiVar(apiId: Int, modId: Int, apiName: String, apiType: String, success: String, failure: String)

    case class ShortApi(apiId: Int, apiName: String, apiType: String)

    case class JsonString(apiId: Int, typename: String, content: String)

    case class ApiInfo(modName: String, apiName: String, apiType: String, params: String, success: Option[String], failure: Option[String])

    case class MockData(params: String, response: String)

    case class Conf(projId: Int, conf: String)

    case class ProjectApi(projId: Int, apiId: Int)

    case class RunApiJson(original: String, real: String)

    case class DownloadType(typename: String)

    case class RequestJson(name:String,value:String,desc:String)
}
