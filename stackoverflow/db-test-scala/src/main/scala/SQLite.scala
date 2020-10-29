import slick.jdbc.StaticQuery

class SQLite(name: String) {
  import Database.threadLocalSession

  val database = Database.forURL(
    "jdbc:sqlite:%s.db" format name,
    driver = "org.sqlite.JDBC")

  implicit class DatabaseOps(database: Database) {
    def apply(sql: String) {
      database withSession {
        StaticQuery.updateNA(sql).execute
      }
    }

}
