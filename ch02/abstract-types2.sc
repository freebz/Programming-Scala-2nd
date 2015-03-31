import java.io._

abstract class BulkReader[In] {
  val source: In
  def read: String	// Read source and return a String
}

class StringBulkReader(val source: String) extends BulkReader[String] {
  def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader[File] {
  def read: String = {
    val in = new BufferedInputStream(new FileInputStream(source))
    val numBytes = in.available()
    val bytes = new Array[Byte](numBytes)
    in.read(bytes, 0, numBytes)
    new String(bytes)
  }
}

println(new StringBulkReader("Hello Scala!").read)
// Assumes the current directory is src/main/scala:

println(new FileBulkReader(
  new File("abstract-types.sc")).read)
