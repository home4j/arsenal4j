package me.joshua.arsenal4j.demo.image;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.google.common.io.Resources;

public class ImageTests {

	private PictureMetaDataExtractor extractor;
	private File image;

	@Before
	public void init() throws Throwable {
		image = new File(Resources.getResource("image/test.jpg").toURI());
		extractor = new PictureMetaDataExtractor();
	}

	@Test
	public void listTags() throws Throwable {
		Metadata metadata = ImageMetadataReader.readMetadata(image);

		int tagCount = 0;
		for (Directory directory : metadata.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				Assert.assertNotNull(tag.getTagName());
				tagCount++;
				System.out.println(tag);
			}
		}
		Assert.assertTrue(tagCount > 0);
	}

	@Test
	public void testPictureProperties() throws Throwable {
		Date date = extractor.getTokenDate(image);
		Assert.assertNotNull(date);
	}
}
