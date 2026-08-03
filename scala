println(s"project = ${spark.conf.getOption("project")}")
println(s"parentProject = ${spark.conf.getOption("parentProject")}")
println(s"temporaryGcsBucket = ${spark.conf.getOption("temporaryGcsBucket")}")
println(s"viewsEnabled = ${spark.conf.getOption("viewsEnabled")}")
println(s"materializationDataset = ${spark.conf.getOption("materializationDataset")}")
println(s"materializationProject = ${spark.conf.getOption("materializationProject")}")


LOGGER.info(s"keysToPrint = $keysToPrint")
LOGGER.info(s"keysToPrint size = ${keysToPrint.size}")

println(s"keysToPrint = $keysToPrint")
println(s"keysToPrint size = ${keysToPrint.size}")