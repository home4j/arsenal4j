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
package me.joshua.arsenal4j.java.demo.extension.simple;

import me.joshua.arsenal4j.java.demo.extension.Default;

/**
 * 简单扩展点。 没有Wrapper。
 *
 * @author ding.lid
 */
@Default("impl1")
public interface SimpleExt {
	String echo(String s);

	String yell(String s);

	String bang(int i);
}