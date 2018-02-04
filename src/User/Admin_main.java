package User;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class Admin_main {
	public Map<String,Admin>  admins;
	
	public Admin_main(){
		this.admins = new HashMap<String,Admin>();
	}
	
	
	//添加用户的方法
	public void tesPut(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入学生的Id");
		String ID = in.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("请输入用户的姓名");
			String name = in.next();
			System.out.println("请输入用户的性别");
			String sex = in.next();
			//创建对象
			Admin newad = new Admin(name,ID,sex);
			admins.put(ID, newad);
			System.out.println("成功添加用户："+admins.get(ID).getName());
		}else{
			System.out.println("此用户已存在");
		}
	}
	
	//删除用户的方法
	public void delAdmin(){
		Scanner console = new Scanner(System.in);
		System.out.println("请输入要删除的学生的Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("此学生不存在");
			
		}else{
			admins.remove(ID);
			System.out.println("学生ID为"+ID+"的用户已被删除！");
		}
	}
	
	//修改用户的方法
	public void updateAdmin(){
		Scanner console = new Scanner(System.in);
		System.out.println("请输入要修改的学生的Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("此学生不存在");
			
		}else{
			System.out.println("请输入新的姓名");
			String name =console.next();
			System.out.println("请输入性别");
			String sex = console.next();
			ad.setName(name);
			ad.setSex(sex);
			System.out.println("修改成功！");
		}
	}
	
	
	//查询用户的方法
	public void findById(){
		Scanner console = new Scanner(System.in);
		System.out.println("请输入要查询的用户的Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("此用户不存在");
			
		}else{
			
			String name = admins.get(ID).getName();
			String sex = admins.get(ID).getSex();
//			System.out.println(admins.get(ID));
			System.out.println("{ID:"+ID+","+"name:"+name+","+"sex:"+sex+"}");
		}
	}
	
	//查询所有用户的方法
	public void findAll(){
		System.out.println(admins.values());
	}
	
	
	public static void main(String[] args) {
		Admin_main admain =new Admin_main();
		System.out.println("*******欢迎来到用户管理系统，请选择您要执行的操作*******");
		
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("1-添加" + "*****" + "2-删除" + "*****" + "3-修改" + "*****" + "4-查询"+"*****"+"5-查询所有" );
			int item = in.nextInt();

			if(item==1){
				//添加学生信息
				admain.tesPut();
			}else if(item==2){
				//删除单个学生的信息
				admain.delAdmin();
			}else if(item==3){
				//修改用户的信息
				admain.updateAdmin();
			}else if(item==4){
				//查询单个学生的信息
				admain.findById();
			}else if(item==5){
				//查找啊所有学生的信息
				admain.findAll();
			}else{
				System.out.println("操作错误,请重新执行操作 ");
			}
		
		}
	}
}
