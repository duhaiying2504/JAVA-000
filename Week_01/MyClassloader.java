package dhy.xly.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class
 * 文件所有字节（x=255-x）处理后的文件。文件群里提供
 * 
 * @author duhaiying
 *
 */
public class MyClassloader extends ClassLoader {

	public static void main(String[] args) throws Exception {
		
		Class<?> Hello = new MyClassloader().findClass("Hello");
		Method hello = Hello.getMethod("hello", new Class[]{});
		hello.invoke(Hello.newInstance(), new Object[]{});

	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		byte[] classBytes = this.readClassBytes(name);
		if (classBytes == null) {
			return null;
		}

		return super.defineClass(name, classBytes, 0, classBytes.length);
	}

	private byte[] readClassBytes(String name) {

		byte[] encodeBytes = null;
		InputStream in = null;
		try {
			in = MyClassloader.class.getResource(name + ".xlass").openStream();
			encodeBytes = new byte[in.available()];

			in.read(encodeBytes, 0, in.available());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return encodeBytes != null ? this.decode(encodeBytes) : null;
	}

	private byte[] decode(byte[] encodeBytes) {

		byte[] decodes = new byte[encodeBytes.length];
		for (int i = 0; i < decodes.length; i++) {
			decodes[i] = (byte) ~ encodeBytes[i];
		}

		return decodes;
	}

}
