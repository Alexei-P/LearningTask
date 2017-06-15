package by.epam.classloaderex;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor.INPUT_STREAM;

public class CustomClassLoader extends ClassLoader {
	private byte[] loadClassFileData(String pathToBin) throws IOException {
		System.out.println("getClass() "+getClass()+" ");
		System.out.println("getClass().getClassLoader() "+getClass().getClassLoader()+" ");
		InputStream stream = getClass().getClassLoader().getResourceAsStream(pathToBin);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream inputStream = new DataInputStream(stream);
		inputStream.readFully(buff);
		inputStream.close();
		return buff;
	}

	protected Class findClass(String name) {
		System.out.println("Custom findClass(String "+ name+" ) call");
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] b = null;
		try {
			b = loadClassFileData(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Class c = defineClass(name, b, 0, b.length);
		resolveClass(c);
		return c;
	}

	public Class loadClass(String name) throws ClassNotFoundException {
		System.out.println("Loading Class '" + name + "'");
		if (name.startsWith("by.epam")) {
			System.out.println("Loading Class "+name+" using CustomClassLoader");
			return findClass(name);
		}
		return super.loadClass(name);
	}
	

	public CustomClassLoader(ClassLoader parent) {
		super(parent);
	}


}
