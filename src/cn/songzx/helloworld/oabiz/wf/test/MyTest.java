/**
* @Title: MyTest.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��23�� ����10:50:35
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyTest
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��23�� ����10:50:35
 *
 */
public class MyTest {

	public static void main(String[] args) throws Exception {

		List<String> list = new ArrayList<String>();
		list.add("�����");
		try {
			System.out.println(list.get(0));
		} catch (Exception e) {
			throw new Exception("���쳣�ˣ�\r\n" + e.getMessage());
		} finally {
			System.out.println("������ĳ��쳣�ˣ�զ�����������ִ���أ�");
		}
		System.out.println("������������������ˣ��Ⱦ���ףһ�£�");
	}

}
