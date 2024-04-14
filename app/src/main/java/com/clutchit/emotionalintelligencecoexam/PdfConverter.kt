import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL

fun convertPdfToImages(pdfUrl: String, outputDir: File) {
    val pdfFileName = pdfUrl.substringAfterLast("/")
    val outputFile = File(outputDir, pdfFileName)

    try {
        // Download PDF file
        downloadFile(pdfUrl, outputFile)

        // Open PDF file
        val fileDescriptor = ParcelFileDescriptor.open(outputFile, ParcelFileDescriptor.MODE_READ_ONLY)
        val pdfRenderer = PdfRenderer(fileDescriptor)

        for (pageIndex in 0 until pdfRenderer.pageCount) {
            // Render page as bitmap
            val page = pdfRenderer.openPage(pageIndex)
            val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            page.close()

            // Save bitmap to file
            val imageFile = File(outputDir, "${pdfFileName}_page$pageIndex.jpg")
            FileOutputStream(imageFile).use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            }
        }

        // Close PdfRenderer and file descriptor
        pdfRenderer.close()
        fileDescriptor.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

@Throws(IOException::class)
fun downloadFile(urlString: String, outputFile: File) {
    val url = URL(urlString)
    val connection = url.openConnection()
    connection.connect()

    val input = connection.getInputStream()
    val output = FileOutputStream(outputFile)
    val buffer = ByteArray(1024)
    var bytesRead: Int

    while (input.read(buffer).also { bytesRead = it } != -1) {
        output.write(buffer, 0, bytesRead)
    }

    output.close()
    input.close()
}
