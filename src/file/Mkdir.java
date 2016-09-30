package file;

import java.io.File;
import java.io.IOException;

public class Mkdir {

	public static void main(String[] args) {
		//创建文件夹
		File p = new File("D:\\upload");
		if(!p.exists()){
			p.mkdirs();
		}
		//文件夹下创建文件
		File f = new File(p, "a.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//
		File p1 = new File("D:\\upload1", "b.txt");
		if(!p1.exists()){
			try {
				p1.mkdirs();
//				p1.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//删除文件夹下的文件
		File df = new File("D:\\upload", "a.txt");
		if(df.exists()){
			df.delete();
		}
		
		//删除目录下文件夹
		File dd = new File("D:\\upload");
		if(dd.exists()){
			dd.delete();
		}
		if(p1.exists()){
			p1.delete();
		}
		System.out.println(".....");
	}

}
