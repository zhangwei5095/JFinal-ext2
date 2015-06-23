/**
 * 
 */
package com.jfinal.ext2.upload.filerenamepolicy;

import java.io.File;

/**
 * @author BruceZCQ
 * 自定义文件名称
 */
public class CustomNameFileRenamePolicy extends FileRenamePolicyWrapper {
	
	private String customName = null;

	public CustomNameFileRenamePolicy(String customName) {
		this.customName = customName;
	}

	@Override
	public File nameProcess(File f, String name, String ext) {
		if (null == this.customName) {
			throw new IllegalArgumentException("Please Set Custom File Name!");
		}
		
		String path = f.getParent();
		this.setSaveDirectory(path);
		return (new File(path,this.customName+ext));
	}

}
