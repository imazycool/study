import scala.jdk.CollectionConverters._

LOGGER.info("================== BQ DIAGNOSTICS START ==================")

LOGGER.info(s"Spark Version          : ${spark.version}")
LOGGER.info(s"Application Id         : ${spark.sparkContext.applicationId}")
LOGGER.info(s"Application Name       : ${spark.sparkContext.appName}")
LOGGER.info(s"Master                 : ${spark.sparkContext.master}")

val hadoopConf = spark.sparkContext.hadoopConfiguration

LOGGER.info(s"HadoopConf Null        : ${hadoopConf == null}")

// Spark Configuration
LOGGER.info("========== SparkConf ==========")
spark.sparkContext.getConf.getAll
  .sortBy(_._1)
  .foreach { case (k, v) =>
    LOGGER.info(s"[SPARK_CONF] $k = $v")
  }

// Hadoop Configuration (Google / GCS / BQ related only)
LOGGER.info("========== HadoopConf (Google) ==========")
hadoopConf.iterator().asScala
  .filter(e =>
    e.getKey.contains("google") ||
    e.getKey.contains("gcs") ||
    e.getKey.contains("gs.") ||
    e.getKey.contains("fs.gs") ||
    e.getKey.contains("bigquery"))
  .toSeq
  .sortBy(_.getKey)
  .foreach { e =>
    LOGGER.info(s"[HADOOP_CONF] ${e.getKey} = ${e.getValue}")
  }

// Important Spark SQL configs
val keys = Seq(
  "project",
  "parentProject",
  "dataset",
  "table",
  "query",
  "viewsEnabled",
  "materializationDataset",
  "materializationProject",
  "temporaryGcsBucket",
  "credentialsFile",
  "credentials",
  "parallelism",
  "maxParallelism"
)

LOGGER.info("========== BigQuery Config ==========")
keys.foreach { k =>
  val value =
    spark.conf.getOption(k)
      .orElse(Option(hadoopConf.get(k)))
      .getOrElse("<NOT SET>")

  LOGGER.info(s"[BQ_CONF] $k = $value")
}

LOGGER.info("================== BQ DIAGNOSTICS END ==================")