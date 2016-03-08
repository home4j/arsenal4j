package me.joshua.arsenal4j.tools;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.time.FastDateFormat;

import me.joshua.arsenal4j.demo.image.PictureMetaDataExtractor;

public class BatchRenameTool {

	public static void main(String[] args) throws Throwable {
		PictureMetaDataExtractor extractor = new PictureMetaDataExtractor();
		FastDateFormat format = FastDateFormat.getInstance("yyyyMMdd_HHmmss_");
		String path = "C:\\Users\\daonan.zhan\\Desktop\\照片\\Temp\\[20121214]杭州 百阿163期培训";

		File dir = new File(path);
		FileUtils.forceMkdir(dir);
		for (Iterator<File> itr = FileUtils.iterateFiles(dir, TrueFileFilter.TRUE, TrueFileFilter.TRUE); itr
		        .hasNext();) {
			File f = itr.next();
			f.renameTo(new File(dir, f.getName().substring(16)));
		}
	}
}
