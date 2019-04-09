package com.danhuang.commonsio;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import sun.invoke.empty.Empty;

/*
 * 列出子孙级
 */
public class ListChildrenFile {
	public static void main(String[] args) {
		// 查看本级
		Collection<File> files = FileUtils.listFilesAndDirs(new File("src/com/danhuang"), EmptyFileFilter.NOT_EMPTY,
				null);// 第二个参数过滤文件 第三个过滤目录
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("------------");
		// 查看子孙级
		files = FileUtils.listFilesAndDirs(new File("src/com/danhuang/commonsio"), EmptyFileFilter.NOT_EMPTY,
				DirectoryFileFilter.INSTANCE);// 第二个参数过滤文件 第三个过滤目录
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("-------------");
		// 针对性单个过滤
		files = FileUtils.listFilesAndDirs(new File("src/com/danhuang/commonsio"), new SuffixFileFilter("java"),
				DirectoryFileFilter.INSTANCE);// 第二个参数过滤文件 第三个过滤目录
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("---------");
		// 针对性组合过滤 有or和and
		files = FileUtils.listFilesAndDirs(new File("src/com/danhuang/commonsio"),
				FileFilterUtils.or(new SuffixFileFilter("class"), new SuffixFileFilter("java"), EmptyFileFilter.EMPTY),
				DirectoryFileFilter.INSTANCE);// 第二个参数过滤文件 第三个过滤目录
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
