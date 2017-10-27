/**
* @Title: OABizUtil.java
* @Package cn.songzx.helloworld.oabiz.util
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 下午1:48:21
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import cn.songzx.helloworld.workflow.dao.enmu.CommonExecuteStatus;

/**
 * @ClassName: OABizUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 下午1:48:21
 *
 */
public class OABizUtil implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -2983265915023442957L;

	private static ThreadLocal<SimpleDateFormat> SDF_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();

	private static ThreadLocal<StringBuilder> STRBUI_THREAD_LOCAL = new ThreadLocal<StringBuilder>();

	/**
	 *
	 * @Date: 2017年10月23日下午2:01:51
	 * @Title: generateThirtySixUUIDPK
	 * @Description: TODO(随机生成36位UUID)
	 * @return
	 * @return String 返回值类型
	 */
	public static String generateThirtySixUUIDPK() {
		return UUID.randomUUID().toString();
	}

	/**
	 *
	 * @Date: 2017年10月23日下午5:56:22
	 * @Title: fileToZip
	 * @Description: TODO(将指定文件夹下面的文件打包成*.zip文件)
	 * @param sourceFilePath
	 *            待压缩的文件路径
	 * @param zipFilePath
	 *            压缩后存放路径
	 * @param fileName
	 *            压缩后文件的名称
	 * @return
	 * @return String 返回值类型
	 */
	public static String fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
		// 调用内部类的打包方法，对指定文件夹路径下的文件进行*.zip格式的打包操作
		boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
		if (flag) {
			return CommonExecuteStatus.SUCCESS.name();
		} else {
			return CommonExecuteStatus.FAILURE.name();
		}
	}

	/**
	 *
	 * @Date: 2017年10月23日下午2:01:29
	 * @Title: generateNineteenUUIDPK
	 * @Description: TODO(随机生成19位UUID)
	 * @return
	 * @return String 返回值类型
	 */
	public static String generateNineteenUUIDPK() {
		return Numbers.generateNineteenUUID();
	}

	/**
	 *
	 * @Date: 2017年10月23日下午2:00:57
	 * @Title: copyProperties
	 * @Description: TODO(复制两个对象间的相同名称属性的值)
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @return void 返回值类型
	 */
	public static void copyProperties(Object source, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(source, target);
	}

	/**
	 *
	 * @Date: 2017年10月23日下午1:59:41
	 * @Title: copyProperties
	 * @Description: TODO(复制两个对象间的相同名称属性的值)
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            本次复制中需要排除的属性名称数组
	 * @return void 返回值类型
	 */
	public static void copyProperties(Object source, Object target, String[] ignoreProperties) {
		org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
	}

	/**
	 *
	 * @Date: 2017年10月23日下午2:03:35
	 * @Title: getCurrentTimestamp
	 * @Description: TODO(获取当前日期时间)
	 * @return
	 * @return Timestamp 返回值类型
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 *
	 * @Date: 2017年10月27日下午1:56:41
	 * @Title: getNowDateTimeString
	 * @Description: TODO(返回指定格式的字符串类型日期时间)
	 * @param pattern
	 *            指定日期格式，例如：yyyy-MM-dd HH:mm:ss.SSS
	 * @return
	 * @return String 返回值类型
	 */
	public static String getNowDateTimeString(String pattern) {
		String nowDateTime = "";
		try {
			SDF_THREAD_LOCAL.set(new SimpleDateFormat(pattern));
			nowDateTime = SDF_THREAD_LOCAL.get().format(new java.util.Date());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SDF_THREAD_LOCAL.remove();
		}
		return nowDateTime;
	}

	/**
	 * 将字符串转换为长整型数字
	 *
	 * @param s
	 *            数字字符串
	 * @param radix
	 *            进制数
	 * @return
	 */
	public static long toNumber(String s, int radix) {
		return Numbers.toNumber(s, radix);
	}

	/**
	 *
	 * @Date: 2017年10月27日下午4:08:32
	 * @Title: getTargetObjectToString
	 * @Description: TODO(获得目标对象的属性信息)
	 * @param target
	 *            目标对象
	 * @return
	 * @return String 返回值类型
	 */
	public static String getTargetObjectToString(Object target) {
		System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了set(new StringBuilder())方法！");
		STRBUI_THREAD_LOCAL.set(new StringBuilder("{"));
		StringBuilder strBui = STRBUI_THREAD_LOCAL.get();
		try {
			Class<?> targetClazz = target.getClass();
			if (targetClazz != null) {
				Field[] fields = targetClazz.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					field.setAccessible(true);
					strBui.append("\"" + field.getName() + "\":\"" + field.get(target) + "\"");
					if (i == fields.length - 1) {
						strBui.append("}");
					} else {
						strBui.append(",");
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			STRBUI_THREAD_LOCAL.remove();
			System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了remove()方法！");
		}
		return strBui.toString();
	}

	/**
	 *
	 * @ClassName: Numbers
	 * @Description: TODO(内部类)
	 * @author Songzx songzx_2326@163.com
	 * @date 2017年10月23日 下午1:53:40
	 *
	 */
	private static class Numbers {
		final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		final static Map<Character, Integer> digitMap = new HashMap<Character, Integer>();

		static {
			for (int i = 0; i < digits.length; i++) {
				digitMap.put(digits[i], (int) i);
			}
		}

		/**
		 * 支持的最大进制数
		 */
		public static final int MAX_RADIX = digits.length;

		/**
		 * 支持的最小进制数
		 */
		public static final int MIN_RADIX = 2;

		/**
		 * 将长整型数值转换为指定的进制数（最大支持62进制，字母数字已经用尽）
		 *
		 * @param i
		 * @param radix
		 * @return
		 */
		public static String toString(long i, int radix) {
			if (radix < MIN_RADIX || radix > MAX_RADIX)
				radix = 10;
			if (radix == 10)
				return Long.toString(i);

			final int size = 65;
			int charPos = 64;

			char[] buf = new char[size];
			boolean negative = (i < 0);

			if (!negative) {
				i = -i;
			}

			while (i <= -radix) {
				buf[charPos--] = digits[(int) (-(i % radix))];
				i = i / radix;
			}
			buf[charPos] = digits[(int) (-i)];

			if (negative) {
				buf[--charPos] = '-';
			}

			return new String(buf, charPos, (size - charPos));
		}

		static NumberFormatException forInputString(String s) {
			return new NumberFormatException("For input string: \"" + s + "\"");
		}

		/**
		 * 将字符串转换为长整型数字
		 *
		 * @param s
		 *            数字字符串
		 * @param radix
		 *            进制数
		 * @return
		 */
		public static long toNumber(String s, int radix) {
			if (s == null) {
				throw new NumberFormatException("null");
			}

			if (radix < MIN_RADIX) {
				throw new NumberFormatException("radix " + radix + " less than Numbers.MIN_RADIX");
			}
			if (radix > MAX_RADIX) {
				throw new NumberFormatException("radix " + radix + " greater than Numbers.MAX_RADIX");
			}

			long result = 0;
			boolean negative = false;
			int i = 0, len = s.length();
			long limit = -Long.MAX_VALUE;
			long multmin;
			Integer digit;

			if (len > 0) {
				char firstChar = s.charAt(0);
				if (firstChar < '0') {
					if (firstChar == '-') {
						negative = true;
						limit = Long.MIN_VALUE;
					} else if (firstChar != '+')
						throw forInputString(s);

					if (len == 1) {
						throw forInputString(s);
					}
					i++;
				}
				multmin = limit / radix;
				while (i < len) {
					digit = digitMap.get(s.charAt(i++));
					if (digit == null) {
						throw forInputString(s);
					}
					if (digit < 0) {
						throw forInputString(s);
					}
					if (result < multmin) {
						throw forInputString(s);
					}
					result *= radix;
					if (result < limit + digit) {
						throw forInputString(s);
					}
					result -= digit;
				}
			} else {
				throw forInputString(s);
			}
			return negative ? result : -result;
		}

		/**
		 *
		 * @Date: 2017年10月23日下午2:01:29
		 * @Title: generateNineteenUUIDPK
		 * @Description: TODO(随机生成19位UUID)
		 * @return
		 * @return String 返回值类型
		 */
		public static String generateNineteenUUID() {
			UUID uuid = UUID.randomUUID();
			STRBUI_THREAD_LOCAL.set(new StringBuilder());
			System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了set(new StringBuilder())方法！");
			StringBuilder strBui = STRBUI_THREAD_LOCAL.get();
			try {
				strBui.append(digits(uuid.getMostSignificantBits() >> 32, 8));
				strBui.append(digits(uuid.getMostSignificantBits() >> 16, 4));
				strBui.append(digits(uuid.getMostSignificantBits(), 4));
				strBui.append(digits(uuid.getLeastSignificantBits() >> 48, 4));
				strBui.append(digits(uuid.getLeastSignificantBits(), 12));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				STRBUI_THREAD_LOCAL.remove();
				System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了remove()方法！");
			}
			return strBui.toString();
		}

		private static String digits(long val, int digits) {
			long hi = 1L << (digits * 4);
			return Numbers.toString(hi | (val & (hi - 1)), Numbers.MAX_RADIX).substring(1);
		}
	}

	private static class FileToZip implements Serializable {

		/**
		 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
		 */
		private static final long serialVersionUID = 5003427016419332738L;

		/**
		 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
		 *
		 * @param sourceFilePath
		 *            :待压缩的文件路径
		 * @param zipFilePath
		 *            :压缩后存放路径
		 * @param fileName
		 *            :压缩后文件的名称
		 * @return
		 */
		public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
			boolean flag = false;
			File sourceFile = new File(sourceFilePath);
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			FileOutputStream fos = null;
			ZipOutputStream zos = null;

			if (sourceFile.exists() == false) {
				System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
			} else {
				try {
					File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
					if (zipFile.exists()) {
						System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
					} else {
						File[] sourceFiles = sourceFile.listFiles();
						if (null == sourceFiles || sourceFiles.length < 1) {
							System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
						} else {
							fos = new FileOutputStream(zipFile);
							zos = new ZipOutputStream(new BufferedOutputStream(fos));
							byte[] bufs = new byte[1024 * 10];
							for (int i = 0; i < sourceFiles.length; i++) {
								// 创建ZIP实体，并添加进压缩包
								ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
								zos.putNextEntry(zipEntry);
								// 读取待压缩的文件并写进压缩包里
								fis = new FileInputStream(sourceFiles[i]);
								bis = new BufferedInputStream(fis, 1024 * 10);
								int read = 0;
								while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
									zos.write(bufs, 0, read);
								}
							}
							flag = true;
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				} finally {
					// 关闭流
					try {
						if (null != bis)
							bis.close();
					} catch (IOException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
					try {
						if (null != zos)
							zos.close();
					} catch (IOException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
			return flag;
		}

	}

}
