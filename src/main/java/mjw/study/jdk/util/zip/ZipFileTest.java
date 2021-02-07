/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mjw.study.jdk.util.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author  JiaweiMao
 * @date	Mar 12, 2016 4:35:20 PM
 */
public class ZipFileTest {
	/**
	 * 压缩单个文件
	 * ZipFile用于压缩文件
	 * @param filePath
	 * @param zipPath
	 */
	public static void zipFile(String filePath, String zipPath){
		File file = new File(filePath);
		File zipFile = new File(zipPath);
		try
		{
			InputStream input = new FileInputStream(file);
			ZipOutputStream zipOutputStream= new ZipOutputStream(new FileOutputStream(zipFile));
			zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
			int tmp = 0;
			while((tmp = input.read()) != -1){
				zipOutputStream.write(tmp);
			}
			input.close();
			zipOutputStream.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 压缩多个文件
	 * @param filePath
	 * @param zipPath
	 */
	public static void zipMultiFile(String filePath, String zipPath){
		try {
	        File file = new File(filePath);// 要被压缩的文件夹
	        File zipFile = new File(filePath);
	        InputStream input = null;
	        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
	        if(file.isDirectory()){
	            File[] files = file.listFiles();
	            for(int i = 0; i < files.length; ++i){
	                input = new FileInputStream(files[i]);
	                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));
	                int temp = 0;
	                while((temp = input.read()) != -1){
	                    zipOut.write(temp);
	                }
	                input.close();
	            }
	        }
	        zipOut.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**  解压缩（解压缩单个文件）*/
	public static void ZipContraFile(String zippath ,String outfilepath ,String filename) {
	    try {
	        File file = new File(zippath);//压缩文件路径和文件名
	        File outFile = new File(outfilepath);//解压后路径和文件名
	        ZipFile zipFile = new ZipFile(file);
	        ZipEntry entry = zipFile.getEntry(filename);//所解压的文件名
	        InputStream input = zipFile.getInputStream(entry);
	        OutputStream output = new FileOutputStream(outFile);
	        int temp = 0;
	        while((temp = input.read()) != -1){
	            output.write(temp);
	        }
	        input.close();
	        output.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	/**  解压缩（压缩文件中包含多个文件）可代替上面的方法使用。
	 * ZipInputStream类
	 * 当我们需要解压缩多个文件的时候，ZipEntry就无法使用了，
	 * 如果想操作更加复杂的压缩文件，我们就必须使用ZipInputStream类
	 * */
	public static void ZipContraMultiFile(String zippath ,String outzippath){
	    try {
	        File file = new File(zippath);
	        File outFile = null;
	        ZipFile zipFile = new ZipFile(file);
	        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
	        ZipEntry entry = null;
	        InputStream input = null;
	        OutputStream output = null;
	        while((entry = zipInput.getNextEntry()) != null){
	            System.out.println("解压缩" + entry.getName() + "文件");
	            outFile = new File(outzippath + File.separator + entry.getName());
	            if(!outFile.getParentFile().exists()){
	                outFile.getParentFile().mkdir();
	            }
	            if(!outFile.exists()){
	                outFile.createNewFile();
	            }
	            input = zipFile.getInputStream(entry);
	            output = new FileOutputStream(outFile);
	            int temp = 0;
	            while((temp = input.read()) != -1){
	                output.write(temp);
	            }
	            input.close();
	            output.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args){
		ZipFileTest.zipFile("D:/a/Version.hpp", "D:/a/Version.zip");
	}
}
