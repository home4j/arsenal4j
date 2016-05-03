package me.joshua.arsenal4j.java.tools;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.time.FastDateFormat;

import me.joshua.arsenal4j.java.demo.image.PictureMetaDataExtractor;

public class PictureRenameTool {

	public static void main(String[] args) throws Throwable {
		String path = "C:\\Temp\\pictures";

		PictureMetaDataExtractor extractor = new PictureMetaDataExtractor();
		FastDateFormat format = FastDateFormat.getInstance("yyyyMMdd_HHmmss_");

		File dir = new File(path);
		Iterator<File> itr = FileUtils.iterateFiles(dir, new SuffixFileFilter(new String[] { ".JPG", ".jpg" }),
		        TrueFileFilter.TRUE);
		while (itr.hasNext()) {
			File image = itr.next();
			String name = image.getAbsolutePath();
			Date tokenDate = extractor.getTokenDate(image);
			String newFile = FilenameUtils.getFullPath(name) + format.format(tokenDate)
			        + FilenameUtils.getBaseName(name) + ".jpg";
			System.out.println(newFile);
			FileUtils.moveFile(image, new File(newFile));
		}
	}
}
