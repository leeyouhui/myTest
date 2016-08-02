package test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class StringUtils {


	private static final Random rand = new Random();

	/**
	 * 系统目录
	 * 
	 * @return
	 */
	public static String getRealPath() {
		String realPath = StringUtils.class.getClassLoader().getResource("").getFile();
		// String realPath = Class.class.getResource("/").getPath();
		File file = new File(realPath);
		if (realPath.indexOf("bin") > 0) {
			realPath = file.getParentFile().getAbsolutePath();
		} else {
			realPath = file.getAbsolutePath();
		}
		return realPath;
	}

	/**
	 * 时间格式转换
	 * 
	 * @param time
	 * @return MM月dd日 HH点mm分
	 */
	public static String long2DateString(Long time) {
		SimpleDateFormat format = new SimpleDateFormat("MM月dd日 HH点mm分");
		if (time != null) {
			if (time.longValue() != 0) {
				return format.format(new Date(time.longValue()));
			}
		}
		return null;
	}

	/**
	 * 获取uuid
	 * 
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 随机数
	 * 
	 * @return
	 */
	public static int getRanNumber() {
		return rand.nextInt(Integer.MAX_VALUE);
	}

	/**
	 * 改进的32位FNV算法1
	 * 
	 * @param data
	 *            字符串
	 * @return int值
	 */
	public static int FNVHash1(String data) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < data.length(); i++) {
			hash = (hash ^ data.charAt(i)) * p;
		}
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		return Math.abs(hash);
	}

	/**
	 * SDBM算法
	 */
	public static int SDBMHash(String str) {
		int hash = 0;
		for (int i = 0; i < str.length(); i++) {
			hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
		}
		return (hash & 0x7FFFFFFF);
	}

	public static void main(String[] args) {

		// System.getProperty("user.dir");
		System.out.println(StringUtils.FNVHash1("533a1ca238b64828b3571cddf86628be"));
		System.out.println(StringUtils.SDBMHash("533a1ca238b64828b3571cddf86628be"));

		// currentDate.getTime();

		// String d = StringUtils.long2DateString(System.currentTimeMillis());
		// System.out.println(d);
		// System.out.println(long2DateString(1410397901454L));
		// for(int i = 0; i < 10; i++) {
		// System.out.println(getRanNumber());
		// }

	}

}
