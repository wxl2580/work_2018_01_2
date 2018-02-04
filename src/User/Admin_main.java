package User;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class Admin_main {
	public Map<String,Admin>  admins;
	
	public Admin_main(){
		this.admins = new HashMap<String,Admin>();
	}
	
	
	//����û��ķ���
	public void tesPut(){
		Scanner in = new Scanner(System.in);
		System.out.println("������ѧ����Id");
		String ID = in.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("�������û�������");
			String name = in.next();
			System.out.println("�������û����Ա�");
			String sex = in.next();
			//��������
			Admin newad = new Admin(name,ID,sex);
			admins.put(ID, newad);
			System.out.println("�ɹ�����û���"+admins.get(ID).getName());
		}else{
			System.out.println("���û��Ѵ���");
		}
	}
	
	//ɾ���û��ķ���
	public void delAdmin(){
		Scanner console = new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ����Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("��ѧ��������");
			
		}else{
			admins.remove(ID);
			System.out.println("ѧ��IDΪ"+ID+"���û��ѱ�ɾ����");
		}
	}
	
	//�޸��û��ķ���
	public void updateAdmin(){
		Scanner console = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�ѧ����Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("��ѧ��������");
			
		}else{
			System.out.println("�������µ�����");
			String name =console.next();
			System.out.println("�������Ա�");
			String sex = console.next();
			ad.setName(name);
			ad.setSex(sex);
			System.out.println("�޸ĳɹ���");
		}
	}
	
	
	//��ѯ�û��ķ���
	public void findById(){
		Scanner console = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ���û���Id");
		String ID = console.next();
		Admin ad  = admins.get(ID);
		if(ad==null){
			System.out.println("���û�������");
			
		}else{
			
			String name = admins.get(ID).getName();
			String sex = admins.get(ID).getSex();
//			System.out.println(admins.get(ID));
			System.out.println("{ID:"+ID+","+"name:"+name+","+"sex:"+sex+"}");
		}
	}
	
	//��ѯ�����û��ķ���
	public void findAll(){
		System.out.println(admins.values());
	}
	
	
	public static void main(String[] args) {
		Admin_main admain =new Admin_main();
		System.out.println("*******��ӭ�����û�����ϵͳ����ѡ����Ҫִ�еĲ���*******");
		
		while(true){
			Scanner in = new Scanner(System.in);
			System.out.println("1-���" + "*****" + "2-ɾ��" + "*****" + "3-�޸�" + "*****" + "4-��ѯ"+"*****"+"5-��ѯ����" );
			int item = in.nextInt();

			if(item==1){
				//���ѧ����Ϣ
				admain.tesPut();
			}else if(item==2){
				//ɾ������ѧ������Ϣ
				admain.delAdmin();
			}else if(item==3){
				//�޸��û�����Ϣ
				admain.updateAdmin();
			}else if(item==4){
				//��ѯ����ѧ������Ϣ
				admain.findById();
			}else if(item==5){
				//���Ұ�����ѧ������Ϣ
				admain.findAll();
			}else{
				System.out.println("��������,������ִ�в��� ");
			}
		
		}
	}
}
