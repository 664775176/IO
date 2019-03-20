package com.zhangchao.juc

import java.util.concurrent.atomic.AtomicLong

import javax.annotation.Resource
import javax.sql.DataSource
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional

/**
  *
  * Desc: IDServiceImpl 请使用同步service
  * author: maple
  * Date: 2018-01-08 9:50
  *
  */
@Transactional
class IDServiceImpl  {
  /** 日志 */
  val logger = LoggerFactory.getLogger(getClass)

  case class BizItem(bizTag: String, nextId: AtomicLong, maxId: AtomicLong)
  case class GenIDRequest(

                           /**
                             *
                             **/

                           bizTag : String, /**
                             *
                             **/

                           step : Long
                         )
  case class IDInfo(

                     /**
                       *
                       **/

                     bizTag : String, /**
                       *
                       **/

                     maxId : Long, /**
                       *
                       **/

                     step : Long, /**
                       *
                       **/

                     updatedAt : Long
                   )

  val caches = collection.mutable.Map[String, BizItem]()

  @Resource(name = "tx_dataSource")
  var dataSource: DataSource = _

  /**
    * 请求业务逻辑
    *
    * @param bizItem 业务封装类
    * @param request
    * @return
    */
  private def genId(bizItem: BizItem, request: GenIDRequest): Long = {
    /**
      * 当余下的id不足以提供step时，丢弃掉余下的所有可用Id
      *
      */
    if (bizItem.maxId.get - bizItem.nextId.get < request.step) {
      doFetchMaxId(bizItem)
      assert(bizItem.nextId.get + request.step < bizItem.maxId.get)
    }
    //每次拿step个
    logger.info(s"on idService bizTag: ${bizItem.bizTag}  maxId: ${bizItem.maxId}  nextId: ${bizItem.nextId}")
    bizItem.nextId.getAndAdd(request.step)

  }

  def precheck(request: GenIDRequest) = {
    assert(request.step >= 1, "每次批量取号数step 必须大于等于1")
    assert(request.step < 10002, "每次批量取号数step 不得大于等于最大步长10002")
  }

  /**
    *
    * GenIDRequest
    * bizTag: 业务tag
    * step: 取号步长(一次取多少，大多数为1)
    * 这里使用锁会不会影响效率？
    * 其实完全可以将设置缓存放在for  update之内，这样就不需要锁住整个方法
    **/
  def genId(request: GenIDRequest): Long = this.synchronized {
    precheck(request)

    caches.get(request.bizTag) match {
      case Some(bizItem) =>
        genId(bizItem, request)
      case None =>
        val item = doFetchMaxId(BizItem(request.bizTag, new AtomicLong(0), new AtomicLong(0)))
        caches += (request.bizTag -> item)
        item.nextId.getAndAdd(request.step)
    }

  }

  /**
    * if maxId is not enough , doFetch to get more maxId
    *
    * @param bizItem
    */
  private def doFetchMaxId(bizItem: BizItem): BizItem = {
//    val res = dataSource.row[IDInfo](sql"""select * from id_info where biz_tag=${bizItem.bizTag} FOR UPDATE """)
//    val idInfo = res match {
//      case Some(x) => x
//      case None => throw new Exception( s"找不到此业务:${bizItem.bizTag}")
//    }
//    assert(idInfo.step >= 1024, s"step字段值至少要为1024或者其整数倍,当前 bizTag ${idInfo.bizTag} ,step ${idInfo.step}")
//    val newMaxId = idInfo.maxId + idInfo.step
//
//    val execute = dataSource.executeUpdate(sql"update id_info set max_id=${newMaxId} where biz_tag=${bizItem.bizTag}")
//    assert(execute == 1, "update maxId failed")

//    bizItem.nextId.set(idInfo.maxId)
//    bizItem.maxId.set(newMaxId)
//    logger.info(s"idService doFetchMaxId :: current bizTag [${bizItem.bizTag}] :: next [${bizItem.nextId.get} - ${bizItem.maxId.get}]")

    bizItem
  }

}
