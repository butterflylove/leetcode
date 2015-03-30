package practice;

import java.util.Random;

public class LiftOff{
	
	public static void main(String[] args){
		String[] scope = {"数据挖掘","本体","支持向量机","入侵检测","领域本体","神经网络","web服务","领域建模",
			"软件工程","网格","构件","服务发现","地理信息系统","信息检索","软件开发","软件体系结构","聚类","粗糙集",
			"移动自组织网络","机器学习","无线射频识别","无线传感器网络","向量空间模型","任务调度","专家系统","xml",
			"linux","gprs","高性能计算","频繁模式领域框架","面向服务架构","隐私保护","错误模型量子计算","邮件系统",
			"遗传算法","软件复用","车载信息服务平台","超链接引导的主体搜索","负载均衡","语义相似度","设计模式","计算机辅助评估",
			"计算机技术","蚁群算法","网络编码","网络电视","网络化制造"};
		
		int[] arr = new int[4];
		arr[0]=Math.abs((int)(System.currentTimeMillis()%9));
		int i=1;
		while(i<=3){
			int x=Math.abs((int)(System.currentTimeMillis()%9));
			int j;
			for(j=0;j<i;j++){
				if(x==arr[j])
					break;
			}
			if(j==i){
				arr[i]=x;
				i++;
			}
		}
		for(int gg:arr){
			System.out.println(gg);
		}
	}
	
}
