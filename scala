import scala.jdk.CollectionConverters._

hadoopConf.iterator().asScala.foreach { e =>
  LOGGER.info(s"[HADOOP_CONF] ${e.getKey} = ${e.getValue}")
}


val hadoopConf = spark.sparkContext.hadoopConfiguration

LOGGER.info(s"[BQ_DIAG] hadoopConf null = ${hadoopConf == null}")
LOGGER.info(s"[BQ_DIAG] fs.defaultFS = ${hadoopConf.get("fs.defaultFS")}")
LOGGER.info(s"[BQ_DIAG] google.cloud.project.id = ${hadoopConf.get("google.cloud.project.


spark.sparkContext.getConf.getAll.foreach {
  case (k, v) =>
    LOGGER.info(s"[SPARK_CONF] $k = $v")
}


import scala.jdk.CollectionConverters._

hadoopConf.iterator().asScala.foreach { e =>
  LOGGER.info(s"[HADOOP_CONF] ${e.getKey} = ${e.getValue}")
}






