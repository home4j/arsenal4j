/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.joshua.arsenal4j.java.demo.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.hamcrest.core.StringContains;
import org.junit.Test;

import me.joshua.arsenal4j.java.demo.extension.generic.BlankDefaultExt;
import me.joshua.arsenal4j.java.demo.extension.generic.GenericExt;
import me.joshua.arsenal4j.java.demo.extension.generic.IntegerExt;
import me.joshua.arsenal4j.java.demo.extension.simple.SimpleExt;
import me.joshua.arsenal4j.java.demo.extension.simple.SimpleExtImpl1;
import me.joshua.arsenal4j.java.demo.extension.simple.SimpleExtImpl2;
import me.joshua.arsenal4j.java.demo.extension.simple.SimpleExtImpl3;

public class ExtensionLoaderTests {

	private ExtensionLoader<SimpleExt> simpleLoader = ExtensionLoader.getExtensionLoader(SimpleExt.class);

	@Test
	public void test() {
		SimpleExt impl1 = simpleLoader.getExtension("impl1");
		assertTrue(impl1 instanceof SimpleExtImpl1);
		SimpleExt impl2 = simpleLoader.getExtension("impl2");
		assertTrue(impl2 instanceof SimpleExtImpl2);
		SimpleExt impl3 = simpleLoader.getExtension("impl3");
		assertTrue(impl3 instanceof SimpleExtImpl3);
		assertEquals(3, simpleLoader.getLoadedExtensions().size());
	}

	@Test(expected = ClassCastException.class)
	public void testGeneric() {
		@SuppressWarnings("rawtypes")
		ExtensionLoader<GenericExt> genericLoader = ExtensionLoader.getExtensionLoader(GenericExt.class);
		IntegerExt ext = genericLoader.getExtension("integer");
		assertNotNull(ext);
		ext = genericLoader.getExtension("long");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlankDefault() {
		ExtensionLoader.getExtensionLoader(BlankDefaultExt.class);
	}

	@Test
	public void testDefault() {
		assertEquals("impl1", simpleLoader.getDefaultName());
		SimpleExt defaultExt = simpleLoader.getDefaultExtension();
		assertTrue(defaultExt instanceof SimpleExtImpl1);
	}

	@Test
	public void testGetExtensionLoader_Null() throws Exception {
		try {
			ExtensionLoader.getExtensionLoader(null);
			fail();
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage(), StringContains.containsString("Extension type == null"));
		}
	}

	@Test
	public void testGetExtensionLoader_NotInterface() throws Exception {
		try {
			ExtensionLoader.getExtensionLoader(ExtensionLoaderTests.class);
			fail();
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage(), StringContains.containsString(
			        "Extension type(class me.joshua.arsenal4j.java.demo.extension.ExtensionLoaderTests) is not interface!"));
		}
	}
}