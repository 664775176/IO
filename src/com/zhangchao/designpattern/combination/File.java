package com.zhangchao.designpattern.combination;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:File
 * @description: TODO
 * @date 2018/11/21 17:38
 */
public class File implements IFile{

    private String name;
    private IFile folder;

    public File(String name,IFile folder) {
        super();
        this.name = name;
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void delete() {
        folder.deleteFile(name);
        System.out.println("---删除[" + name + "]---");
    }

    //文件不支持创建新文件
    public void createNewFile(String name) {
        throw new UnsupportedOperationException();
    }
    //文件不支持删除文件
    public void deleteFile(String name) {
        throw new UnsupportedOperationException();
    }
    //文件不支持获取下面的文件列表
    public IFile getIFile(int index) {
        throw new UnsupportedOperationException();
    }
    //
    @Override
    public int getFileSize() {
        throw new UnsupportedOperationException();
    }
}
