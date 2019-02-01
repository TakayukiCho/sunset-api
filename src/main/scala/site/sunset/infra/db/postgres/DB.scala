package site.sunset.infra.db.postgres

import scalikejdbc.config.DBs
import scalikejdbc.{GlobalSettings, LoggingSQLAndTimeSettings}

object DB {
  GlobalSettings.loggingSQLAndTime = LoggingSQLAndTimeSettings(singleLineMode = true, logLevel = 'debug)
  DBs.setupAll()
}
