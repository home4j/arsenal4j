package me.joshua.arsenal4j.demo.image;

import java.io.File;
import java.util.Date;
import java.util.TimeZone;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

/**
 * 提取照片元数据的服务
 * 
 * @author <a href=”mailto:daonan.zhan@gmail.com”>Joshua Zhan</a>
 * @see <a href=”http://www.cppblog.com/lymons/archive/2010/02/23/108266.aspx”>
 *      Exif文件格式描述</a>
 */
public class PictureMetaDataExtractor {

	public Date getTokenDate(File image) {
		Metadata metadata;
		try {
			metadata = ImageMetadataReader.readMetadata(image);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		Directory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
		return directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL, TimeZone.getTimeZone("GMT+8"));
	}
}
