package tp2;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;

/**Finds files within a root directory and optionally its
*subdirectories which match an array of extensions. When the
*extensions is null all files will be returned.

*This method will returns matched file as java.io.File */

public class BuscadorDeArchivos{
	
	public static void main(String[] args) {
		File root = new File("/home/foobar/Personal/Examples");
		
		try {
			String[] extensions = {"xml", "java", "dat"};
			boolean recursive = true;




Collection files = FileUtils.listFiles(root, extensions, recursive);
for (Iterator iterator = files.iterator(); iterator.hasNext();) {
File file = (File) iterator.next();
System.out.println("File = " + file.getAbsolutePath());
}
} catch (Exception e) {
e.printStackTrace();
}
}
}